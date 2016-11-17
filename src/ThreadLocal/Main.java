package ThreadLocal;

public class Main {
	
	public static void main(String[] args) {
		TestThreadLocal t = new TestThreadLocal();
		new Thread(t,"thread1").start();
		new Thread(t,"thread2").start();
	}
		
}
/*概括起来说，对于多线程资源共享的问题，同步机制采用了“以时间换空间”的方式，
 * 而ThreadLocal采用了“以空间换时间”的方式。前者仅提供一份变量，让不同的线程排队访问，
 * 而后者为每一个线程都提供了一份变量，因此可以同时访问而互不影响。 
 

ThreadLocal和Synchonized都用于解决多线程并发访问。
但是ThreadLocal与synchronized有本质的区别。synchronized是利用锁的机制，
使变量或代码块在某一时该只能被一个线程访问。
而ThreadLocal为每一个线程都提供了变量的副本，使得每个线程在某一时间访问到的并不是同一个对象，
这样就隔离了多个线程对数据的数据共享。
而Synchronized却正好相反，它用于在多个线程间通信时能够获得数据共享。
*/