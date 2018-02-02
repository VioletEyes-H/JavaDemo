//package com.file.cutting;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.RandomAccessFile;
//
//public class aaa {
//
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//
//		RandomAccessFile src = new RandomAccessFile("aa.exe", "r");
//		src.seek(0);
//		BufferedOutputStream bo = null;
//		int count = 0;
//		int len = 0;
//		long c = 0;
//		byte[] b = new byte[1024 * 1024];
//		byte[] aa = new byte[1024*1024*1024];
//		byte[] a = new byte['a'];
//		byte cc = 0;
//		// for (int i = 0; i < 10; i++) {
//		while ((len = src.read(b)) != -1) {
//			for (int i = 0; i < b.length; i++) {
//				cc = (byte) (cc + b[i]);
//			}
//			
//			if (a.length == 5 * 1024 * 1024) {
//				bo = new BufferedOutputStream(new FileOutputStream(new File(count++ + ".part")));
//				bo.write(b, 0, len);
//				bo.close();
//				c = 0;
//			}
//
//		}
//		src.close();
//		// }
//
//	}
//
//}
