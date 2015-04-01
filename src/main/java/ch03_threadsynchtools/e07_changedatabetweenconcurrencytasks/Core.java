package ch03_threadsynchtools.e07_changedatabetweenconcurrencytasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 *
 * Exchanger 类允许在2个线程间定义同步点，当2个线程到达这个点，他们相互交换数据类型，
 * 使用第一个线程的数据类型变成第二个的，然后第二个线程的数据类型变成第一个的
 *
 * Created by Hank on 2015/4/1.
 */
public class Core {
    public static void main(String[] args){
        List<String> buffer1 = new ArrayList<String>();
        List<String> buffer2 = new ArrayList<String>();

        Exchanger<List<String>> exchanger = new Exchanger<List<String>>();

        Producer producer = new Producer(buffer1, exchanger);
        Consumer consumer = new Consumer(buffer2, exchanger);

        Thread producerThread = new Thread(producer, "Producer");
        Thread consumerThread = new Thread(consumer, "Consumer");

        producerThread.start();
        consumerThread.start();
    }
}
