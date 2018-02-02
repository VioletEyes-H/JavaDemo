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
	public void windowActivated(WindowEvent e) {//窗口被激活时调用
		// TODO Auto-generated method stub
		output.append("我被激活了!\n");
		validate();
	}

	@Override
	public void windowClosed(WindowEvent e) {//窗口关闭以后调用
		// TODO Auto-generated method stub
		System.out.println("程序关闭");
		System.exit(0);
	}

	@Override
	public void windowClosing(WindowEvent e) {//窗口正在关闭调用
		// TODO Auto-generated method stub
		System.out.println("我即将被关闭");
		dispose();
	}

	@Override
	public void windowDeactivated(WindowEvent e) {//窗口被取消激活状态时调用
		// TODO Auto-generated method stub
		output.append("我不是激活状态了!\n");
		setBounds(300, 300, 300, 300);
		validate();
	}

	@Override
	public void windowDeiconified(WindowEvent e) {//窗口最小化复原时调用
		// TODO Auto-generated method stub
		output.append("我撤销图标化，还原了!\n");
		setBounds(300, 300, 300, 300);
		validate();
	}

	@Override
	public void windowIconified(WindowEvent e) {//窗口图标化即最小化时调用
		// TODO Auto-generated method stub
		output.append("我最小化了!\n");
		
	}

	@Override
	public void windowOpened(WindowEvent e) {//打开窗口时调用
		// TODO Auto-generated method stub
		output.append("窗口打开!\n");
	}

}
