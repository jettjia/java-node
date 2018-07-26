package com.jettjia;

import java.io.*;

public class BufferedCharDemo {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("D:\\\\read.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\\\reads.txt"));
		String str;
		while ((str = br.readLine()) != null) {
			bw.write(str);
			bw.newLine(); // 根据操作系统不同，写入不同的换行符
		}
		br.close();
		bw.close();
	}
}
