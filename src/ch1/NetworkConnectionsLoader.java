package ch1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionsLoader implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("Begining network connection  loading: %s\n",new Date());
		try{
			TimeUnit.SECONDS.sleep(6);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.printf("Network connection loading has finished:%s\n",new Date());
	}
	
	public static void main(String[] args) {
		DataSourceLoader dsLoader = new DataSourceLoader();
		Thread thread1= new Thread(dsLoader,"DataSourceThread");
		NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
		Thread thread2 = new Thread(ncLoader,"networkConnectionLoader");
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("Main:Configuration has been loaded %s\n",new Date());
	}
}
