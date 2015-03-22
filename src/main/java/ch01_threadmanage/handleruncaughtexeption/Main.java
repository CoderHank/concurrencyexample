package ch01_threadmanage.handleruncaughtexeption;

/**
 * Created by Hank on 2015/3/21.
 */
public class Main {
    public static void main(String[] args){
        Task task = new Task();
        Thread thread = new Thread(task);
//        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }

}
