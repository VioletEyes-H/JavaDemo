package com.input.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamDemo {

	/*
	 * �ֽ���
	 * InputStream������Ӧ�ó���д�����ݵķ�ʽ
	 * ����-1���Ƕ�����β
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("file.txt");
		try {
			FileInputStream in = new FileInputStream(dir);//����һ��FileInputStream��������ļ������ڻ����FileNotFoundException�쳣
			int size = in.available();//���ص�ǰ�ɶ��������ֽ���
			byte[] txt = new byte[size];
//			for(int i =0;i<size;i++)
//			{
//				in.read(txt);
//			}
			while(in.read(txt)!=-1)
			System.out.println(new String(txt,"utf-8"));//���롣��byteת����string�������
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
