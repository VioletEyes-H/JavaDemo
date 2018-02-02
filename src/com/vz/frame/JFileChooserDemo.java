package com.vz.frame;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class JFileChooserDemo extends JFrame implements ActionListener {
	JButton save = new JButton("Save");
	JButton open = new JButton("Open");
	JFileChooser fileChoose = new JFileChooser();
	JLabel msg = new JLabel("", JLabel.CENTER);
	JTextArea txt = new JTextArea();
	JScrollPane js = new JScrollPane(txt);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFileChooserDemo();
	}

	public JFileChooserDemo() {
		// TODO Auto-generated constructor stub
		setTitle("JFileChoose");
		setBounds(300, 300, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		js.setPreferredSize(new Dimension(400, 200));
		JPanel p = new JPanel();
		p.add(js);
		JPanel top = new JPanel();
		top.setPreferredSize(new Dimension(400, 20));
		top.add(msg);
		JPanel btn = new JPanel();
		Box btnBox = Box.createHorizontalBox();
		btnBox.add(open);
		btnBox.add(Box.createHorizontalStrut(50));
		btnBox.add(save);
		btn.add(btnBox, BorderLayout.CENTER);
		c.add(top, BorderLayout.NORTH);
		c.add(p, BorderLayout.CENTER);
		c.add(btn, BorderLayout.SOUTH);
		open.addActionListener(this);
		save.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		File file = null;
		int result = 0;
		FileInputStream fileIn = null;
		FileOutputStream fileOut = null;
		int readByte;

		switch (e.getActionCommand()) {
		case "Open":
			fileChoose.setApproveButtonText("Enter");//���ð�ť����
			fileChoose.setDialogTitle("OpenFile");//���ô����������
			result = fileChoose.showOpenDialog(this);//���ļ�ѡ����
			txt.setText("");
			if (result == JFileChooser.APPROVE_OPTION) {
				file = fileChoose.getSelectedFile();//����ѡ���ļ���Ϣ
				msg.setText("�����ڴ��ļ�����Ϊ��" + file.getName());//��ȡ�ļ�����
			} else if (result == JFileChooser.CANCEL_OPTION) {
				msg.setText("��û��ѡ���κ��ļ�");
			}
			if (file != null) {
				try {
					fileIn = new FileInputStream(file);//ͨ����һ����ʵ���ļ�������������һ�� FileInputStream�����ļ�ͨ���ļ�ϵͳ�е� File ���� file ָ��������һ���� FileDescriptor ��������ʾ���ļ����ӡ�
				} catch (Exception ex) {
					// TODO: handle exception
					msg.setText("File Not Found");
					return;
				}
				try {
					while ((readByte = fileIn.read()) != -1) {//ѭ����ȡ�ֽ�
						txt.append(String.valueOf((char) readByte));//ǿ��ת����char�Ͳ���ӡ����
					}
					msg.setText("�ļ���ȡ�ɹ������ڲ鿴�ļ���"+file.getName());
				} catch (Exception ex) {
					// TODO: handle exception
					msg.setText("�ļ���ȡʧ��");
				} finally {
					if (fileIn != null) {
						try {
							fileIn.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
			break;
		case "Save":
			fileChoose.setDialogTitle("SaveFile");
			fileChoose.setApproveButtonText("Save");
			result = fileChoose.showOpenDialog(this);//���ļ�ѡ����
			file = null;
			String fileName;

			if (result == JFileChooser.APPROVE_OPTION) {//ѡ��ok�󷵻ص�ֵ
				file = fileChoose.getSelectedFile();//�����ļ���Ϣ
				msg.setText("��ѡ��洢���ļ�����Ϊ��" + file.getName());

			} else if (result == JFileChooser.CANCEL_OPTION) {//ѡ��cancel�󷵻ص�ֵ
				msg.setText("��û��ѡ���κ��ļ�");
			}
			if (file != null) {
				try {
					fileOut = new FileOutputStream(file);

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					msg.setText("File Not Found");
					return;
				}
				String content = txt.getText();
				try {
					fileOut.write(content.getBytes());
					msg.setText("����ɹ�"+file.getAbsolutePath());//��ȡ�ļ�����·��
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					msg.setText("�ļ�д��ʧ��");
				} finally {
					if(file!=null)
					{
						try {
							fileOut.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
			break;
		}

	}

}
