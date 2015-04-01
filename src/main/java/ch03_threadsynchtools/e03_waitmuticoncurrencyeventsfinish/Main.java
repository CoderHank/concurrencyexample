package ch03_threadsynchtools.e03_waitmuticoncurrencyeventsfinish;

/**
 * Created by Hank on 2015/4/1.
 */
public class Main {
    public static void main(String[] args){
        VideoConference conference = new VideoConference(10);
        Thread threadConference = new Thread(conference);
        threadConference.start();

        for (int i = 0; i < 10; i++) {
            Participant p = new Participant(conference, "Participant_" + i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}
