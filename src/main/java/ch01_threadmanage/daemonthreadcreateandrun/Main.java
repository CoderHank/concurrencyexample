package ch01_threadmanage.daemonthreadcreateandrun;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * 当守护线程是程序里唯一在运行的线程时，JVM会结束守护线程并终止程序
 * Created by Hank on 2015/3/21.
 */
public class Main {
    public static void main(String[] args){
        Deque<Event> deque = new ArrayDeque<Event>();
        WriterTask writer = new WriterTask(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writer);
            thread.start();
        }

        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();
    }
}
