package com.jettjia;

import java.io.File;

public class FileRecursionDelete {
	public static void main(String[] args) {
		File file = new File("D:\\test");
		deleteDir(file);
	}
	
	public static void deleteDir(File dir) {
		if (dir.exists()) { // 判断传入的File对象是否存在
			File[] files = dir.listFiles(); // 得到File数组
			for (File file : files) {
				if (file.isDirectory()) {
					deleteDir(file); // 如果是目录，递归调用deleteDir()
				} else {
					file.delete(); // 如果是文件，直接删除
				}
			}
			// 删除完一个目录里的所有文件后，最后删除这个目录
			dir.delete();
		}
	}
}
