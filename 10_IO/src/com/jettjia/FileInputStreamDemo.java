package com.jettjia;

import java.io.FileInputStream;

public class FileInputStreamDemo {
	public static void main(String[] args) throws Exception {
		FileInputStream fileInputStream = new FileInputStream("D:\\\\test.txt");
		int b = 0;
		while(true) {
			b = fileInputStream.read();
			if (b == -1) {
				break;
			}
			System.out.println(b);
		}
		fileInputStream.close();
	}
}
