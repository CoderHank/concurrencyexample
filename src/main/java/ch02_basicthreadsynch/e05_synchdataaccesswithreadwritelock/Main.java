package ch02_basicthreadsynch.e05_synchdataaccesswithreadwritelock;

/**
 * Created by Hank on 2015/3/30.
 */
public class Main {
    public static void main(String[] args){
        PriceInfo priceInfo = new PriceInfo();
        Reader[] readers = new Reader[5];
        Thread[] readThreads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(priceInfo);
            readThreads[i] = new Thread(readers[i]);
        }

        Writer writer = new Writer(priceInfo);
        Thread writeThread = new Thread(writer);

        for (int i = 0; i < 5; i++) {
            readThreads[i].start();
        }

        writeThread.start();
    }
}
