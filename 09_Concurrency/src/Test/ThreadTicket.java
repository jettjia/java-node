package Test;

public class ThreadTicket {
	public static void main(String[] args) {
		new TicketWindow().start();
		new TicketWindow().start();
		new TicketWindow().start();
		new TicketWindow().start();
	}
}

class TicketWindow extends Thread {
	private int tickets = 100;
	public void run() {
		while(true) {
			if (tickets > 0) {
				Thread th = Thread.currentThread(); //获取当前线程
				String th_name = th.getName(); //获取当前线程的名称
				System.out.println(th_name + "正在发售第" + tickets-- + "张票");
			}
		}
	}
}
