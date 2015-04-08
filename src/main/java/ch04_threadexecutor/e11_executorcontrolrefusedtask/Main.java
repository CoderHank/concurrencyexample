package ch04_threadexecutor.e11_executorcontrolrefusedtask;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 如果你在shutdown()方法和执行者结束之间，提交任务给执行者，
 * 这个任务将被拒绝，因为执行者不再接收新的任务。ThreadPoolExecutor类提供一种机制，
 * 在调用shutdown()后，不接受新的任务
 *
 * Created by Hank on 2015/4/7.
 */
public class Main {
    public static void main(String[] args){
        RejectedTaskController controller = new RejectedTaskController();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.setRejectedExecutionHandler(controller);
        System.out.printf("Main: Starting.\n");
        for (int i = 0; i < 3; i++) {
            Task task = new Task("Task_" + i);
            executor.submit(task);
        }
        System.out.printf("Main: Shutting down the Executor\n");
        executor.shutdown();

        System.out.printf("Send another task to Executor\n");
        Task task = new Task("Rejected Task");
        executor.submit(task);

        System.out.printf("Main: End\n");
    }
}
