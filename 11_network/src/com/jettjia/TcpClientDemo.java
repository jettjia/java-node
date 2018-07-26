package com.jettjia;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDemo {
	public static void main(String[] args) throws Exception {
		new TCPClient().connetc();
	}
}

class TCPClient {
	private static final int PORT = 7788;
	public void connetc() throws Exception {
		// 创建一个Socket 并连接到给出地址和端口号的计算机
		Socket client = new Socket(InetAddress.getLocalHost(), PORT);
		// 得到接收数据的流
		InputStream is = client.getInputStream();
		// 定义一个1024个字节数组的缓冲区
		byte[] buf = new byte[1024];
		// 将数据读到缓冲区
		int len = is.read(buf);
		// 将缓冲区的数据输出
		System.out.println(new String(buf, 0, len));
		client.close();
	}
}