package ch04_threadexecutor.e11_executorcontrolrefusedtask;

import java.util.concurrent.TimeUnit;

/**
 * Created by Hank on 2015/4/7.
 */
public class Task implements Runnable {
    private String name;

    public Task(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("Task "+ name + " Starting ");
        try{
            long duration = (long)(Math.random()*10);
            System.out.printf("Task %s: execute during %d seconds\n", name, duration);
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.printf("Task %s: End\n", name);
    }

    @Override
    public String toString(){
        return this.name;
    }
}
