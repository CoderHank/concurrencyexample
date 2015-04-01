package ch03_threadsynchtools.e06_controlconcurrencyphasetaskchange;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by Hank on 2015/4/1.
 */
public class Student implements Runnable{
    private Phaser phaser;

    public Student(Phaser phaser){
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.printf("%s: Has arrived to do the exam.%s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Is going to do the first exercise.%s\n", Thread.currentThread().getName(), new Date());
        doExcercise1();
        System.out.printf("%s: Has done the first exercise.%s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Is going to do the second exercise.%s\n", Thread.currentThread().getName(), new Date());
        doExcercise2();
        System.out.printf("%s: Has done the second exercise.%s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Is going to do the third exercise.%s\n", Thread.currentThread().getName(), new Date());
        doExcercise3();
        System.out.printf("%s: Has done the third exercise.%s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
    }

    private void doExcercise1(){
        try{
            long duration = (long)(Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void doExcercise2(){
        try{
            long duration = (long)(Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void doExcercise3(){
        try{
            long duration = (long)(Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
