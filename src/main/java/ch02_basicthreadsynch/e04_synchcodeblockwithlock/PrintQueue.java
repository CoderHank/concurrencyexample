package ch02_basicthreadsynch.e04_synchcodeblockwithlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Hank on 2015/3/30.
 */
public class PrintQueue {
    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object document){
        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ":PringQueue: Printing a Job during " + (duration / 1000 + " seconds"));
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            queueLock.unlock();
        }

    }
}
