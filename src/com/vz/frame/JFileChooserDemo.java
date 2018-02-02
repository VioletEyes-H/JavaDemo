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
			fileChoose.setApproveButtonText("Enter");//设置按钮文字
			fileChoose.setDialogTitle("OpenFile");//设置窗体标题文字
			result = fileChoose.showOpenDialog(this);//打开文件选择器
			txt.setText("");
			if (result == JFileChooser.APPROVE_OPTION) {
				file = fileChoose.getSelectedFile();//返回选中文件信息
				msg.setText("您正在打开文件名称为：" + file.getName());//获取文件名称
			} else if (result == JFileChooser.CANCEL_OPTION) {
				msg.setText("您没有选择任何文件");
			}
			if (file != null) {
				try {
					fileIn = new FileInputStream(file);//通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的 File 对象 file 指定。创建一个新 FileDescriptor 对象来表示此文件连接。
				} catch (Exception ex) {
					// TODO: handle exception
					msg.setText("File Not Found");
					return;
				}
				try {
					while ((readByte = fileIn.read()) != -1) {//循环读取字节
						txt.append(String.valueOf((char) readByte));//强制转换成char型并打印出来
					}
					msg.setText("文件读取成功，正在查看文件："+file.getName());
				} catch (Exception ex) {
					// TODO: handle exception
					msg.setText("文件读取失败");
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
			result = fileChoose.showOpenDialog(this);//打开文件选择器
			file = null;
			String fileName;

			if (result == JFileChooser.APPROVE_OPTION) {//选择ok后返回的值
				file = fileChoose.getSelectedFile();//返回文件信息
				msg.setText("您选择存储的文件名称为：" + file.getName());

			} else if (result == JFileChooser.CANCEL_OPTION) {//选择cancel后返回的值
				msg.setText("您没有选择任何文件");
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
					msg.setText("保存成功"+file.getAbsolutePath());//获取文件绝对路径
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					msg.setText("文件写入失败");
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
