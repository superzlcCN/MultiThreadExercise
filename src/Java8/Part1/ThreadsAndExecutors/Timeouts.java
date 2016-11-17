package Java8.Part1.ThreadsAndExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Timeouts {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Future<Integer> future = executorService.submit(()->
		{
			
				TimeUnit.SECONDS.sleep(2);
				return 123;
			
		});
		
		future.get(1,TimeUnit.SECONDS);
	}
}
