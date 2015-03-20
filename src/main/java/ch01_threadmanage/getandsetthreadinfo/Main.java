package ch01_threadmanage.getandsetthreadinfo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;

/**
 * Thread类的对象中保存了一些属性信息能够帮助我们来辨别每一个线程，知道它的状态，调整控制其优先级。 这些属性是：
 * ID: 每个线程的独特标识。
 * Name: 线程的名称。
 * Priority: 线程对象的优先级。优先级别在1-10之间，1是最低级，10是最高级。不建议改变它们的优先级，但是你想的话也是可以的。
 * Status: 线程的状态。在Java中，线程只能有这6种中的一种状态： new, runnable, blocked, waiting, time waiting, 或 terminated.
 *
 * Created by Hank on 2015/3/20.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Thread threads[] = new Thread[10];
        Thread.State status[] = new Thread.State[10];

        for(int i=0; i<10; i++){
            threads[i] = new Thread(new Calculator(i));
            if((i % 2) == 0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else{
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread " + i);
        }

        FileWriter file = new FileWriter("./data/data.txt");
        PrintWriter pw = new PrintWriter(file);

        for(int i=0; i<10; i++){
            pw.println(MessageFormat.format("Main: Status of Thread {0}:{1}", i, threads[i].getState()));
            status[i] = threads[i].getState();
        }

        for(int i=0; i<10; i++){
            threads[i].start();
        }

        boolean finish = false;
        while(! finish){
            for(int i=0; i<10; i++){
                if(threads[i].getState() != status[i]){
                    writeThreadInfo(pw, threads[i], status[i]);
                    status[i] = threads[i].getState();
                }
            }

            finish = true;
            for(int i=0; i< 10; i++){
                finish = finish
                        && (threads[i].getState() == Thread.State.TERMINATED);
            }

            pw.flush();
            pw.close();
        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state){
        pw.printf("Main: ID %d - %s\r\n", thread.getId(), thread.getName());
        pw.printf("Main: Priority: %d\r\n", thread.getPriority());
        pw.printf("Main: Old State: %s\r\n", state);
        pw.printf("Main: New State: %s\r\n", thread.getState());
    }
}
