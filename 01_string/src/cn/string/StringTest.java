package cn.string;

import java.math.BigInteger;

public class StringTest {
	public static void main(String[] args) {
		BigInteger aBigInteger = BigInteger.valueOf(100);
		BigInteger bBigInteger = BigInteger.valueOf(200);
		// + * 等不能直接运用。要用类中自带的add，multiply方法
		BigInteger cBigInteger = aBigInteger.add(bBigInteger);
		System.out.println(cBigInteger);
	}
}
