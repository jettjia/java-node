package Test;

public class RunnableTicket {
	public static void main(String[] args) {
		TicketWindows tw = new TicketWindows(); // 创建TicketWindows实例对象
		new Thread(tw, "窗口1").start(); // 创建线程对象并开启
		new Thread(tw, "窗口2").start();
		new Thread(tw, "窗口3").start();
		new Thread(tw, "窗口4").start();
	}
}

class TicketWindows implements Runnable {
	private int tickets = 100;

	public void run() {
		while (true) {
			if (tickets > 0) {
				Thread th = Thread.currentThread(); // 获取当前线程
				String th_name = th.getName(); // 获取当前线程名称
				System.out.println(th_name + "正在发售第" + tickets-- + "张票");
			}
		}
	}
}