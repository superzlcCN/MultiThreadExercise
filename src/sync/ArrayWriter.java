package sync;

public class ArrayWriter implements Runnable {
	
	private final SimpleArray sharedSimpleArray;
	private final int startValue;
	
	public ArrayWriter(int value,SimpleArray array) {
		// TODO Auto-generated constructor stub
		this.sharedSimpleArray = array;
		this.startValue = value;
	}
	@Override
	public void run() {
		for(int i = startValue; i < startValue +3;i++)
			sharedSimpleArray.add(i);
	}
}
