package ch04_threadexecutor.e02_createfixedsizethreadexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Hank on 2015/4/2.
 */
public class Server {
    private ThreadPoolExecutor executor;

    public Server(){
        executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
    }

    public void executeTask(Task task){
        System.out.printf("Server: A new task has arrived\n");
        executor.execute(task);

        /**
         *  getPoolSize()：此方法返回线程池实际的线程数。
         *  getActiveCount()：此方法返回在执行者中正在执行任务的线程数。
         *  getCompletedTaskCount()：此方法返回执行者完成的任务数
         *  getActiveCount()：显示有多少个任务已经提交给执行者
         */
        System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
        System.out.printf("Server: Task Count: %d \n", executor.getTaskCount());
    }

    public void endServer(){
        executor.shutdown();
    }


}
