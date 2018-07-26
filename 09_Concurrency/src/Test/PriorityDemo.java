package Test;

class MaxPriority implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "正在输出" + i);
		}
	}
}

class MinPriority implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "正在输出" + i);
		}
	}
}
public class PriorityDemo {
	public static void main(String[] args) {
		Thread maxPriority = new Thread(new MaxPriority());
		Thread minPriority = new Thread(new MinPriority());
		minPriority.setPriority(Thread.MIN_PRIORITY);
		maxPriority.setPriority(10);
		maxPriority.start();
		minPriority.start();
	}
}
