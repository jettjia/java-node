import java.math.BigInteger;

public class BigIntegerExample {
	public static void main(String[] args) {
		// 输出Integer最大
		System.out.println(Integer.MAX_VALUE); // 2147483647
		Integer i = new Integer(2147483647 + 22);
		System.out.println(i); // -2147483627，计算出错
		
		BigInteger bi1 = new BigInteger("2147483627");
		BigInteger bi2 = new BigInteger("22");
		BigInteger bi = bi1.add(bi2);
		System.out.println(bi);
	}
}
