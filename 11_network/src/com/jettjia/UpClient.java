package com.jettjia;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UpClient {
	public static void main(String[] args) throws Exception {
		// 创建客户端Socket
		Socket socket = new Socket("127.0.0.1", 10001);
		// 获取Socket的输出流对象
		OutputStream out = socket.getOutputStream();
		// 创建FileInputStream对象
		FileInputStream fis = new FileInputStream("D:\\1.png");
		
		// 读取上面数据，写入
		byte[] buf = new byte[1024];
		int len;
		while((len = fis.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		socket.shutdownInput();
		
		InputStream in = socket.getInputStream(); // 获取Socket的输入流对象
		byte[] bufMsg = new byte[1024];
		int num = in.read(bufMsg); // 接收服务端的信息
		String Msg = new String(bufMsg, 0, num);
		System.out.println(Msg);
		fis.close();
		socket.close();
	}
}
