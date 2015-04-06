package ch04_threadexecutor.e09_executorcontrolatasktofinish;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * FutureTask类提供一个done()方法，允许你在执行者执行任务完成后执行一些代码。
 * 你可以用来做一些后处理操作，生成一个报告，通过e-mail发送结果，或释放一些资源。
 * 当执行的任务由FutureTask来控制完成，FutureTask会内部调用这个方法。
 * 这个方法在任务的结果设置和它的状态变成isDone状态之后被调用，
 * 不管任务是否已经被取消或正常完成。
 * 默认情况下，这个方法是空的。你可以重写FutureTask类实现这个方法来改变这种行为
 *
 * Created by Hank on 2015/4/6.
 */
public class ExecutableTask implements Callable<String> {
    private String name;

    public ExecutableTask(String name){
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        try{
            long duration = (long)(Math.random()*10);
            System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "Hello, world. I'm " + name;
    }

    public String getName() {
        return name;
    }
}
