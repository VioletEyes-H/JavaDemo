package com.input.output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 字符流
 * InputStreamReader和OutputStreamWriter的案例
 * 字符流主要操作文本文件
 */
public class israndoswDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(new FileInputStream("file.txt"), "gbk");
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("d.txt"), "utf-16be");

		// 一个一个字符读取
		// char c;
		// while ((c = (char) isr.read()) != -1) {
		// System.out.print(c);
		// }
		// 批量读取
		char[] buffer = new char[8 * 1024];
		int c;
		/*
		 * 读取放入buffer这个字符数组，从第0个位置开始放，最多放buffer.length 返回的是读到的字符的个数。
		 */
		while ((c = isr.read(buffer, 0, buffer.length)) != -1) {
			String s = new String(buffer, 0, c);
			System.out.print(s);
			out.write(s);
			out.flush();
		}
		isr.close();
		out.close();
	}

}
