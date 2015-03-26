package ch02_basicthreadsynch.e01_synchmethod;

/**
 * Created by Hank on 2015/3/26.
 */
public class Company implements Runnable {
    private Account account;

    public Company(Account account){
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.account.addAmount(1000);
        }
    }
}
