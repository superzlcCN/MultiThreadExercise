package ch1;

import java.io.Writer;
import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class WriterTask implements Runnable{
	private Deque<Event> deque;
	
	public WriterTask(Deque<Event> deque){
		this.deque = deque;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10 ; i++){
			Event event = new Event();
			event.setDate(new Date());
			event.setEvent(String.format("The thread %s has generated an event", Thread.currentThread().getId()));
			System.out.printf("The thread %s has generated an event\n", Thread.currentThread().getId());
			deque.add(event);
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
