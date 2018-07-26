package Test;

class CreateTicket implements Runnable {
	private int tickets = 10;
	@Override
	public void run() {
		while(true) {
			saleTicket(); //调用售票方法
			if (tickets <= 0) {
				break;
			}
		}
	}
	
	private synchronized void saleTicket() {
		if (tickets > 0) {
			try {
				Thread.sleep(10); // 经过的线程休眠10毫秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "--售卖的第" + tickets--);
		}
	}
}

public class SynchronizedDemo2 {
	public static void main(String[] args) {
		CreateTicket cTicket = new CreateTicket();
		new Thread(cTicket, "窗口1 ").start();
		new Thread(cTicket, "窗口2 ").start();
		new Thread(cTicket, "窗口3 ").start();
		new Thread(cTicket, "窗口4 ").start();
	}
}
