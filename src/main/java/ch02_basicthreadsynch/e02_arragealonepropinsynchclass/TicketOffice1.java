package ch02_basicthreadsynch.e02_arragealonepropinsynchclass;

/**
 * Created by Hank on 2015/3/26.
 */
public class TicketOffice1 implements Runnable{
    private Cinema cinema;

    public TicketOffice1(Cinema cinema){
        this.cinema = cinema;
    }

    @Override
    public void run() {
        cinema.sellTickets1(3);
        cinema.sellTickets1(4);
        cinema.returnTickets1(3);
        cinema.sellTickets1(4);
        cinema.sellTickets2(10);
        cinema.returnTickets2(10);
        cinema.sellTickets2(5);
        cinema.sellTickets1(2);
        cinema.returnTickets1(10);
        cinema.returnTickets2(5);
    }
}
