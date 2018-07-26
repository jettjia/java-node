package cn.string;

/**
 * StringBuffer
 * 
 * @author JettJia
 * 
 */
public class StringBufferStudy {
	public static void main(String[] args) {
		// public StringBuffer():无参构造方法
		StringBuffer sb = new StringBuffer();
		System.out.println("sb:" + sb);
		System.out.println("sb.capacity():" + sb.capacity());
		System.out.println("sb.length():" + sb.length());
		System.out.println("===============================");

		// public StringBuffer(int capacity):指定容量的字符串缓冲区对象
		StringBuffer sb2 = new StringBuffer(50);
		System.out.println("sb2:" + sb2);
		System.out.println("sb2.capacity():" + sb2.capacity());
		System.out.println("sb2.length():" + sb2.length());
		System.out.println("===============================");

		// public StringBuffer(String str):指定字符串内容的字符串缓冲区对象
		StringBuffer sb3 = new StringBuffer("hello");
		System.out.println("sb3:" + sb3);
		System.out.println("sb3.capacity():" + sb3.capacity());
		System.out.println("sb3.length():" + sb3.length());
		System.out.println("===============================");

		// append
		sb.append("whwo");
		sb.append(true).append("好好").append(35.52);
		System.out.println("append:" + sb);

		// insert
		sb.insert(2, "KILL");
		System.out.println(sb);

		// deleteCharAt
		sb.deleteCharAt(2);
		System.out.println(sb);

		// delete
		sb.delete(7, 11);
		System.out.println(sb);
		
		// replace
		sb.replace(7, 8, "A");
		System.out.println(sb);
		
		// reverse
		sb.reverse();
		System.out.println(sb);
		
		// substring
		sb.substring(2);
		System.out.println(sb);
	}
}
