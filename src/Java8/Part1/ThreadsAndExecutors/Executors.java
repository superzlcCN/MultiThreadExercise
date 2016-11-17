package Java8.Part1.ThreadsAndExecutors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class Executors {
	
	public static void main(String[] args) {
		ExecutorService executor = java.util.concurrent.Executors.newSingleThreadExecutor();
		executor.submit(()->{
			String threadName = Thread.currentThread().getName();
			System.out.println("hello " + threadName);
		});
	}
	
}
