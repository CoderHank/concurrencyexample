package ch04_threadexecutor.e06_executorrunataskafteradelay;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by Hank on 2015/4/4.
 */
public class Task implements Callable<String> {
    private String name;

    public Task(String name){
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("%s: Starting at : %s\n", name, new Date());
        return "Hello, world";
    }
}
