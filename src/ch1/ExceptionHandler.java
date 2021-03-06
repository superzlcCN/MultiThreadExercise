package ch1;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler implements UncaughtExceptionHandler{


	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		System.out.printf("An exception has been captured \n");
		System.out.printf("Thread: %s\n",t.getId());
		System.out.printf("Exception : %s:%s \n",e.getClass().getName(),e.getMessage());
		System.out.printf("Stack Trace:\n");
		e.printStackTrace(System.out);
		System.out.printf("Thread status:%s\n",t.getState());
	}
	
	public static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}
}

class Task implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int num = Integer.parseInt("TT");
	}
}