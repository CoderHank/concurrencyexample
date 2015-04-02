package ch04_threadexecutor.e03_executereturnresult;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Hank on 2015/4/2.
 */
public class Main {
    public static void main(String[] args){
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Integer number = random.nextInt(10);
            FactorialCalculator calculator = new FactorialCalculator(number);
            Future<Integer> result = executor.submit(calculator);
            futureList.add(result);
        }

        do{
            System.out.printf("Main : Number of Completed Tasks: %d\n", executor.getCompletedTaskCount());

            for (int i = 0; i < futureList.size(); i++) {
                Future<Integer> result = futureList.get(i);
                System.out.printf("Main : Task %d: %s\n", i , result.isDone());
            }

            try{
                TimeUnit.MILLISECONDS.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }while (executor.getCompletedTaskCount() < futureList.size());

        System.out.printf("Main: Results\n");

        for (int i = 0; i < futureList.size(); i++) {
            Future<Integer> result = futureList.get(i);
            Integer number = null;
            try {
                number = result.get();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.printf("Main: Task %d: %d\n", i , number);
        }

        executor.shutdown();

    }
}
