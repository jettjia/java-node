package Test;

class Tickets implements Runnable {
	private int tickets = 10;
	Object lock = new Object(); // 定义任意一个对象，用作代码同步块的锁
	@Override
	public void run() {
		while(true) {
			synchronized (lock) { // 定义同步代码块
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (tickets > 0) {
					System.out.println(Thread.currentThread().getName() + "第" + tickets-- + "张票");
				} else {
					break;
				}
			}
		}
	}
}

public class SynchronizedDemo {
	public static void main(String[] args) {
		Tickets t = new Tickets();
		new Thread(t, "窗口1").start();
		new Thread(t, "窗口2").start();
		new Thread(t, "窗口3").start();
		new Thread(t, "窗口4").start();
	}
}
