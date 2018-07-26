package Test;

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread myT = new MyThread(); // 创建线程MyThread的线程对象
		myT.start(); // 开启线程
		while (true) {
			System.out.println("main()方法在运行");
		}
	}
}

class MyThread extends Thread { // 继承Thread类
	public void run() { // 复写run方法
		while (true) { //死循环输出
			System.out.println("MyThread 类的 run()方法在运行");
		}
	}
}
