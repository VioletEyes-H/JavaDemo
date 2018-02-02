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
	 * �������ˣ�ʵ�ֻ���udp���û���¼
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		new thread().setPriority(4);//�����߳����ȼ�����߳����ٶ�
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
			 * ���տͻ�������
			 */

			DatagramSocket socket = new DatagramSocket(8888);// ������������DatagramSocket��ָ���˿�
			System.out.println("Server Start...");
			while (udp) {
				byte[] data = new byte[1024];
				DatagramPacket packet = new DatagramPacket(data, data.length);// �������ݱ������ڽ��տͻ����˷��͵�����
				socket.receive(packet);// ���տͻ��˷��͵����ݣ��˷����ڽ��յ����ݱ�֮ǰ��һֱ����
				String info = new String(data, 0, packet.getLength());
				System.out.println(info);
				JSONObject json = JSONObject.fromObject(info);
				System.out
						.println("username:" + json.getString("username") + "\npassword:" + json.getString("userpwd"));
				/*
				 * ��ͻ�����Ӧ����
				 */
				// ��ȡ�ͻ���ip���˿ںš��Լ���Ҫ��Ӧ����Ϣ
				InetAddress ip = packet.getAddress();
				int port = packet.getPort();
				String temp = "username:" + json.getString("username") + "\npassword:" + json.getString("userpwd");
				byte[] data2 = temp.getBytes();
				// �������ݱ�,������Ӧ��Ϣ
				DatagramPacket pack = new DatagramPacket(data2, data2.length, ip, port);
				// ��Ӧ��Ϣ
				socket.send(pack);
				// �ر���Դ
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
