package Java8.Part1.ThreadsAndExecutors;

import java.util.concurrent.TimeUnit;

public class ThreadsAndRunnable_2 {
	public static void main(String[] args) {
		Runnable runnable = () -> {
			try{
				String name = Thread.currentThread().getName();
				System.out.println("Foo " + name);
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Bar " + name);
			}
			catch(InterruptedException ex){
				ex.printStackTrace();
			}
		};
		
		runnable.run();
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
