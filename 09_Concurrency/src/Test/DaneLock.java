package Test;

public class DaneLock {
	public static void main(String[] args) {
		DieLock dLock = new DieLock(true);
		DieLock dLock2 = new DieLock(false);
		new Thread(dLock).start();
		new Thread(dLock2).start();
	}
}

class DieLock implements Runnable {
	static Object obj1 = new Object(); // 定义死锁对象
	static Object obj2 = new Object(); // 定义死锁对象
	private boolean flag;
	public DieLock(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() {
		if (flag) {
			while (true) {
				synchronized (obj1) {
					System.out.println(Thread.currentThread().getName() + "...if...obj1...");
					synchronized (obj2) {
						System.out.println(Thread.currentThread().getName() + "...if...obj2...");
					}
				}
			}
		} else {
			while (true) {
				synchronized (obj2) {
					System.out.println(Thread.currentThread().getName() + "...if...obj2...");
					synchronized (obj1) {
						System.out.println(Thread.currentThread().getName() + "...if...obj1...");
					}
				}
			}
		}
	}
}