package com.input.output;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "����";
		byte[] data = a.getBytes();//ת�����ֽ������õ�����ĿĬ�ϵı���GBK
		for (byte b : data) {
			//���ֽ�ת������int��16���Ƶķ�ʽ��ӡ����
			 System.out.print(Integer.toHexString(b & 0xff)+"  ");//ȥ��ǰ���24��f
		}
		System.out.println();
		try {
			byte[] data2 = a.getBytes("gbk");//����gbk����ת�����ֽ�
			for (byte b : data2) {
				//gbk����ռ�������ֽڣ�Ӣ��ռ��һ���ֽ�
				 System.out.print(Integer.toHexString(b & 0xff)+"  ");//ȥ��ǰ���24��f
			}
			System.out.println();
			byte[] data3 = a.getBytes("utf-8");//����utf-8����ת�����ֽ�
			for (byte b : data3) {
				//utf-8����ռ�������ֽڣ�Ӣ��ռ��һ���ֽ�
				 System.out.print(Integer.toHexString(b & 0xff)+"  ");//ȥ��ǰ���24��f
			}
			System.out.println();
			byte[] data4 = a.getBytes("utf-16be");//����utf-16be����ת�����ֽ�
			for (byte b : data4) {
				//utf-16be����ռ�������ֽڣ�Ӣ��ռ�������ֽ�
				 System.out.print(Integer.toHexString(b & 0xff)+"  ");//ȥ��ǰ���24��f
			}
			System.out.println();
			String str1= new String(data3,"utf-8");//ʹ��utf-8��ӡ���data3.���������ʹ��Ĭ�ϱ���
			System.out.println(str1);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
