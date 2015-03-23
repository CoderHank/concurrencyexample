package ch01_threadmanage.createthreadbyfactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Hank on 2015/3/23.
 */
public class Task implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
