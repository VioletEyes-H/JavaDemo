package com.input.output;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * �ԡ��������ܵ���չ�����Ը��ӷ���Ķ�ȡint��long���ַ�����������
 */
public class DataOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String file = "file.txt";
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		dos.writeInt(10456);
		dos.writeUTF("�й�");//����utf-8д��
		dos.writeChars("�й�");//����utf-16be����д��
		DataInputStream dus = new DataInputStream(new FileInputStream(file));
		int i = dus.readInt();
		System.out.println(i);
		String a = dus.readUTF();
		System.out.println(a);
		dos.close();
		dus.close();
		
		
	}

}
