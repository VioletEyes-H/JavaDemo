package com.input.output;

import java.io.IOException;

public class SystemIn {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		byte[] date =new byte[10];
		System.out.print("input:");
		System.in.read(date);//�����ֽ�
//		System.out.println((char)date[1]);
		System.out.print("you input:");
		for(int i = 0;i<date.length;i++)
		{
			System.out.print((char)date[i]);
		}
		/*
		 * System.in��ȡ�ֽڵķ���������:
		 * 1.int read() throws IOException--->����������ȡһ���ֽڣ�����ֵΪ��һ���ֽڵ�����ֵ����������ĩβʱ����-1
		 * 2.int read(byte data[]) throws IOException--->����������ȡ�ֽڷŵ��ֽ������У�ֱ������������������ĩβ�����쳣����ʱΪֹ������ֵΪ���˵��ֽ��������ﵽ��ĩβʱ����-1
		 * 3.int read(byte data[],int off,int lenght) throws IOException--->���������ĵ�off���ֽڿ�ʼ���Զ�ȡlength���ֽڷŵ��ֽ�����data�У�֪������������������ĩβ���쳣����Ϊ��ֹ������ֵΪ������ֽ���������������ĩβʱ����-1����System.in��ȡ�ֽ�ʱ���س������һ�����Ľ�����
		 */
	}

}
