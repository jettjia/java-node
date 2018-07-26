package cn.array;

/**
 * Integer
 * 
 */
public class IntegerStudy {
	public static void main(String[] args) {
		// 二进制
		System.out.println(Integer.toBinaryString(100));

		// 八进制
		System.out.println(Integer.toOctalString(100));

		// 十六进制
		System.out.println(Integer.toHexString(100));

		System.out.println(Integer.MIN_VALUE);

		System.out.println(Integer.MAX_VALUE);

		// 方式1
		int i = 100;
		Integer ii = new Integer(i);
		System.out.println("ii:" + ii);

		// 方式2
		String s = "100";
		// NumberFormatException
		// String s = "abc";
		Integer iii = new Integer(s);
		System.out.println("iii:" + iii);
	}
}
