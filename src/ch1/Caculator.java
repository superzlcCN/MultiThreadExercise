package ch1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class Caculator implements Runnable {
	private int number;
	public Caculator(int number){
		this.number = number;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf(
					"%s:%d * %d = %d\n",
					Thread.currentThread().getName(),
					number,
					i,
					number * i);
		}
	}
	
	public static void main(String[] args) {
		Thread[] threads = new Thread[10];
		Thread.currentThread().setName("Main thread");
		
		Thread.State status[] = new Thread.State[10];
		
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Caculator(i));
			if (i%2==0) {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}else{
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}
			threads[i].setName("Thread "+i);
		}
		
		FileOutputStream  out = null;
		try{
			out = new FileOutputStream(new File("log.txt"));
			
			
			for (int i = 0; i < 10; i++) {
				out.write(("Main: Status of Thread " + i+" : "+threads[i].getState()+"\n").getBytes());
				status[i]=threads[i].getState();
			}
			
			for (int i = 0; i < status.length; i++) {
				threads[i].start();
			}
			
			boolean finish = false;
			while (!finish) {
				for (int i = 0; i < status.length; i++) {
					if (threads[i].getState()!=status[i]) {
						writeThreadInfo(out, threads[i], status[i]);
						status[i] = threads[i].getState();
					}
				}
				
				finish = true;
				
				for(int i = 0; i < 10; i++){
					finish = finish && (threads[i].getState()==State.TERMINATED);
				}
				
			}
			
			
			
			out.write("finished".getBytes());
			out.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void writeThreadInfo(FileOutputStream fs,Thread thread, State state) throws IOException{
		fs.write(("Main : Id "+thread.getId()+" - "+thread.getName()+" \n").getBytes());
		
		fs.write(("Main : Priority: "+thread.getPriority()+"\n").getBytes());
		fs.write(("Main : Old state: "+state+"\n").getBytes());
		fs.write(("Main : New State: "+thread.getState()+" \n").getBytes());
		fs.write(("**************************************\n").getBytes());
	}
}
