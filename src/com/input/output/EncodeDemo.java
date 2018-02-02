package com.input.output;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "测试";
		byte[] data = a.getBytes();//转换成字节序列用的是项目默认的编码GBK
		for (byte b : data) {
			//把字节转换成了int以16进制的方式打印出来
			 System.out.print(Integer.toHexString(b & 0xff)+"  ");//去掉前面的24个f
		}
		System.out.println();
		try {
			byte[] data2 = a.getBytes("gbk");//采用gbk编码转换成字节
			for (byte b : data2) {
				//gbk中文占用两个字节，英文占用一个字节
				 System.out.print(Integer.toHexString(b & 0xff)+"  ");//去掉前面的24个f
			}
			System.out.println();
			byte[] data3 = a.getBytes("utf-8");//采用utf-8编码转换成字节
			for (byte b : data3) {
				//utf-8中文占用三个字节，英文占用一个字节
				 System.out.print(Integer.toHexString(b & 0xff)+"  ");//去掉前面的24个f
			}
			System.out.println();
			byte[] data4 = a.getBytes("utf-16be");//采用utf-16be编码转换成字节
			for (byte b : data4) {
				//utf-16be中文占用两个字节，英文占用两个字节
				 System.out.print(Integer.toHexString(b & 0xff)+"  ");//去掉前面的24个f
			}
			System.out.println();
			String str1= new String(data3,"utf-8");//使用utf-8打印输出data3.如果不加则使用默认编码
			System.out.println(str1);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
