package Java8.Part1.ThreadsAndExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallablesAndFeatures {
	public static void main(String[] args) {
		try {
				
			Callable<Integer> task = () -> {
				TimeUnit.SECONDS.sleep(1);
				return 123;
			};
		
			ExecutorService executorService = Executors.newFixedThreadPool(1);
			Future<Integer> future = executorService.submit(task);
			
			System.out.println("future done? " + future.isDone());
			
			Integer result = future.get();
			
			System.out.println("future done? " + future.isDone());
			System.out.println("result " + result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}
}
