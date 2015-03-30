package ch02_basicthreadsynch.e05_synchdataaccesswithreadwritelock;

import java.util.concurrent.TimeUnit;

/**
 * Created by Hank on 2015/3/30.
 */
public class Writer implements Runnable {
    private PriceInfo priceInfo;

    public Writer(PriceInfo priceInfo){
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("Writer: Attempt to modify the prices.\n");
            priceInfo.setPrices(Math.random()*10, Math.random()*8);
            try {
                TimeUnit.MILLISECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
