package com.input.output;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * BufferedInputStream& BufferedOutputStream
 * �������Ĳ�����һ����ļ�����д����ȡ����ʱ��������ϻ��壬���ֻ���ģʽ�����IO������
 * ��Ӧ�ó����а���������ļ����൱�ڽ�һ��ˮ���뵽��һ����
 * FileOutputStream--->write()�����൱��һ��һ�εذ�ˮת�ƹ�ȥ
 * DataOutputStream--->writeXxx()�൱��һưһư��ˮת�ƹ�ȥ
 * BufferedOutputStream--->write�൱��һưһư�ȷ���Ͱ�У��ٴ�Ͱ�е��뵽����
 */
public class BufferedDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedDemo.copyFileBuffer(new File("file.txt"), new File("a.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// �����ļ����������ô�������ֽ���
	public static void copyFileBuffer(File srcFile, File destFile) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ�" + srcFile + "������");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "�����ļ�");
		}
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		int c;
		while ((c = bis.read()) != -1) {
			bos.write(c);
			bos.flush();// ˢ�»�����
		}
		bis.close();
		bos.close();
	}
}
