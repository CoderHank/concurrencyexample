package ch01_threadmanage.operatethreadinterruptemechanism;

import java.util.concurrent.TimeUnit;

/**
 * Created by Hank on 2015/3/20.
 */
public class Main {
    public static void main(String[] args){
        FileSearch search = new FileSearch("E:\\工作文档", "client.jnlp");
        Thread thread = new Thread(search);
        thread.start();

        try{
            TimeUnit.MILLISECONDS.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
