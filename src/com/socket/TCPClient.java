package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import net.sf.json.JSONObject;

public class TCPClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "", info = "";
		JSONObject json = new JSONObject();
		Scanner in = new Scanner(System.in);
		System.out.print("userName:");
		String name = in.next();
		System.out.print("userPwd:");
		String pwd = in.next();
		json.put("username", name);
		json.put("userpwd", pwd);
		try {
			//����socket���ӣ�����ip�Լ��˿�
			Socket socket = new Socket("192.168.2.17", 8888);
			//��ȡ�����
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write(json.toString());//������Ϣ�������
			pw.flush();//ˢ�»���
			socket.shutdownOutput();//�ر������
			InputStream is = socket.getInputStream();//��ȡ��������
			InputStreamReader ir = new InputStreamReader(is);//���ֽ�ת�����ַ�������
			BufferedReader br = new BufferedReader(ir);//Ϊ��������ӻ���
			while ((info = br.readLine()) != null) {
				data += info;//ѭ����ȡ����
			}
			System.out.println(data);
			//�ر���Դ
			socket.close();
			os.close();
			pw.close();
			is.close();
			ir.close();
			br.close();
			in.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}

}
