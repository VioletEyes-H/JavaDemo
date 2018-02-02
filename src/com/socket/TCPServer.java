package com.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import net.sf.json.JSONObject;

public class TCPServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			@SuppressWarnings("resource")
			ServerSocket server = new ServerSocket(8888);
			Socket socket = null;
			System.out.println("*****Server Start*****");
			while (true) {
				socket = server.accept();
				new serverThread(socket).setPriority(4);//�����߳����ȼ���4��
				new serverThread(socket).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class serverThread extends Thread {

	Socket socket;
	String info = null, data = "";

	public serverThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			//��ȡ������������ȡ�ͻ�����Ϣ
			is = socket.getInputStream();//��ȡ������
			ir = new InputStreamReader(is);//���ֽ�ת��Ϊ�ַ�������
			br = new BufferedReader(ir);//Ϊ��������ӻ���
			while ((info = br.readLine()) != null) {
				data+=info;//ѭ����ȡ�ͻ�����Ϣ
			}
			JSONObject json = new JSONObject();
			json = JSONObject.fromObject(data);
			System.out.println(json.toString());
			//��ȡ���������Ӧ�ͻ��˵�����
			os = socket.getOutputStream();//��ȡ�����
			JSONObject response = new JSONObject();
			response.put("Msg", "true");
			pw = new PrintWriter(os);
			pw.write(response.toString());//��Ӧ�ͻ���
			pw.flush();//ˢ�»���
			socket.shutdownInput();//�ر������
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//�ر���Դ
			try {
				if (is != null)
					is.close();
				if (ir != null)
					ir.close();
				if (br != null)
					br.close();
				if (os != null)
					os.close();
				if (pw != null)
					pw.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		;
	}

}
