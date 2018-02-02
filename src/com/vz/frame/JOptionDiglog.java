package com.vz.frame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*
 * 消息提示框案例
 */
public class JOptionDiglog extends JFrame implements ActionListener {
	static JButton msgDlg = new JButton("消息对话框");
	static JButton inDlg1 = new JButton("输入对话框1");
	static JButton inDlg2 = new JButton("输入对话框2");
	static JButton cnfDlg = new JButton("确认对话框");
	static JButton optDlg = new JButton("选项对话框");

	public JOptionDiglog() {
		setTitle("消息对话框");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Container c = getContentPane();
		c.setLayout(new GridLayout(5, 1, 0, 10));
		c.add(msgDlg);
		c.add(inDlg1);
		c.add(inDlg2);
		c.add(cnfDlg);
		c.add(optDlg);
		int w = (int) screen.getWidth();
		int h = (int) screen.getHeight();
		int x = (w - 200) / 2;
		int y = (h - 240) / 2;
		setBounds(x, y, 200, 240);
		validate();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		msgDlg.addActionListener(this);
		inDlg1.addActionListener(this);
		inDlg2.addActionListener(this);
		cnfDlg.addActionListener(this);
		optDlg.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JOptionDiglog();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("消息对话框")) {
			JOptionPane.showMessageDialog(this, "内容", "标题:", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("img/icon.png"));
		} else if (e.getActionCommand().equals("输入对话框1")) {
			String a = JOptionPane.showInputDialog(this, "提示字符", "标题:", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(a);
		} else if (e.getActionCommand().equals("输入对话框2")) {
			String[] sex = { "男", "女" };
			Object a = JOptionPane.showInputDialog(this, "内容", "标题:", JOptionPane.QUESTION_MESSAGE,new ImageIcon("img/icon.png"), sex,
					sex[0]);
			System.out.println(a);
		} else if (e.getActionCommand().equals("确认对话框")) {
			int i = JOptionPane.showConfirmDialog(this, "心情好吗?","标题:",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,new ImageIcon("img/icon.png"));
			if (i == 0) {
				System.out.println("心情很好");
			} else if (i == 1) {
				System.out.println("心情不好");
			} else if (i == 2) {
				System.out.println("点击了取消");
			}
		} else if (e.getActionCommand().equals("选项对话框")) {
			String[] c = {"好","不好","取消"};
			int a = JOptionPane.showOptionDialog(this,"今天心情好吗？","标题:",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/icon.png"), c, c[0]);
			if(a==0)
			{
				System.out.println("心情很好");
			}else if(a==1)
			{
				System.out.println("心情不好");
			}else if(a==2)
			{
				System.out.println("点击了取消");
			}
		}

	}

}
