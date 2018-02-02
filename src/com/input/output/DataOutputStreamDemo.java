package com.input.output;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 对“流”功能的扩展，可以更加方面的读取int，long，字符等类型数据
 */
public class DataOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String file = "file.txt";
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		dos.writeInt(10456);
		dos.writeUTF("中国");//采用utf-8写出
		dos.writeChars("中国");//采用utf-16be编码写出
		DataInputStream dus = new DataInputStream(new FileInputStream(file));
		int i = dus.readInt();
		System.out.println(i);
		String a = dus.readUTF();
		System.out.println(a);
		dos.close();
		dus.close();
		
		
	}

}
