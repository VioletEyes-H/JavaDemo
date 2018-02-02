package com.EventDemo;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FocusEventDemo extends JFrame implements FocusListener{
/*
 * 获取焦点事件
 */
	JButton btn = new JButton("Button");
	JTextField msg = new JTextField("aa");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FocusEventDemo();
	}
	public FocusEventDemo() {
		// TODO Auto-generated constructor stub
		setTitle("FocusEvent");
		setVisible(true);
		setBounds(300,300,300,300);
		add(msg,"Center");
		add(btn,"South");
		btn.addFocusListener(this);
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		msg.setText("按钮获取焦点");
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		msg.setText("按钮失去焦点");
	}
}
