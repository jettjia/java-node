package Test;

public class RunnableDemo {
	public static void main(String[] args) {
		MyThreads myT = new MyThreads(); // 创建MyThreads的实例对象
		Thread thread = new Thread(myT); // 创建线程对象
		thread.start(); // 开启线程，执行线程中的run()方法
		while (true) {
			System.out.println("main()方法在运行");
		}
	}
}

class MyThreads implements Runnable { // 实现Runnable接口
	public void run() { // 复写run方法，当调用start()方法时，线程从此处开始执行
		while (true) {
			System.out.println("MyThread 类的 run()方法在运行");
		}
	}
}
