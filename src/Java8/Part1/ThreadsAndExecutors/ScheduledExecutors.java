package Java8.Part1.ThreadsAndExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutors {
	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		Runnable task = () -> System.out.println("Scheduling: "+System.nanoTime()); 
		
		ScheduledFuture<?> future = scheduledExecutorService.schedule(task, 3, TimeUnit.SECONDS);
		TimeUnit.MILLISECONDS.sleep(1333);
		long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
		System.out.printf("Remaining delays %s",remainingDelay);
		
	}
}
