package ch03_threadsynchtools.e02_controlconcurrencyaccessmutiresouces;

/**
 * Created by Hank on 2015/4/1.
 */
public class Main {
    public static void main(String[] args){
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new  Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread_"+ i);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
