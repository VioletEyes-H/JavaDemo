package com.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UDPServer {
	/*
	 * 服务器端，实现基于udp的用户登录
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		new thread().setPriority(4);//设置线程优先级，提高程序速度
		new thread().start();

		count++;
		System.out.println(count);
	}

}

class thread extends Thread {
	boolean udp = true;

	public thread() {
		// TODO Auto-generated constructor stub
		try {
			/*
			 * 接收客户端数据
			 */

			DatagramSocket socket = new DatagramSocket(8888);// 创建服务器端DatagramSocket，指定端口
			System.out.println("Server Start...");
			while (udp) {
				byte[] data = new byte[1024];
				DatagramPacket packet = new DatagramPacket(data, data.length);// 创建数据报，用于接收客户服端发送的数据
				socket.receive(packet);// 接收客户端发送的数据，此方法在接收到数据报之前会一直阻塞
				String info = new String(data, 0, packet.getLength());
				System.out.println(info);
				JSONObject json = JSONObject.fromObject(info);
				System.out
						.println("username:" + json.getString("username") + "\npassword:" + json.getString("userpwd"));
				/*
				 * 向客户端响应数据
				 */
				// 获取客户端ip、端口号、以及需要响应的信息
				InetAddress ip = packet.getAddress();
				int port = packet.getPort();
				String temp = "username:" + json.getString("username") + "\npassword:" + json.getString("userpwd");
				byte[] data2 = temp.getBytes();
				// 创建数据报,包含响应信息
				DatagramPacket pack = new DatagramPacket(data2, data2.length, ip, port);
				// 响应信息
				socket.send(pack);
				// 关闭资源
				// socket.close();
			}
			socket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
