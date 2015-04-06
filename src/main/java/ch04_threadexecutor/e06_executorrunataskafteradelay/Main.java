package ch04_threadexecutor.e06_executorrunataskafteradelay;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 你可以配置ScheduledThreadPoolExecutor的行为，当你调用shutdown()方法时，
 * 并且有待处理的任务正在等待它们延迟结束。默认的行为是，不管执行者是否结束这些任务都将被执行。
 * 你可以使用ScheduledThreadPoolExecutor类的setExecuteExistingDelayedTasksAfterShutdownPolicy()方法来改变这种行为。
 * 使用false，调用 shutdown()时，待处理的任务不会被执行
 *
 * Created by Hank on 2015/4/4.
 */
public class Main {
    public static void main(String[] args){
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);

        System.out.printf("Main: Starting at: %s\n", new Date());

        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task_" + i);
            executor.schedule(task, i + 1, TimeUnit.SECONDS);

        }

        executor.shutdown();

        // 等待所有任务完成
        try{
            executor.awaitTermination(1, TimeUnit.DAYS);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.printf("Main: Ends at: %s\n", new Date());
    }
}
