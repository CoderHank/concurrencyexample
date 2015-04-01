package ch03_threadsynchtools.e06_controlconcurrencyphasetaskchange;

/**
 * Created by Hank on 2015/4/1.
 */
public class Main {
    public static void main(String[] args){
        MyPhaser phaser = new MyPhaser();
        Student[] students = new Student[5];
        for (int i = 0; i < 5; i++) {
            students[i] = new Student(phaser);
            phaser.register();
        }

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(students[i], "Student_" + i);
            threads[i].start();
        }

        try {
            for (int i = 0; i < 5; i++) {
                threads[i].join();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.printf("Main: The phaser has finished: %s\n", phaser.isTerminated());
    }
}
