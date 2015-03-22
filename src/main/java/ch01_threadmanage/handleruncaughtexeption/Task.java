package ch01_threadmanage.handleruncaughtexeption;

/**
 * Created by Hank on 2015/3/21.
 */
public class Task implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        int number = Integer.parseInt("TTT");
    }
}
