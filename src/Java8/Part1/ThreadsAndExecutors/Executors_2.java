package Java8.Part1.ThreadsAndExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executors_2 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		try{
			System.out.println("Attempt to shutdown executor");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		}catch(InterruptedException e){
			System.out.println("Tasks interrupted");
		}
		finally {
			if (!executor.isTerminated()) {
				System.err.println("cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("Shutdown finished");
		}
	}
}
