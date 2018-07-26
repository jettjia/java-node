import java.util.Random;

public class RandomExample {
	public static void main(String[] args) {
		Random r = new Random();
		
		// 生成[0, 1.0]区间的小数
		System.out.println(r.nextDouble());
		
		// 生成随意整数
		System.out.println(r.nextInt());
		System.out.println(r.nextInt(10)); // 生成的是[0-10)区间的整数
	}
}
