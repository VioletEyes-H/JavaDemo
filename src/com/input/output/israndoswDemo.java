package com.input.output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * �ַ���
 * InputStreamReader��OutputStreamWriter�İ���
 * �ַ�����Ҫ�����ı��ļ�
 */
public class israndoswDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(new FileInputStream("file.txt"), "gbk");
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("d.txt"), "utf-16be");

		// һ��һ���ַ���ȡ
		// char c;
		// while ((c = (char) isr.read()) != -1) {
		// System.out.print(c);
		// }
		// ������ȡ
		char[] buffer = new char[8 * 1024];
		int c;
		/*
		 * ��ȡ����buffer����ַ����飬�ӵ�0��λ�ÿ�ʼ�ţ�����buffer.length ���ص��Ƕ������ַ��ĸ�����
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
