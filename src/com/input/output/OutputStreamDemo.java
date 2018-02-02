package com.input.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * д���ĵ�
 * �ֽ���
 * OutputStream������Ӧ�ó���д�����ݵķ�ʽ
 */
public class OutputStreamDemo{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File dir = new File("file.txt");
		int size;
		byte[] txt = new byte[8 * 1024];
		System.out.print("Please Input:");
		size = System.in.read(txt);
		System.out.println("Size:" + size);
		FileOutputStream out = new FileOutputStream(dir, true);// true׷������
		// out.write(txt,0,size);//���ֽ�����txt��0��ʼд�뵽size����
		out.write(txt);// writeֻ��д��λ
		out.close();
		OutputStreamDemo.copyFile(new File("file.txt"),new File("a.txt"));
	}

	/*
	 * �����ļ�����
	 * �ֽ���������
	 * �����ֽڿ����ļ�������
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ�" + srcFile + "������");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "�����ļ�");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] data = new byte[8 * 1024];
		int b;
		while ((b = in.read(data, 0, data.length)) != -1) {//��ȡ����data����,��0��ʼ���Ϊ���鳤��
			out.write(data, 0, b);
			out.flush();//��ü��ϣ�ˢ�������
		}
		in.close();
		out.close();
	}

}
