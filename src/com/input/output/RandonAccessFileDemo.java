package com.input.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * RandomAccessFile������������Щ�������ݼ�¼���ļ��ģ���Ϳ�����seek( )���������ʼ�¼�������ж�д�ˡ���Щ��¼�Ĵ�С������ͬ���������С��λ�ñ����ǿ�֪�ġ����Ǹ�������ڲ����ļ���
 * 
 * ������Ŀ�ģ��������豸����һ���ı��������ĵ�
 * ���Զ��ļ�Ҳ����д�ļ�
 * ֧����������ļ������Է����ļ�����λ��
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
			byte[] input = inpu.getBytes("utf-8");//���ñ����ʽ
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
		RandomAccessFile myFile = new RandomAccessFile(file, "rw");// ��д��ʽ����Ϊr����rw
		// �ļ�ָ��,���ļ�ʱָ���ڿ�ͷ pointer=0
		char in;
		long out = 0;
		try {
			long lengh = myFile.length();// ��ȡ�ļ��ֽڳ���
			while (out < lengh)// ��ȡ����ʾ�ı��ļ�����
			{
				String a = myFile.readLine();
				System.out.println(a);
				out = myFile.getFilePointer();// ��ȡָ��λ��
			}
			System.out.println("==========================================================================");
			System.out.print("Please Input:");
			while ((in = (char) System.in.read()) != '\n') {
				buf.append(in);
				out = myFile.getFilePointer();
			}
			myFile.seek(myFile.length());// ��λָ�뵽�ļ�β
			myFile.writeBytes(buf.toString());
			myFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
