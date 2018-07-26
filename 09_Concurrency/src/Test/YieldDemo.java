package Test;

// 定义YieldThread继承Thread类
class YieldThread extends Thread {
	// 定义一个有参的构造方法
	public YieldThread(String name) {
		super(name); //调用父类的构造方法
	}
	
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "--" + i);
			if (i == 3) {
				System.out.print("线程让步:");
				Thread.yield(); // 线程运行到此，做出让步
			}
		}
	}
}

public class YieldDemo {
	public static void main(String[] args) {
		Thread t1 = new YieldThread("线程1");
		Thread t2 = new YieldThread("线程2");
		t1.start();
		t2.start();
	}
}