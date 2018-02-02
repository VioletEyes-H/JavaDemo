package com.input.output;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FwriteAndFreadDemo {
/*
 * FileWriter是Writer的子类，它可以对文件进行写入
 * 常用方法：
 * 1.FileWriter(String name)//使用指定的文件名name创建一个FileWriter的对象
 * 2.FileWriter(File file)//使用指定的文件对象file创建一个FileWriter的对象
 * FileWriter类的创建不依赖文件存在与否。在创建问价你之前，FileWriter将在创建对象时打开它来作为输出，如果试图打开一个只读文件，将引发一个IOException异常
 * FileReader是Reader的子类,他可以对文件进行读取
 * 常用方法:
 * 1.FileReader(String name)//使用指定的文件名name创建一个filereader的对象，如果文件不存在会抛出异常(FlieNotFoundException)
 * 2.FileReader(File file)//使用指定的文件对象来创建一个FileReader的对象，如果文件不存在会抛出出异常
 *
 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("file.txt");
		FileWriter fw = new FileWriter("a.txt",true);//true为追加,false为覆盖,默认false
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
