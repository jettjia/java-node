package com.jettjia;

import java.io.*;

public class LineNumberReaderDemo {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("D:\\\\read.txt");
		FileWriter fw = new FileWriter("D:\\\\readLine.txt");
		LineNumberReader lnr = new LineNumberReader(fr); // 包装
		lnr.setLineNumber(0); // 设置读取文件的起始行号
		String line = null;
		while((line = lnr.readLine()) != null) {
			fw.write(lnr.getLineNumber() + ":" + line); // 将行号和读取到的一行文本写入到文件中
			fw.write("\r\n"); // 写入换行
		}
		fr.close();
		fw.close();
	}
}
