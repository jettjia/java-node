public class SystemExample {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis(); // 计算开始时的时间
		int sum = 0; //声明计数的初始值
		for (int i = 0; i < 10000000; i++) {
			sum += i;
		}
		long endTime = System.currentTimeMillis(); //计算结束时的时间
		
		// 计算花费的时间
		System.out.println(endTime - startTime);
	}
}
