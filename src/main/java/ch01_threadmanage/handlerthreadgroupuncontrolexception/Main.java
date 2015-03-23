package ch01_threadmanage.handlerthreadgroupuncontrolexception;

/**
 * 当一个非捕捉异常在线程内抛出，JVM会为这个异常寻找3种可能handlers。
 * 首先, 它寻找这个未捕捉的线程对象的异常handle，如在线程中处理不受控制异常中介绍的，
 * 如果这个handle 不存在，那么JVM会在线程对象的ThreadGroup里寻找非捕捉异常的handler，
 * 如果此方法不存在，那么 JVM 会寻找默认非捕捉异常handle。如果没有 handlers存在,
 * 那么 JVM会把异常的 stack trace 写入控制台并结束任务。
 *
 * Created by Hank on 2015/3/23.
 */
public class Main {
    public static void main(String[] args){
        MyThreadGroup threadGroup = new MyThreadGroup("My ThreadGroup");
        Task task = new Task();

        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(threadGroup, task);
            t.start();
        }
    }
}
