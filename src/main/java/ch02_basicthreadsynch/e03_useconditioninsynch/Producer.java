package ch02_basicthreadsynch.e03_useconditioninsynch;

/**
 * Created by Hank on 2015/3/26.
 */
public class Producer implements Runnable {
    private EventStorage storage;

    public Producer(EventStorage storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }
}
