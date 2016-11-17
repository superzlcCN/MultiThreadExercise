package ch2;
import java.util.Iterator;

public class Bank implements Runnable{
	private Account account;
	public Bank(Account account){
		this.account = account;
	}
	
	public void run() {
		for(int i = 0; i < 100; i++)
			account.substractAmount(1000);
	};
}
