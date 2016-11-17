package ch1;

public class PrimeGenerator extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long number = 1L;
		while(true){
			if(isPrimve(number))
				System.out.printf("Number %d is prime.\n",number);
			if(isInterrupted()){
				System.out.println("The prime generator is interrupted");
				return;
			}
			number++;
		}
	}
	
	private boolean isPrimve(long number){
		if(number<=2)
			return true;
		for (long i = 2;  i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Thread task  = new PrimeGenerator();
		task.start();
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		task.interrupt();
	}
}
