package com.input.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * RandomAccessFile是用来访问那些保存数据记录的文件的，你就可以用seek( )方法来访问记录，并进行读写了。这些记录的大小不必相同；但是其大小和位置必须是可知的。但是该类仅限于操作文件。
 * 
 * 本案例目的：从输入设备读入一行文本并存入文档
 * 可以读文件也可以写文件
 * 支持随机访问文件，可以访问文件任意位置
 */

public class RandonAccessFileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("file.txt");
		try {
			RandomAccessFile file = new RandomAccessFile(dir, "rw");
			byte[] data = new byte[(int) file.length()];
			file.read(data);
			System.out.println(new String(data));
			Scanner in = new Scanner(System.in);
			String inpu = "\n"+in.next();
			byte[] input = inpu.getBytes("utf-8");//设置编码格式
			file.write(input);
			in.close();
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class temp {
	public temp() throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		StringBuffer buf = new StringBuffer();
		File file = new File("file.txt");
		RandomAccessFile myFile = new RandomAccessFile(file, "rw");// 读写方式可以为r或者rw
		// 文件指针,打开文件时指针在开头 pointer=0
		char in;
		long out = 0;
		try {
			long lengh = myFile.length();// 获取文件字节长度
			while (out < lengh)// 读取和显示文本文件内容
			{
				String a = myFile.readLine();
				System.out.println(a);
				out = myFile.getFilePointer();// 获取指针位置
			}
			System.out.println("==========================================================================");
			System.out.print("Please Input:");
			while ((in = (char) System.in.read()) != '\n') {
				buf.append(in);
				out = myFile.getFilePointer();
			}
			myFile.seek(myFile.length());// 定位指针到文件尾
			myFile.writeBytes(buf.toString());
			myFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
