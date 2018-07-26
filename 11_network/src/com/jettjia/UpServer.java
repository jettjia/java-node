package com.jettjia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UpServer {

	public static void main(String[] args) throws Exception {
		// 创建ServerSocket对象
		ServerSocket serverSocket = new ServerSocket(10001);
		while (true) {
			// 调用accept() 方法 接收客户端的请求，得到Socket对象
			Socket s = serverSocket.accept();
			// 每当和客户端建立Socket连接后，单独开启一个线程处理和客户端的交互
			new Thread(new ServerThread(s)).start();
		}
	}
}

class ServerThread implements Runnable {
	private Socket socket; // Socket类型的属性

	// 构造方法把Socket对象作为实参传入
	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		String ip = socket.getInetAddress().getHostAddress(); // 获取客户端的IP地址
		int count = 1; //上传图片个数
		try {
			InputStream in = socket.getInputStream();
			File parentFile = new File("D:\\upload\\"); // 创建上传图片的目录
			if (!parentFile.exists()) {
				parentFile.mkdir();
			}
			// 把客户端的IP地址作为上传文件的文件名
			File file = new File(parentFile, ip + "(" + count + ").png");
			while (file.exists()) {
				// 如果文件名存在，则把count++
				file = new File(parentFile, ip+"(" + (count++) + ").png");
			}
			// 创建FileOutputStream对象
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buf = new byte[1024]; // 定义一个字节数组
			int len = 0;
			while ((len = in.read(buf)) != -1) { // 循环读取数据
				fos.write(buf, 0, len);
			}
			// 获取服务器端的输出流
			OutputStream out = socket.getOutputStream();
			out.write(("上传成功").getBytes()); // 上传成功，提醒客户端
			fos.close(); // 关闭输出流对象
			socket.close(); // 关闭Socket对象
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
