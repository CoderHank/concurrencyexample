package ch02_basicthreadsynch.e06_modifyfairoflock;

import java.util.concurrent.TimeUnit;

/**
 *
 * 在ReentrantLock类和 ReentrantReadWriteLock类的构造器中，允许一个名为fair的boolean类型参数，它允许你来控制这些类的行为。
 * 默认值为 false，这将启用非公平模式。在这个模式中，
 * 当有多个线程正在等待一把锁（ReentrantLock或者 ReentrantReadWriteLock），
 * 这个锁必须选择它们中间的一个来获得进入临界区，选择任意一个是没有任何标准的。
 * true值将开启公平 模式。在这个模式中，当有多个线程正在等待一把锁（ReentrantLock或者ReentrantReadWriteLock），
 * 这个锁必须选择它们 中间的一个来获得进入临界区，它将选择等待时间最长的线程
 *
 * Created by Hank on 2015/3/30.
 */
public class Main {
    public static void main(String[] args){
        PrintQueue printQueue = new PrintQueue();
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread_"+ i);
        }

        /**
         * 所有线程都创建一个0.1秒的差异，第一需要获取锁的控制权的线程是Thread0，然后是Thread1，以此类推。
         * 当Thread0正在运行第一个由锁 保护的代码块时，有9个线程正在那个代码块上等待执行。
         * 当Thread0释放锁，它需要马上再次获取锁，所以我们有10个线程试图获取这个锁。
         * 当启用代码 模式，Lock接口将会选择Thread1，它是在这个锁上等待最长时间的线程。
         * 然后，选择Thread2，然后是Thread3，以此类推。直到所有线 程都通过了这个锁保护的第一个代码块，
         * 否则，没有一个线程能执行该锁保护的第二个代码块。
         *
         */
        for (int i = 0; i < 10; i++) {
            thread[i].start();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
