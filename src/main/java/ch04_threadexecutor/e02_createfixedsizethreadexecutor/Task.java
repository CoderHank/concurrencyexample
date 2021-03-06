package ch04_threadexecutor.e02_createfixedsizethreadexecutor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Hank on 2015/4/2.
 */
public class Task implements Runnable {
    private Date initDate;
    private String name;

    public Task(String name){
        initDate = new Date();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Task %s: Created on: %s\n", Thread.currentThread().getName(), name, initDate);
        System.out.printf("%s: Task %s Started on: %s\n", Thread.currentThread().getName(), name, new Date());

        try{
            long duration = (long)(Math.random() * 10);
            System.out.printf("%s: Task %s: Doing a task during %d seconds\n", Thread.currentThread().getName(), name, duration);
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.printf("%s: Task %s: Finished on: %s\n", Thread.currentThread().getName(), name, new Date());
    }
}
