package com.vz.frame;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/*
 * ͼ����ı���ǩ���
 */
public class JLableWithIcon extends JFrame{
	
	ImageIcon img = new ImageIcon("img/icon.png");
	Icon icon = new ImageIcon("img/icon.png");
	JLabel lb1 = new JLabel("����",JLabel.CENTER);
	JLabel lb2 = new JLabel(icon);
	JLabel lb3 = new JLabel("����",icon,JLabel.CENTER);
	public JLableWithIcon()
	{
		Container c = getContentPane();
		c.setLayout(new GridLayout(1,3));
		c.add(lb1);
		c.add(lb2);
		c.add(lb3);
		setTitle("ͼƬ�ͱ�ǩ");
		setBounds(100, 100, 1200, 500);
		setVisible(true);
		validate();
		lb3.setHorizontalTextPosition(SwingConstants.CENTER);
		lb3.setVerticalTextPosition(SwingConstants.BOTTOM);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JLableWithIcon();
	}

}
