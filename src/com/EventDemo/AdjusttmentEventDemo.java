package com.EventDemo;

import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
/*
 * ���������������С
 */
public class AdjusttmentEventDemo extends JFrame implements AdjustmentListener{
	JScrollBar jBar = new JScrollBar(JScrollBar.HORIZONTAL,10,10, 1, 60);//���������������򡢳�ʼλ�á����������ȡ���Сֵ�����ֵ
	JLabel label = new JLabel("�����������");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AdjusttmentEventDemo();
	}
	public AdjusttmentEventDemo() {
		// TODO Auto-generated constructor stub
		setTitle("AdjustmentEvent");
		setBounds(300, 300,300,300);
		setVisible(true);
		add(label,"Center");
		add(jBar,"South");
		jBar.addAdjustmentListener(this);
	}
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		// TODO Auto-generated method stub
		label.setFont(new Font("����_GB2312",Font.BOLD,jBar.getValue()));
	}

}
