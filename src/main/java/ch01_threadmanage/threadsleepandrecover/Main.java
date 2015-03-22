package ch01_threadmanage.threadsleepandrecover;


import java.util.concurrent.TimeUnit;

/**
 * Created by Hank on 2015/3/21.
 */
public class Main {

    public static void main(String[] args){
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
