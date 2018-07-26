package com.jettjia;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyStreamDemo {
	public static void main(String[] args) throws Exception {
		// 输入流
		FileInputStream in = new FileInputStream("D:\\\\test.txt");
		// 输出流
		FileOutputStream out = new FileOutputStream("D:\\\\test_2.txt");
		int len; // 记录每次读取的一个字节
		long beginTime = System.currentTimeMillis();
		while((len = in.read()) != -1) {
			out.write(len);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("运行时间" + (endTime - beginTime));
		in.close();
		out.close();
	}
}
