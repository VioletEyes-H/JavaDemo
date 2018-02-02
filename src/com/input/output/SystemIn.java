package com.input.output;

import java.io.IOException;

public class SystemIn {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		byte[] date =new byte[10];
		System.out.print("input:");
		System.in.read(date);//输入字节
//		System.out.println((char)date[1]);
		System.out.print("you input:");
		for(int i = 0;i<date.length;i++)
		{
			System.out.print((char)date[i]);
		}
		/*
		 * System.in读取字节的方法有三个:
		 * 1.int read() throws IOException--->从输入流读取一个字节，返回值为下一个字节的整型值，到达流的末尾时返回-1
		 * 2.int read(byte data[]) throws IOException--->从输入流读取字节放到字节数组中，直到数组满，到达流的末尾或者异常发生时为止，返回值为读人的字节数，当达到流末尾时返回-1
		 * 3.int read(byte data[],int off,int lenght) throws IOException--->从输入流的第off个字节开始尝试读取length个字节放到字节数组data中，知道数组满，到达流的末尾或异常发生为终止，返回值为读入的字节数，当到达流的末尾时返回-1。从System.in读取字节时按回车会产生一个流的结束符
		 */
	}

}
