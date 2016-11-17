package ch2;

public class Cinema {
	private long vacaniesCinema1;
	private long vacaniesCinema2;
	
	private final Object controlCinema1,controlCinema2;
	
	public Cinema(){
		controlCinema1 = new Object();
		controlCinema2 = new Object();
		vacaniesCinema1 = 20;
		vacaniesCinema2 = 20;
	}
	
	public boolean sellTicket1 (int number){
		synchronized (controlCinema1) {
			if (number < vacaniesCinema1) {
				vacaniesCinema1 -= number;
				return true;
			}else {
				return false;
			}
		}
	}
	
	public boolean sellTicket2(int number){
		synchronized (controlCinema2) {
			if (number < vacaniesCinema2) {
				vacaniesCinema2 -= number;
				return true;
			}else {
				return false;
			}
		}
	}
	
	public boolean returnTicket1(int number){
		synchronized (controlCinema1) {
			vacaniesCinema1 += number;
			return true;
		}
	}
	
	public boolean returnTicket2(int number){
		synchronized (controlCinema2) {
			vacaniesCinema2 += number;
			return true;
		}
	}
	
	public long getVacaniesCinema1(){
		return vacaniesCinema1;
	}
	
	public long getVacaniesCinema2(){
		return vacaniesCinema2;
	}
}
