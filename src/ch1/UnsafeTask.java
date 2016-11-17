package ch1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {
	private Date startDate;
	@Override
	public void run() {
		startDate = new Date();
		System.out.printf("Starting Thread %s : %s\n",Thread.currentThread().getId(),startDate);
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.printf("Thread finished: %s : %s \n",Thread.currentThread().getId(),startDate);
	}
	
	public static void main(String[] args) {
		UnsafeTask task = new UnsafeTask();
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(task);
			thread.start();
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
