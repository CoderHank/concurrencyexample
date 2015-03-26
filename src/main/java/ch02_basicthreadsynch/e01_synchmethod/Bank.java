package ch02_basicthreadsynch.e01_synchmethod;

/**
 * Created by Hank on 2015/3/26.
 */
public class Bank implements Runnable {
    private Account account;

    public Bank(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.subtractAmount(1000);
        }
    }
}
