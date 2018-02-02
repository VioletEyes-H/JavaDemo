package com.input.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 写入文档
 * 字节流
 * OutputStream抽象了应用程序写出数据的方式
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
		FileOutputStream out = new FileOutputStream(dir, true);// true追加内容
		// out.write(txt,0,size);//将字节数组txt从0开始写入到size结束
		out.write(txt);// write只能写八位
		out.close();
		OutputStreamDemo.copyFile(new File("file.txt"),new File("a.txt"));
	}

	/*
	 * 复制文件操作
	 * 字节批量拷贝
	 * 批量字节拷贝文件是最快的
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件" + srcFile + "不存在");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] data = new byte[8 * 1024];
		int b;
		while ((b = in.read(data, 0, data.length)) != -1) {//读取存入data数组,从0开始，最长为数组长度
			out.write(data, 0, b);
			out.flush();//最好加上，刷新输出流
		}
		in.close();
		out.close();
	}

}
