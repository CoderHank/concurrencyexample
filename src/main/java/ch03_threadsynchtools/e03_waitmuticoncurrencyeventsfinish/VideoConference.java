package ch03_threadsynchtools.e03_waitmuticoncurrencyeventsfinish;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Hank on 2015/4/1.
 */
public class VideoConference implements Runnable {
    private final CountDownLatch controller;

    public VideoConference(int number){
        controller = new CountDownLatch(number);
    }

    public void arrive(String name){
        System.out.printf("%s has arrived", name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants\n", controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n", controller.getCount());
        try{
            controller.await();
            System.out.printf("VideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
