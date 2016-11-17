package sync;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		SimpleArray sharedSimpleArray = new SimpleArray(6);
		
		ArrayWriter writer1 = new ArrayWriter(1, sharedSimpleArray);
		ArrayWriter writer2 = new ArrayWriter(13, sharedSimpleArray);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(writer1);
		executor.execute(writer2);
		executor.shutdown();
		
		boolean tasksEnded;
		try {
			tasksEnded = executor.awaitTermination(1, TimeUnit.MINUTES);
		
			if (tasksEnded) {
				System.out.println(sharedSimpleArray);
			}else
				System.out.println("Time out while waiting for tasks to finish");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Interrupted while waiting for tasks to finish");
		}
			
	}
}
