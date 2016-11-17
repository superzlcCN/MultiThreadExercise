package ThreadLocal;

import java.util.Random;

public class TestThreadLocal implements Runnable{
	ThreadLocal studentLocal = new ThreadLocal();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.accessStudent();
	}
	
	private void accessStudent(){
		Student s = this.getStudent();
		Random random = new Random();
		int age = random.nextInt(100);
		System.out.println("Current thread set age "+Thread.currentThread()+":"+age);
		s.setAge(age);
		System.out.println("Current thread first get age "+Thread.currentThread()+":"+s.getAge());
	
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Current thread second get age "+Thread.currentThread()+":"+s.getAge());
	}
	
	private Student getStudent(){
		Student s = (Student) studentLocal.get();
		if (s==null) {
			s = new Student();
			studentLocal.set(s);
		}
		return s;
	}
}
