package com.input.output;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FwriteAndFreadDemo {
/*
 * FileWriter��Writer�����࣬�����Զ��ļ�����д��
 * ���÷�����
 * 1.FileWriter(String name)//ʹ��ָ�����ļ���name����һ��FileWriter�Ķ���
 * 2.FileWriter(File file)//ʹ��ָ�����ļ�����file����һ��FileWriter�Ķ���
 * FileWriter��Ĵ����������ļ���������ڴ����ʼ���֮ǰ��FileWriter���ڴ�������ʱ��������Ϊ����������ͼ��һ��ֻ���ļ���������һ��IOException�쳣
 * FileReader��Reader������,�����Զ��ļ����ж�ȡ
 * ���÷���:
 * 1.FileReader(String name)//ʹ��ָ�����ļ���name����һ��filereader�Ķ�������ļ������ڻ��׳��쳣(FlieNotFoundException)
 * 2.FileReader(File file)//ʹ��ָ�����ļ�����������һ��FileReader�Ķ�������ļ������ڻ��׳����쳣
 *
 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("file.txt");
		FileWriter fw = new FileWriter("a.txt",true);//trueΪ׷��,falseΪ����,Ĭ��false
		FileReader fr = new FileReader(file);
		char[] buf = new char[1024];
		int c,count= 0;
		while((c=fr.read(buf,0,buf.length))!=-1)
		{
			String s = new String(buf,0,c);
			System.out.println(s);
			fw.write(s);
			fw.flush();
			count++;
		}
		System.out.println(count);
		fw.close();
		fr.close();
		
	}

}
