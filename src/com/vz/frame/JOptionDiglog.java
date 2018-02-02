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
 * ��Ϣ��ʾ����
 */
public class JOptionDiglog extends JFrame implements ActionListener {
	static JButton msgDlg = new JButton("��Ϣ�Ի���");
	static JButton inDlg1 = new JButton("����Ի���1");
	static JButton inDlg2 = new JButton("����Ի���2");
	static JButton cnfDlg = new JButton("ȷ�϶Ի���");
	static JButton optDlg = new JButton("ѡ��Ի���");

	public JOptionDiglog() {
		setTitle("��Ϣ�Ի���");
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
		if (e.getActionCommand().equals("��Ϣ�Ի���")) {
			JOptionPane.showMessageDialog(this, "����", "����:", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("img/icon.png"));
		} else if (e.getActionCommand().equals("����Ի���1")) {
			String a = JOptionPane.showInputDialog(this, "��ʾ�ַ�", "����:", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(a);
		} else if (e.getActionCommand().equals("����Ի���2")) {
			String[] sex = { "��", "Ů" };
			Object a = JOptionPane.showInputDialog(this, "����", "����:", JOptionPane.QUESTION_MESSAGE,new ImageIcon("img/icon.png"), sex,
					sex[0]);
			System.out.println(a);
		} else if (e.getActionCommand().equals("ȷ�϶Ի���")) {
			int i = JOptionPane.showConfirmDialog(this, "�������?","����:",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,new ImageIcon("img/icon.png"));
			if (i == 0) {
				System.out.println("����ܺ�");
			} else if (i == 1) {
				System.out.println("���鲻��");
			} else if (i == 2) {
				System.out.println("�����ȡ��");
			}
		} else if (e.getActionCommand().equals("ѡ��Ի���")) {
			String[] c = {"��","����","ȡ��"};
			int a = JOptionPane.showOptionDialog(this,"�����������","����:",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("img/icon.png"), c, c[0]);
			if(a==0)
			{
				System.out.println("����ܺ�");
			}else if(a==1)
			{
				System.out.println("���鲻��");
			}else if(a==2)
			{
				System.out.println("�����ȡ��");
			}
		}

	}

}
