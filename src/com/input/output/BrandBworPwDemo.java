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
 * �ַ����Ĺ�����
 */
public class BrandBworPwDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// ���ļ����ж�д����
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("s.txt")));
		PrintWriter pw = new PrintWriter("ss.txt");
//		PrintWriter ps = new PrintWriter(new BufferedWriter(new FileWriter("T.txt") ),true);//true�Զ�ˢ�»�����
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);// һ�ζ�һ�У�����ʶ����
//			bw.write(line);//����ʶ����
//			bw.newLine();//����д�����в���
//			bw.flush();
			pw.println(line);
			pw.flush();
		}
		br.close();
		pw.close();
	}

}
