package ch2.Synchronized.wait.notify.notifyAll;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Consumer implements Runnable{
	
	private EventStorage eventStorage;
	public Consumer(EventStorage eventStorage) {
		// TODO Auto-generated constructor stub
		this.eventStorage = eventStorage;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			this.eventStorage.get();
		}
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Map<Integer,Integer> set = new HashMap<Integer,Integer>();
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(2);
		Integer i3 = new Integer(3);
		
		set.put(i1,1);
		set.put(i2,2);
		set.put(i3,3);
		i3 = new Integer(4);
		set.remove(i3);
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
			
		}
		System.out.println(i3);
		System.out.println(set.size());
	}
}
