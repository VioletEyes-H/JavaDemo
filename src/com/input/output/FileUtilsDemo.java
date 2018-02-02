package com.input.output;

import java.io.File;
import java.io.IOException;

public class FileUtilsDemo {
	/*
	 * �г�ָ��Ŀ¼�£�������Ŀ¼���������ļ�
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileUtilsDemo.list(new File("H:\\java\\JavaDemo"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void list(File file) throws IOException {
		if (!file.isDirectory())
			throw new IllegalArgumentException(file + "����һ��Ŀ¼");
		if (!file.exists())
			throw new IllegalArgumentException(file + "������");

		// String[] list = file.list();//�������ַ������飬�г������ļ�����������Ŀ¼��
		// for(String a:list)
		// System.out.println(file+"\\"+a);
		File[] listFile = file.listFiles();// ������ֱ����Ŀ¼���ļ����ĳ���
		if (listFile != null && listFile.length > 0)
			for (File a : listFile) {
				if (a.isDirectory()) {
					list(a);// �ݹ�
				} else {
					System.out.println(a);
				}
			}
	}
}
