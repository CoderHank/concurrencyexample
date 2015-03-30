package ch02_basicthreadsynch.e04_synchcodeblockwithlock;

/**
 *
 * Lock 接口（和ReentrantLock类）包含其他方法来获取锁的控制权，那就是tryLock()方法。
 * 这个方法与lock()方法的最大区别是，如果一 个线程调用这个方法不能获取Lock接口的控制权时，
 * 将会立即返回并且不会使这个线程进入睡眠。这个方法返回一个boolean值，
 * true表示这个线程 获取了锁的控制权，false则表示没有
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

        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }
}
