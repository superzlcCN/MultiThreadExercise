package ch2;

public class TicketOffice1 implements Runnable{
	
	private Cinema cinema;
	public TicketOffice1(Cinema cinema) {
		// TODO Auto-generated constructor stub
		this.cinema = cinema;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		cinema.sellTicket1(3);
		cinema.sellTicket2(2);
		cinema.sellTicket1(2);
		cinema.returnTicket1(3);
		cinema.sellTicket1(5);
		cinema.sellTicket1(2);
		cinema.sellTicket1(2);
		cinema.sellTicket1(2);
	}
}
