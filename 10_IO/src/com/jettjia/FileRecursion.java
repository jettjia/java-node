package com.jettjia;

import java.io.File;

public class FileRecursion {
	public static void main(String[] args) {
		File file = new File("D:\\develop\\java_study\\10_IO\\src\\com\\jettjia");
		fileDir(file);
	}
	
	public static void fileDir(File dir) {
		File[] files = dir.listFiles(); // 获得目录下的所有文件的数组
		for (File file : files) {
			if (file.isDirectory()) {
				fileDir(file); // 递归调用fileDir()
			}
			System.out.println(file.getAbsolutePath()); // 输出文件的绝对路径
		}
	}
}
