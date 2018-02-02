package com.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import net.sf.json.JSONObject;

public class UDPClient {
	/*
	 * 客户端
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/*
			 * 向服务端发送数据
			 */
			InetAddress address = InetAddress.getByName("192.168.2.17");//设置服务器地址
			int port = 8888;
			JSONObject json = new JSONObject();
			json.put("username","admin");
			json.put("userpwd","admin");
			
			byte[] data = json.toString().getBytes();// 将字符串串转换成字节数组
			// DatagramPacket的四个参数：数据，数据长度，服务器地址，对应的端口号
			DatagramPacket paket = new DatagramPacket(data, data.length, address, port);// 创建数据报，包含发送的信息
			// 创建一个DatagramSocket对象
			DatagramSocket socket = new DatagramSocket();
			// 使用DatagramSocket向服务器端发送数据报
			socket.send(paket);
			/*
			 * 接收服务端响应数据
			 */
			byte[] data2 = new byte[1024];//创建用于接收响应信息的字节数组
			DatagramPacket repack = new DatagramPacket(data2, data2.length);//创建数据报，用于接收服务器响应信息，并保存到data2数组中
			socket.receive(repack);//接收服务器响应数据
			String response = new String(data2,0,data2.length);//读取数据，把字节数组转换为String
			System.out.println(response);//输出服务器端响应数据
			socket.close();//关闭资源
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
