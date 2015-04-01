package ch03_threadsynchtools.e05_runconcurrencyphasetask;

import java.util.concurrent.Phaser;

/**
 * 使用Phaser类运行阶段性的并发任务。
 * 当某些并发任务是分成多个步骤来执行时，那么此机制是非常有用的。
 * Phaser类提供的机制是在每个步骤的结尾同步线程，所以除非全部线程完成第一个步骤，
 * 否则线程不能开始进行第二步
 *
 * Created by Hank on 2015/4/1.
 */
public class Main {
    public static void main(String[] args){
        Phaser phaser = new Phaser(3);
        FileSearch system = new FileSearch("C:\\Windows","log", phaser);
        FileSearch apps = new FileSearch("C:\\Program Files", "log", phaser);
        FileSearch documents = new FileSearch("C:\\Documents And Settings","log", phaser);

        Thread systemThread = new Thread(system, "Sytem");
        systemThread.start();

        Thread appsThread = new Thread(apps, "Apps");
        appsThread.start();

        Thread documentsThread = new Thread(documents, "Documents");
        documentsThread.start();

        try{
            systemThread.join();
            appsThread.join();
            documentsThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Termnated: "+ phaser.isTerminated());
    }
}
