package com.input.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamDemo {

	/*
	 * 字节流
	 * InputStream抽象了应用程序写出数据的方式
	 * 读到-1就是读到结尾
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("file.txt");
		try {
			FileInputStream in = new FileInputStream(dir);//创建一个FileInputStream对象，如果文件不存在会产生FileNotFoundException异常
			int size = in.available();//返回当前可读的输入字节数
			byte[] txt = new byte[size];
//			for(int i =0;i<size;i++)
//			{
//				in.read(txt);
//			}
			while(in.read(txt)!=-1)
			System.out.println(new String(txt,"utf-8"));//解码。将byte转换成string类型输出
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				dir.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
