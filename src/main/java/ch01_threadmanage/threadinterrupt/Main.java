package ch01_threadmanage.threadinterrupt;

import java.util.concurrent.TimeUnit;

/**
 * Created by Hank on 2015/3/20.
 */
public class Main {
    public static void main(String[] args){
        Thread task = new PrimeGenerator();
        task.start();
        try{
            TimeUnit.SECONDS.sleep(10);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        task.interrupt();
    }
}
