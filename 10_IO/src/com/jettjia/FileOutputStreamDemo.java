package com.jettjia;

import java.io.FileOutputStream;

public class FileOutputStreamDemo {
	public static void main(String[] args) throws Exception {
		FileOutputStream fileOutputStream = new FileOutputStream("D:\\\\test.txt", true);
		String str = "xyz";
		byte[] b = str.getBytes();
		for (int i = 0; i < b.length; i++) {
			fileOutputStream.write(b[i]);
		}
		fileOutputStream.close();
	}
}
