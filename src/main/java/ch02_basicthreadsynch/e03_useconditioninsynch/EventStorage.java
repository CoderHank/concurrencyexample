package ch02_basicthreadsynch.e03_useconditioninsynch;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Hank on 2015/3/26.
 */
public class EventStorage {
    private int maxSize;
    private Queue<Date> storage;

    public EventStorage(){
        maxSize = 100;
        storage = new LinkedList<Date>();
    }

    public synchronized void set(){
        while (storage.size() == maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        storage.offer(new Date());
        System.out.printf("Set: %d\n", storage.size());
        notifyAll();
    }

    public synchronized void get(){
        while (storage.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Get: %d: %s\n", storage.size(), storage.poll());
        notifyAll();
    }
}
