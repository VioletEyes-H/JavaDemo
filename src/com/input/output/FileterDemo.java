package com.input.output;

import java.io.File;
import java.io.FilenameFilter;

/*
 * 显示指定目录下所有.java文件的名字
 */
public class FileterDemo implements FilenameFilter{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dirs = new File("h:\\java\\JavaDemo\\src\\com\\input\\output");
		FileterDemo file = new FileterDemo();
		String[] filename = dirs.list(file);
		for(int i=0;i<filename.length;i++)
		{
//			System.out.println(dirs);
			System.out.println(filename[i]);
		}
		
	}

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith(".java");//是否已指定的后缀名结束
	}
	

}
