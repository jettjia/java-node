package com.jettjia;

import java.io.*;

public class ByteToCharDemo {
	public static void main(String[] args) throws Exception {
		// 创建字节输入流
		FileInputStream in = new FileInputStream("D:\\\\read.txt");
		// 将字节输入流转换字符输入流
		InputStreamReader isr = new InputStreamReader(in);
		// 将字符输入流包装
		BufferedReader br = new BufferedReader(isr);
		
		// 创建字节输出流
		FileOutputStream out = new FileOutputStream("D:\\\\read_s.txt");
		// 将字节输出流转换字符输出流
		OutputStreamWriter osw = new OutputStreamWriter(out);
		// 将字符输出流包装
		BufferedWriter bw = new BufferedWriter(osw);
		String line;
		while((line = br.readLine()) != null) {
			bw.write(line);
		}
		br.close();
		bw.close();
	}
}
