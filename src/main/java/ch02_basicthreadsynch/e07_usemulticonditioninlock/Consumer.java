package ch02_basicthreadsynch.e07_usemulticonditioninlock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Hank on 2015/3/30.
 */
public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(buffer.hasPendingLines()){
            String line = buffer.get();
            processLine(line);
        }
    }

    private void processLine(String line){
        Random random = new Random();
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
