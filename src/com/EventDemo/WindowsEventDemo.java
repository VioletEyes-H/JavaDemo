package com.EventDemo;

import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowsEventDemo extends JFrame implements WindowListener{
	TextArea output = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WindowsEventDemo();
	}
	public WindowsEventDemo() {
		// TODO Auto-generated constructor stub
		setTitle("WindowsEvent");
		setBounds(300,300,300,300);
		setVisible(true);
		add(output);
		addWindowListener(this);
	}
	@Override
	public void windowActivated(WindowEvent e) {//���ڱ�����ʱ����
		// TODO Auto-generated method stub
		output.append("�ұ�������!\n");
		validate();
	}

	@Override
	public void windowClosed(WindowEvent e) {//���ڹر��Ժ����
		// TODO Auto-generated method stub
		System.out.println("����ر�");
		System.exit(0);
	}

	@Override
	public void windowClosing(WindowEvent e) {//�������ڹرյ���
		// TODO Auto-generated method stub
		System.out.println("�Ҽ������ر�");
		dispose();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {//���ڱ�ȡ������״̬ʱ����
		// TODO Auto-generated method stub
		output.append("�Ҳ��Ǽ���״̬��!\n");
		setBounds(300, 300, 300, 300);
		validate();
	}

	@Override
	public void windowDeiconified(WindowEvent e) {//������С����ԭʱ����
		// TODO Auto-generated method stub
		output.append("�ҳ���ͼ�껯����ԭ��!\n");
		setBounds(300, 300, 300, 300);
		validate();
	}

	@Override
	public void windowIconified(WindowEvent e) {//����ͼ�껯����С��ʱ����
		// TODO Auto-generated method stub
		output.append("����С����!\n");
		
	}

	@Override
	public void windowOpened(WindowEvent e) {//�򿪴���ʱ����
		// TODO Auto-generated method stub
		output.append("���ڴ�!\n");
	}

}
