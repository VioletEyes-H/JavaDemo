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
			//创建socket连接，设置ip以及端口
			Socket socket = new Socket("192.168.2.17", 8888);
			//获取输出流
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write(json.toString());//发送信息到服务端
			pw.flush();//刷新缓冲
			socket.shutdownOutput();//关闭输出流
			InputStream is = socket.getInputStream();//获取输入数据
			InputStreamReader ir = new InputStreamReader(is);//将字节转换成字符输入流
			BufferedReader br = new BufferedReader(ir);//为输入流添加缓冲
			while ((info = br.readLine()) != null) {
				data += info;//循环读取数据
			}
			System.out.println(data);
			//关闭资源
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
