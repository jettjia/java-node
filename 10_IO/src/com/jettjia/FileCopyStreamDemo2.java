package com.jettjia;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyStreamDemo2 {
	public static void main(String[] args) throws Exception {
		// 输入流
		FileInputStream in = new FileInputStream("D:\\\\test.txt");
		// 输出流
		FileOutputStream out = new FileOutputStream("D:\\\\test_2.txt");
		int len; // 记录每次读取的一个字节
		byte[] buff = new byte[1024]; // 定义一个字节数组，作为缓冲区
		long beginTime = System.currentTimeMillis();
		while ((len = in.read(buff)) != -1) {
			out.write(buff, 0, len);
		}
		long endTime= System.currentTimeMillis();
		System.out.println("运行时间" + (endTime - beginTime));
		in.close();
		out.close();
	}
}
