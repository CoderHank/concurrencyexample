package ch03_threadsynchtools.e04_synchtaskatonesamepoint;

/**
 * Created by Hank on 2015/4/1.
 */
public class Grouper implements Runnable {
    private Results results;

    public Grouper(Results results){
        this.results = results;
    }

    @Override
    public void run() {
        int finalResult = 0;
        System.out.printf("Grouper: Processing results...\n");
        for(int data : results.getData()){
            finalResult += data;
        }

        System.out.printf("Grouper: Total result: %d.\n", finalResult);
    }
}
