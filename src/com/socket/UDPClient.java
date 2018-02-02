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
	 * �ͻ���
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/*
			 * �����˷�������
			 */
			InetAddress address = InetAddress.getByName("192.168.2.17");//���÷�������ַ
			int port = 8888;
			JSONObject json = new JSONObject();
			json.put("username","admin");
			json.put("userpwd","admin");
			
			byte[] data = json.toString().getBytes();// ���ַ�����ת�����ֽ�����
			// DatagramPacket���ĸ����������ݣ����ݳ��ȣ���������ַ����Ӧ�Ķ˿ں�
			DatagramPacket paket = new DatagramPacket(data, data.length, address, port);// �������ݱ����������͵���Ϣ
			// ����һ��DatagramSocket����
			DatagramSocket socket = new DatagramSocket();
			// ʹ��DatagramSocket��������˷������ݱ�
			socket.send(paket);
			/*
			 * ���շ������Ӧ����
			 */
			byte[] data2 = new byte[1024];//�������ڽ�����Ӧ��Ϣ���ֽ�����
			DatagramPacket repack = new DatagramPacket(data2, data2.length);//�������ݱ������ڽ��շ�������Ӧ��Ϣ�������浽data2������
			socket.receive(repack);//���շ�������Ӧ����
			String response = new String(data2,0,data2.length);//��ȡ���ݣ����ֽ�����ת��ΪString
			System.out.println(response);//�������������Ӧ����
			socket.close();//�ر���Դ
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
