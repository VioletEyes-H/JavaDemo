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
				new serverThread(socket).setPriority(4);//设置线程优先级，4级
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
			//获取输入流，并读取客户端信息
			is = socket.getInputStream();//获取输入流
			ir = new InputStreamReader(is);//将字节转换为字符输入流
			br = new BufferedReader(ir);//为输入流添加缓冲
			while ((info = br.readLine()) != null) {
				data+=info;//循环读取客户端信息
			}
			JSONObject json = new JSONObject();
			json = JSONObject.fromObject(data);
			System.out.println(json.toString());
			//获取输出流，响应客户端的请求
			os = socket.getOutputStream();//获取输出流
			JSONObject response = new JSONObject();
			response.put("Msg", "true");
			pw = new PrintWriter(os);
			pw.write(response.toString());//响应客户端
			pw.flush();//刷新缓冲
			socket.shutdownInput();//关闭输出流
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭资源
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
