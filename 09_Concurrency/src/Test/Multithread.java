package Test;

public class Multithread {
	public static void main(String[] args) {
		Storage st = new Storage(); //创建数据存储对象
		Input input = new Input(st); // 创建Input对象，传入Storage对象
		Output output = new Output(st); // 创建Output对象，传入Storage对象
		new Thread(input).start(); //开启新线程
		new Thread(output).start();
	}
}

/**
 * 输入线程类
 */
class Input implements Runnable {
	private Storage st;
	private int num;
	
	/**
	 * 通过构造方法，接收一个Storage对象
	 */
	Input(Storage st) {
		this.st = st;
	}
	
	@Override
	public void run() {
		while(true) {
			st.put(num++); // 将num存入数组，每次存入后，num自增
		}
	}
}

/**
 * 输出线程类
 */
class Output implements Runnable {
	private Storage st;
	
	Output(Storage st) {
		this.st = st;
	}
	
	@Override
	public void run() {
		while(true) {
			st.get(); // 取出数组里的元素
		}
	}
}

/**
 * 数据写入数组，取出数组
 * synchronized 修饰写入、取出方法；
 * wait()、notify()进程间进行通信，确保数据一致和不会死锁
 */
class Storage {
	private int[] cells = new int[10]; // 数据存储数组
	private int inPos, outPos; // 存入时数组下标，取出时数组下标
	private int count; //存入或者取出数据的数量
	
	public synchronized void put(int num) {
		try {
			// 如果放入的数据等于cells的长度，此线程等待
			while (count == cells.length) {
				this.wait();
			}
			cells[inPos] = num; // 向数组中放入数据
			System.out.println("在cells[" +inPos+ "]中放入数据" +cells[inPos]);
			inPos++;
			if (inPos == cells.length) { // 当在cells[9] 放完数据后，再从cells[0]开始
				inPos = 0;
			}
			count++; // 没放一个数据，count+1
			this.notify(); // 唤醒等待线程
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void get() {
		try {
			// 如果放入的数据个数为0，此线程等待
			while (count == 0) {
				this.wait();
			}
			int data = cells[outPos]; // 从数组中取出数据
			System.out.println("在cells[" +outPos+ "]中取出数据"+cells[outPos]);
			outPos++;
			if (outPos == cells.length) { // 当从cells[9] 取完数据后，再从cells[0]开始
				outPos = 0;
			}
			count--;
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
