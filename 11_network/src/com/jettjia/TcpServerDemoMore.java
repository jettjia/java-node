package com.jettjia;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemoMore {
	public static void main(String[] args) throws Exception {
		new TCPServers().listen();
	}
}

class TCPServers {
	private static final int PORT = 7788;
	
	public void listen() throws Exception {
		// 创建ServerSocket对象，监听指定的端口
		ServerSocket serverSocket = new ServerSocket(PORT);
		// 使用while循环不停的接收客户端发送的请求
		while(true) {
			// 调用ServerSocket的accept()方法，和客户端建立连接
			final Socket client = serverSocket.accept();
			// 开启新的线程和用户进行数据交互
			new Thread() {
				public void run() {
					OutputStream os; // 定义一个输出流对象
					try {
						os = client.getOutputStream(); //获取客户端的输出流
						System.out.println("开始和客户端交互数据");
						os.write(("你好！").getBytes());
						Thread.sleep(5000); // 使线程休眠5000毫秒
						System.out.println("结束与线程交互数据");
						os.close();
						client.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();
		}
	}
}