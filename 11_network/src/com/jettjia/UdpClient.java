package com.jettjia;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// 发送客户端
public class UdpClient {
	public static void main(String[] args) throws Exception {
		// 创建一个DatagramSocket对象
		DatagramSocket ds = new DatagramSocket(3000);
		// 要发送的数据
		String str = "hello world";
		/**
		 *   创建一个要发送的数据包
		 * 包括发哦少年宫的数据，数据的长度，接收端的IP地址以及端口号
		 */
		DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("localhost"), 8954);
		System.out.println("发送信息");
		ds.send(dp); // 发送数据
		ds.close(); // 关闭资源
	}
}
