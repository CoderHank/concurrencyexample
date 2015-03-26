package ch02_basicthreadsynch.e02_arragealonepropinsynchclass;

/**
 * Created by Hank on 2015/3/26.
 */
public class Main {
    public static void main(String[] args){
        Cinema cinema = new Cinema();

        TicketOffice1 office1 = new TicketOffice1(cinema);
        TicketOffice2 office2 = new TicketOffice2(cinema);

        System.out.printf("Initial: vacancy1=%d, vacancy2=%d\n",cinema.getVacanciesCinema1(), cinema.getVacanciesCinema2());

        Thread thread1 = new Thread(office1);
        Thread thread2 = new Thread(office2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Current: vacancy1=%d, vacancy2=%d\n",cinema.getVacanciesCinema1(), cinema.getVacanciesCinema2());

    }
}
