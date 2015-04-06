package ch04_threadexecutor.e07_scheduleexecuteatask;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * scheduleAtFixedRate() 方法返回ScheduledFuture对象，
 * 它继承Future接口，这个方法和调度任务一起协同工作。
 * ScheduledFuture是一个参数化接口（校对注：ScheduledFuture<V>）。
 * 在这个示例中，由于你的任务是非参数化的Runnable对象，你必须使用 问号作为参数。
 * 你已经使用ScheduledFuture接口的一个方法。getDelay()方法返回直到任务的下次执行时间
 *
 * Created by Hank on 2015/4/5.
 */
public class Main {
    public static void main(String[] args){
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        System.out.printf("Main: Starting at: %s\n", new Date());
        Task task = new Task("Task");

        ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
        for (int i = 0; i < 10; i++) {
            System.out.printf("Main: Delay: %d\n", result.getDelay(TimeUnit.MILLISECONDS));
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * 当你使用 shutdown()方法时，你也可以通过参数配置一个SeduledThreadPoolExecutor的行为。
         * shutdown()方法默认的行为是，当你调用这个方法时，计划任务就结束。
         * 你可以使用ScheduledThreadPoolExecutor类的 setContinueExistingPeriodicTasksAfterShutdownPolicy()方法设置true值改变这个行为。
         * 在调用 shutdown()方法时，周期性任务将不会结束
         */
        executor.shutdown();
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.printf("Main: Finished at: %s\n", new Date());
    }
}
