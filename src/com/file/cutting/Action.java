package com.file.cutting;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Action {
	private static JFileChooser fileChoose = new JFileChooser();
	private static JFileChooser fileSava = new JFileChooser();

	public static void cut(File src, String dest, int size) {

		try {
			BufferedInputStream bf = new BufferedInputStream(new FileInputStream(src));
			BufferedOutputStream out = null;
			byte[] data = new byte[size * 1024 * 1024];
			int num = 0;
			int c;
			while ((c = bf.read(data)) != -1) {
				num++;
				try {
					out = new BufferedOutputStream(new FileOutputStream(new File(dest + "\\" + num + ".part")));
					out.write(data, 0, c);
					out.close();
					Windows.msg.append("�ɹ�д���" + num + "���ļ�\n");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			bf.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String src() {
		File dir = new File("û��ѡ���ļ�");
		fileChoose.setApproveButtonText("ȷ��");
		fileChoose.setDialogTitle("��ѡ����Ҫ�и���ļ�:");
		int result = fileChoose.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			dir = fileChoose.getSelectedFile();
		} else if (result == JFileChooser.CANCEL_OPTION) {
			System.out.println("sys");
		}
		return dir.toString();

	}

	public static String dest() {
		File dir = new File("û��ѡ�񱣴�λ��");
		;
		fileSava.setApproveButtonText("����");
		fileSava.setDialogTitle("�ļ����浽:");
		fileSava.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);// ֻ��ѡ��Ŀ¼
		int result = fileSava.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			dir = fileSava.getSelectedFile();
		}
		return dir.toString() + "\\";

	}
}

//
// try
// {
// FileInputStream in = new FileInputStream(src);
// int c;
// byte[] data = new byte[size * 1024 * 1024];
// int num = 1;
// long start = System.currentTimeMillis();
//
// while ((c = in.read(data, 0, data.length)) != -1) {
// int i = num++;
// BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new
// File(dest + i)));
// // FileOutputStream out = new FileOutputStream(new File(dest + i));
// out.write(data, 0, c);
// out.flush();
// out.close();
// Windows.msg.append("д����" + i + "���ļ�...\t���\n");
// }
// long end = System.currentTimeMillis();
// long sum = end - start;
// System.out.println(sum);
// in.close();
// Windows.msg.append("�ָ����...\n");
// }catch(
// FileNotFoundException e)
// {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }catch(
// IOException e)
// {
// // TODO Auto-generated catch block
// e.printStackTrace();
