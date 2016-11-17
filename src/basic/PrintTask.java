package basic;

import java.util.Random;

public class PrintTask implements  Runnable {
	private final int sleepTime;
	private final String taskName;
	private final Random generator = new Random();
	
	public PrintTask(String name){
		this.taskName = name;
		sleepTime = generator.nextInt(5000);
	}
	
	public void run() {
		
		try {
			System.out.printf("%s going to sleep for %d milliseconds.\n",
					taskName, sleepTime);
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.printf("%s %s \n",taskName,"terminated permaturely due to interruption");
		} // end of catch
		
		System.out.printf("%s done sleeping\n",taskName);
	}
}