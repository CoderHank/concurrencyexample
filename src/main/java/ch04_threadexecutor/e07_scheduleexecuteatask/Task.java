package ch04_threadexecutor.e07_scheduleexecuteatask;

import java.util.Date;

/**
 * Created by Hank on 2015/4/5.
 */
public class Task implements Runnable {
    private String name;

    public Task(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Starting at : %s\n", name, new Date());
    }
}
