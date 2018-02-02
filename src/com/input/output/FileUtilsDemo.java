package com.input.output;

import java.io.File;
import java.io.IOException;

public class FileUtilsDemo {
	/*
	 * 列出指定目录下（包括子目录）的所有文件
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
			throw new IllegalArgumentException(file + "不是一个目录");
		if (!file.exists())
			throw new IllegalArgumentException(file + "不存在");

		// String[] list = file.list();//返回是字符串数组，列出所有文件（不包括子目录）
		// for(String a:list)
		// System.out.println(file+"\\"+a);
		File[] listFile = file.listFiles();// 返回是直接子目录（文件）的抽象
		if (listFile != null && listFile.length > 0)
			for (File a : listFile) {
				if (a.isDirectory()) {
					list(a);// 递归
				} else {
					System.out.println(a);
				}
			}
	}
}
