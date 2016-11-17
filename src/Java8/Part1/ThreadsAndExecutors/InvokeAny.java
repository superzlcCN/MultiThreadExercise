package Java8.Part1.ThreadsAndExecutors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InvokeAny {
	static Callable<String> callable(String result, long sleepSeconds) {
		return () -> {
			TimeUnit.SECONDS.sleep(sleepSeconds);
			return result;
		};
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		List<Callable<String>> callables = Arrays.asList(
				callable("task1" , 1),
				callable("task2", 2),
				callable("task3", 3));
		ExecutorService executorService = Executors.newWorkStealingPool();
		String result = executorService.invokeAny(callables);
		System.out.println(result);
	}
}
