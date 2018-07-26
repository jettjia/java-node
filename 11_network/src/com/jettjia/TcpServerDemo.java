package com.jettjia;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo {
	public static void main(String[] args) throws Exception {
		new TCPServer().listen(); // 创建TCPServer对象，并调用listen方法
	}
}

// 服务端
class TCPServer {
	private static final int PORT = 7788; // 定义端口号
	// 定义一个listen方法，抛出一个异常
	public void listen() throws Exception {
		// 创建ServerSocket对象
		ServerSocket serverSocket = new ServerSocket(PORT);
		// 调用ServerSocket的accept()方法接收数据
		Socket client = serverSocket.accept();
		// 获取客户端的输出流
		OutputStream os = client.getOutputStream();
		
		System.out.println("开始和客户端交互数据");
		
		os.write(("你好!").getBytes());
		
		Thread.sleep(5000); // 模拟执行其他功能占用的时间
		System.out.println("结束和客户端交互数据");
		os.close();
		client.close();
	}
}