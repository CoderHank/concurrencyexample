package ch03_threadsynchtools.e04_synchtaskatonesamepoint;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Hank on 2015/4/1.
 */
public class Main {
    public static void main(String[] args){
        final int ROWS = 10000;
        final int NUMBERS = 1000;
        final int SEARCH = 5;
        final int PARTICIPANTS = 5;
        final int LINES_PARTICIPANT = 2000;

        MatricMock mock = new MatricMock(ROWS, NUMBERS, SEARCH);
        Results results = new Results(ROWS);
        Grouper grouper = new Grouper(results);
        // 当5个线程结束后，会执行grouper线程
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);
        Searcher[] searchers = new Searcher[PARTICIPANTS];
        for (int i = 0; i < PARTICIPANTS; i++) {
            searchers[i] = new Searcher(i * LINES_PARTICIPANT, (i + 1) * LINES_PARTICIPANT, mock, results, SEARCH, barrier);
            Thread thread = new Thread(searchers[i]);
            thread.start();
        }

        System.out.printf("Main: The main thread has finished.\n");
    }
}
