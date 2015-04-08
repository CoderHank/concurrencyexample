package ch05_forkjoinframework.e02_addtaskresult;

import java.util.concurrent.RecursiveAction;

/**
 * Created by Hank on 2015/4/8.
 */
public class DocumentTask extends RecursiveAction<Integer> {
    private String[][] document;
    private int start, end;
    private String word;

    public  DocumentTask(String document[][], int start, int end, String word){
        this.document = document;
        this.start = start;
        this.end = end;
        this.word = word;
    }

    @Override
    protected void compute() {
        int result;
        if(end - start < 10){

        }
    }


}
