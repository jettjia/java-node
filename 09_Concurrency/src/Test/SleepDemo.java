package Test;

public class SleepDemo {
	public static void main(String[] args) {
		new Thread(new SleepThread()).start();
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				try {
					Thread.sleep(20000); // 当前线程休眠2秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("主线程正在输出" + i);
			try {
				Thread.sleep(500); // 当前线程休眠500毫秒
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class SleepThread implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			if (i == 3) {
				try {
					Thread.sleep(20000); // 当前线程休眠2秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("线程1正在输出" + i);
			try {
				Thread.sleep(500); // 当前线程休眠500毫秒
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}