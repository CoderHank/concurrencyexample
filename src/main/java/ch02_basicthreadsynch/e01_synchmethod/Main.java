package ch02_basicthreadsynch.e01_synchmethod;

/**
 *
 * 只有一个线程能访问一个对象的声明为synchronized关键字的方法。
 * 如果一个线程A正在执行一个 synchronized方法，而线程B想要执行同个实例对象的synchronized方法，
 * 它将阻塞，直到线程A执行完。
 * 但是如果线程B访问相同类的不同实例对象，它们都不会被阻塞
 *
 * Created by Hank on 2015/3/26.
 */
public class Main {
    public static void main(String[] args){
        Account account = new Account();
        account.setBalance(100000);
        System.out.printf("Start: Account balance is %f\n", account.getBalance());

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("End: Account balance is %f\n", account.getBalance());
    }
}
