package ch04_threadexecutor.e08_executorcanceltask;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by Hank on 2015/4/5.
 */
public class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        if(true){
            System.out.printf("Task: Test\n");
            TimeUnit.SECONDS.sleep(100);
        }

        return null;
    }
}
