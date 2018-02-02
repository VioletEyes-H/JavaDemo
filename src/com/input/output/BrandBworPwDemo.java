package com.input.output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * 字符流的过滤器
 */
public class BrandBworPwDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 对文件进行读写操作
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("s.txt")));
		PrintWriter pw = new PrintWriter("ss.txt");
//		PrintWriter ps = new PrintWriter(new BufferedWriter(new FileWriter("T.txt") ),true);//true自动刷新缓冲流
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);// 一次读一行，不能识别换行
//			bw.write(line);//不能识别换行
//			bw.newLine();//单独写出换行操作
//			bw.flush();
			pw.println(line);
			pw.flush();
		}
		br.close();
		pw.close();
	}

}
