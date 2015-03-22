package ch01_threadmanage.uselocalthreadvariabe;

import java.util.concurrent.TimeUnit;

/**
 * Created by Hank on 2015/3/21.
 */
public class Main {
    public static void main(String[] args){
//        UnsafeTask task = new UnsafeTask();
        SafeTask task = new SafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
