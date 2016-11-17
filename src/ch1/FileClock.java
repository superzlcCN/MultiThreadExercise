package ch1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileClock  implements Runnable{
	@Override
	public void run() {
		try {
		// TODO Auto-generated method stub
		for (int i = 0;; i++) {
			System.out.printf("%s\n",new Date());
			
			
			if(Thread.interrupted()){
				throw new InterruptedException();
			}
				//TimeUnit.SECONDS.sleep(1);
			
		}
		} catch (Exception e) {
			System.out.println("The FileClock has been interrupted");
		}
	}
	
	
	
	public static void main(String[] args) {
		
	}
}
