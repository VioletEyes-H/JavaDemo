package com.input.output;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("file.txt");
		System.out.println(f.isFile()?"is Flie":"not File");//是否是一个文件
		System.out.println("File Name:"+f.getName());//返回当前对象的文件名
		System.out.println("Path:"+f.getPath());//返回表示当前对象的路径名
		System.out.println("Absolute Path:"+f.getAbsolutePath());//返回绝对路径
		System.out.println(f.canRead()?"is Readable":"is not Readable");//测试程序是否能从指定文件中进行读取
		System.out.println(f.canWrite()?"is Writeable":"is not Writeable");//测试程序是否能写当前文件
		System.out.println(f.exists()?"exists":"does not exists");//测试当前file是否存在
		System.out.println("is"+(f.isDirectory()?"":" not"+" a directory"));//测试file对象是否是一个目录
		System.out.println("File last modified "+f.lastModified());//file对象最后一次修改的时间
		System.out.println("==========================================");
		try {
			f.createNewFile();//file方法创建文件，会产生异常
			System.out.println("File Name:"+f.getName());//返回当前对象的文件名
			System.out.println("Path:"+f.getPath());//返回表示当前对象的路径名
			System.out.println("Absolute Path:"+f.getAbsolutePath());//返回绝对路径
			System.out.println(f.canRead()?"is Readable":"is not Readable");//测试程序是否能从指定文件中进行读取
			System.out.println(f.canWrite()?"is Writeable":"is not Writeable");//测试程序是否能写当前文件
			System.out.println(f.exists()?"exists":"does not exists");//测试当前file是否存在
			System.out.println("is"+(f.isDirectory()?"":" not"+" a directory"));//测试file对象是否是一个目录
			System.out.println("File last modified "+f.lastModified());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File exists!");
		}
	}

}
