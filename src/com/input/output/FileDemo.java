package com.input.output;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("file.txt");
		System.out.println(f.isFile()?"is Flie":"not File");//�Ƿ���һ���ļ�
		System.out.println("File Name:"+f.getName());//���ص�ǰ������ļ���
		System.out.println("Path:"+f.getPath());//���ر�ʾ��ǰ�����·����
		System.out.println("Absolute Path:"+f.getAbsolutePath());//���ؾ���·��
		System.out.println(f.canRead()?"is Readable":"is not Readable");//���Գ����Ƿ��ܴ�ָ���ļ��н��ж�ȡ
		System.out.println(f.canWrite()?"is Writeable":"is not Writeable");//���Գ����Ƿ���д��ǰ�ļ�
		System.out.println(f.exists()?"exists":"does not exists");//���Ե�ǰfile�Ƿ����
		System.out.println("is"+(f.isDirectory()?"":" not"+" a directory"));//����file�����Ƿ���һ��Ŀ¼
		System.out.println("File last modified "+f.lastModified());//file�������һ���޸ĵ�ʱ��
		System.out.println("==========================================");
		try {
			f.createNewFile();//file���������ļ���������쳣
			System.out.println("File Name:"+f.getName());//���ص�ǰ������ļ���
			System.out.println("Path:"+f.getPath());//���ر�ʾ��ǰ�����·����
			System.out.println("Absolute Path:"+f.getAbsolutePath());//���ؾ���·��
			System.out.println(f.canRead()?"is Readable":"is not Readable");//���Գ����Ƿ��ܴ�ָ���ļ��н��ж�ȡ
			System.out.println(f.canWrite()?"is Writeable":"is not Writeable");//���Գ����Ƿ���д��ǰ�ļ�
			System.out.println(f.exists()?"exists":"does not exists");//���Ե�ǰfile�Ƿ����
			System.out.println("is"+(f.isDirectory()?"":" not"+" a directory"));//����file�����Ƿ���һ��Ŀ¼
			System.out.println("File last modified "+f.lastModified());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File exists!");
		}
	}

}
