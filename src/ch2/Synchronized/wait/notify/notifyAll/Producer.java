package ch2.Synchronized.wait.notify.notifyAll;

public class Producer implements Runnable{
	private EventStorage eventStorage;
	public Producer(EventStorage eventStorage) {
		this.eventStorage = eventStorage;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			this.eventStorage.set();
		}
	}
}
