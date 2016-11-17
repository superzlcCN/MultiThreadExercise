package ch1;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileSearch implements Runnable{

	private String initPath;
	private String fileName;
	public FileSearch(String initPath,String fileName) {
		// TODO Auto-generated constructor stub
		this.initPath = initPath;
		this.fileName = fileName;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		File file = new File(initPath);
		if(file.isDirectory()){
			try{
				directoryProcess(file);
			}catch(InterruptedException ex){
				System.out.printf("%s: The search has been interrupted",Thread.currentThread().getName());
			}
		}
	}
	
	private void directoryProcess(File file) throws InterruptedException{
		File[] list = file.listFiles();
		if (list!=null) {
			for (int i = 0; i < list.length; i++) {
				if (list[i].isDirectory()) {
					directoryProcess(list[i]);
				}else{
					fileProcess(list[i]);
				}
			}
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}
	
	private void fileProcess(File file) throws InterruptedException{
		if(file.getName().equals(fileName)){
			System.out.printf("%s : %s \n",Thread.currentThread().getName(),file.getAbsolutePath());
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}
	
	public static void main(String[] args) {
		File file = new File("/");
		Thread thread = new Thread(new FileSearch("/","log.txt"));
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
		thread.interrupt();
	}
}
