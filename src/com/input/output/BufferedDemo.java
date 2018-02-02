package com.input.output;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * BufferedInputStream& BufferedOutputStream
 * 缓冲区的操作，一般打开文件进行写入或读取操作时，都会加上缓冲，这种缓冲模式提高了IO的性能
 * 从应用程序中把输入放入文件，相当于将一缸水倒入到另一缸中
 * FileOutputStream--->write()方法相当于一滴一滴地把水转移过去
 * DataOutputStream--->writeXxx()相当于一瓢一瓢把水转移过去
 * BufferedOutputStream--->write相当于一瓢一瓢先放入桶中，再从桶中倒入到缸里
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

	// 进行文件拷贝，利用带缓冲的字节流
	public static void copyFileBuffer(File srcFile, File destFile) throws IOException {
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件" + srcFile + "不存在");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		int c;
		while ((c = bis.read()) != -1) {
			bos.write(c);
			bos.flush();// 刷新缓冲区
		}
		bis.close();
		bos.close();
	}
}
