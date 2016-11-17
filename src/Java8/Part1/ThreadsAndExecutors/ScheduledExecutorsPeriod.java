package Java8.Part1.ThreadsAndExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorsPeriod {
	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		
		Runnable task = () -> {
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Scheduling: " + System.nanoTime());
			} catch (Exception e) {
				System.out.println("task interrupted");
			}
		};
		
		executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
	}
}
