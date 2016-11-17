package ch1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
	private ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
		protected Date initialValue() {
			return new Date();
		}
	};
	
	public void run() {
		System.out.printf("Starting thread : %s : %s \n",Thread.currentThread().getId(),
				startDate.get());
		
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("Thread finished: %s : %s \n",Thread.currentThread().getId(),
				startDate.get());
	};
	
	public static void main(String[] args) {
		SafeTask safeTask = new SafeTask();
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(safeTask);
			thread.start();
			try{
				TimeUnit.SECONDS.sleep(3);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
}
