package com.jettjia;

import java.io.File;

public class IoDemo {
	public static void main(String[] args) {
		File file = new File("D:\\develop\\java_study\\10_IO\\src\\com\\jettjia"); // 创建File文件对象，表示一个文件
		// 获取文件名称
		System.out.println(file.getName());
		// 获取文件的相对路径
		System.out.println(file.getPath());
		// 获取文件的绝对路径
		System.out.println(file.getAbsolutePath());
		// 获取文件的父路径
		System.out.println(file.getParent());
		// 判断文件是否可读
		System.out.println(file.canRead());
		// 判断文件是否可写
		System.out.println(file.canWrite());
		// 判断是否是一个文件
		System.out.println(file.isFile());
		// 判断是否是一个目录
		System.out.println(file.isDirectory());
		// 判断是否是一个绝对路径
		System.out.println(file.isAbsolute());
		// 得到文件最后修改时间
		System.out.println(file.lastModified());
		// 得到文件的大小
		System.out.println(file.length());
		// 是否成功删除文件
		System.out.println(file.delete());
	}
}
