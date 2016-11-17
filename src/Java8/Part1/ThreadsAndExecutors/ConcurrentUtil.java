package Java8.Part1.ThreadsAndExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ConcurrentUtil {
	public static void Sleep(int seconds){
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new IllegalStateException(e);
		}
	}
	
	public static void stop(ExecutorService executor){
		try{
			executor.shutdown();
			executor.awaitTermination(60, TimeUnit.SECONDS);
		}catch(Exception e){
			System.out.println("Termination interrupted!");
		}finally {
			if (!executor.isTerminated()) {
				System.err.println("killing non-finished tasks");
			}
			executor.shutdownNow();
		}
	}
	
}
