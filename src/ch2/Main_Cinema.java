package ch2;

public class Main_Cinema {
	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
		Thread thread1 = new Thread(ticketOffice1);
		
		TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
		Thread thread2 = new Thread(ticketOffice2);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.printf("Room 1 vacannies: %d \n",cinema.getVacaniesCinema1());
		System.out.printf("Room 2 vacannies: %d \n",cinema.getVacaniesCinema2());
		
	}
}
