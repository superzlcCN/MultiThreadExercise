package ch2.Synchronized.wait.notify.notifyAll;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {
	private int maxSize;
	private List<Date> storage;
	
	public EventStorage(){
		maxSize = 100;
		storage = new LinkedList<>();
	}
	
	public synchronized void set(){
		while(storage.size() == maxSize){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		storage.add(new Date());
		
		System.out.printf("Set: %d\n",storage.size());
		try {
			wait(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notifyAll();
	}
	
	public synchronized void get(){
		while (storage.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("Get: %d: %s\n",storage.size(),((LinkedList<?>)storage).poll());
	}
}
