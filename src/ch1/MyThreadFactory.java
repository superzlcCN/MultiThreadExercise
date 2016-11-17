package ch1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class MyThreadFactory implements ThreadFactory {
	private int counter;
	private String name;
	private List<String> status;
	
	public MyThreadFactory(String name) {
		counter = 0;
		this.name = name;
		status = new ArrayList<String>();
	}
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r,name+"-Thread_"+counter);
		counter++;
		status.add(String.format("Created thread %d with name %s on %s\n", 
				t.getId(), t.getName(),new Date()));
		return t;
	}
	
	public String getStatus(){
		StringBuffer buffer = new StringBuffer();
		Iterator<String> it = status.iterator();
		while(it.hasNext()){
			buffer.append(it.next());
			buffer.append("\n");
		}
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		Task_1 task_1 = new Task_1();
		Thread thread;
		System.out.println("Starting the Threads \n");
		for (int i = 0; i < 10; i++) {
			thread = factory.newThread(task_1);
			thread.start();
		}
		System.out.printf("Factory status:\n");
		System.out.printf("%s\n",factory.getStatus());
	}

}

class Task_1 implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
