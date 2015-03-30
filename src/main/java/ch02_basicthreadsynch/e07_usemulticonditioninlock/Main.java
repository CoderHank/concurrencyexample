package ch02_basicthreadsynch.e07_usemulticonditioninlock;

/**
 * 一个锁可能伴随着多个条件。这些条件声明在Condition接口中。
 * 这些条件的目的是允许线程拥有锁的控制并且检查条件是否为true，如果是false，
 * 那么线程将被阻塞，直到其他线程唤醒它们。Condition接口提供一种机制，
 * 阻塞一个线程和唤醒一个被阻塞的线程
 *
 * Created by Hank on 2015/3/30.
 */
public class Main {
    public static void main(String[] args){
        FileMock mock = new FileMock(100, 10);
        Buffer buffer = new Buffer(20);

        Producer producer = new Producer(mock, buffer);
        Thread threadProducer = new Thread(producer, "Producer");

        Consumer[] consumers = new Consumer[3];
        Thread[] threadConsumers = new Thread[3];
        for (int i = 0; i < 3; i++) {
            consumers[i] = new Consumer(buffer);
            threadConsumers[i] = new Thread(consumers[i], "Consumer_"+i);
        }

        threadProducer.start();
        for (int i = 0; i < 3; i++) {
            threadConsumers[i].start();
        }
    }
}
