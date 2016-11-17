package Java8.Part1.ThreadsAndExecutors;

import java.util.concurrent.Executors;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class InvokeAll {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newWorkStealingPool();
		List<Callable<String>> callables = Arrays.asList(
				()->"task1",
				()->"task2",
				()->"task3"
		);
		
		
		executorService.invokeAll(callables)
			.stream()
			.map(future -> {
				try {
					return future.get();
				} catch (Exception e) {
					throw new IllegalStateException(e);
				}
			}).
			forEach(System.out::println);
		
	}
}
