package ch02_basicthreadsynch.e03_useconditioninsynch;

import ch02_basicthreadsynch.e01_synchmethod.Company;

/**
 * Created by Hank on 2015/3/26.
 */
public class Consumer implements Runnable {
    private EventStorage storage;

    public Consumer(EventStorage storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.get();
        }
    }
}
