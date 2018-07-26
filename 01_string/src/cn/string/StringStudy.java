package cn.string;

import java.util.Scanner;

/**
 * String类练习
 * 
 */
public class StringStudy {
	public static void main(String[] args) {
		// public String():空构造
		String s1 = new String();
		System.out.println("s1:" + s1 + ",s1 length:" + s1.length());

		// public String(byte[] bytes):把字节数组转成字符串
		byte[] bt = { 97, 98, 99, 100 };
		String s2 = new String(bt);
		System.out.println("s2:" + s2 + ",s2 length:" + s2.length());

		// public String(byte[] bytes,int offset,int length) 把字节数组的一部分转成字符串
		String s3 = new String(bt, 1, 3);
		System.out.println("s3:" + s3 + ",s3 length:" + s3.length());

		// public String(char[] value):把字符数组转成字符串
		char[] cr = { 'a', '3', '好', 'w' };
		String s4 = new String(cr);
		System.out.println("s4:" + s4 + ",s4 length:" + s4.length());

		// 字符串字面值"abc"也可以看成是一个字符串对象。
		String s = "abc";
		System.out.println("s:" + s + ",s length:" + s.length());

		System.out.println("======================================");

		String str1 = "helloworld";
		String str2 = "helloworld";
		String str3 = "helloWorld";

		String str4 = str1.replace("owo", "老石zcd");
		System.out.println(str2.toUpperCase());

		// int[] arr = {1,2,3}; 输出结果：[1, 2, 3]
		int[] arr = { 1, 2, 3 };
		String result = arrToString(arr);
		System.out.println(result);

		// 键盘录入”abc” 输出结果：”cba”
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String inputString = sc.nextLine();

		String result2 = stringReserve(inputString);
		System.out.println(result2);

		// 统计大串中小串出现的次数
		// 定义大串
		String maxString = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
		// 定义小串
		String minString = "java";
		int count = getContainCount(maxString, minString);
		System.out.println(count);
	}

	/**
	 * 把数组以字符串的形式返回； 格式：[a, b, c]
	 * 
	 * @param arr
	 *            待转换的数组
	 * @return [a, b, c] 格式的字符串
	 */
	public static String arrToString(int[] arr) {
		String arrToString = "";
		arrToString += "[";
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				arrToString += arr[i] + "]";
			} else {
				arrToString += arr[i] + ", ";
			}
		}

		return arrToString;
	}

	/**
	 * 字符串反转
	 * 
	 * @param s
	 *            待反转的字符串
	 * @return 返回反转后的字符串
	 */
	public static String stringReserve(String s) {
		String result = ""; // 待返回的数组
		char[] cr = s.toCharArray(); // 把字符串变成字符数组

		// 倒着遍历字符串，得到每一个字符
		for (int x = cr.length - 1; x >= 0; x--) {
			result += cr[x];
		}
		return result;
	}

	/**
	 * 统计某一个字符串在另一个字符串中出现的次数
	 * 
	 * @param maxString
	 * @param minString
	 * @return
	 */
	public static int getContainCount(String maxString, String minString) {
		// 定义统计变量，初始值 0
		int count = 0;

		/*// 先在大串中查找一次小串第一次出现的位置
		int index = maxString.indexOf(minString);

		// 索引不是-1，说明存在，统计变量++
		while (index != -1) {
			count++;
			// 把刚才的索引+小串的长度作为开始位置截取上一次的大串，返回一个新的字符串，并把该字符串的值重新赋值给大串
			int startIndex = index + minString.length();
			maxString = maxString.substring(startIndex);
			// 继续查
			index = maxString.indexOf(minString);
		}

		return count;*/
		
		//方法2
		int index;
		while((index=maxString.indexOf(minString)) != -1){
			count ++;
			maxString = maxString.substring(index + minString.length()); 
		}
		return count;
	}

}
