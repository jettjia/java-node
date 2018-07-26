package com.jettjia;

import java.io.FileReader;

public class FileReaderDemo {

	public static void main(String[] args)  throws Exception {
		// 创建一个FileReader对象用来读取文件中的字符
		FileReader fr = new FileReader("D:\\\\read.txt"); // 
		int ch; // 定义一个变量用于记录读取的字符
		while ((ch = fr.read()) != -1) {
			System.out.println((char)ch);
		} 
		fr.close();
	}

}
