package com.EventDemo;

import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
/*
 * 滚动条控制字体大小
 */
public class AdjusttmentEventDemo extends JFrame implements AdjustmentListener{
	JScrollBar jBar = new JScrollBar(JScrollBar.HORIZONTAL,10,10, 1, 60);//滚动条参数：方向、初始位置、滚动条长度、最小值、最大值
	JLabel label = new JLabel("拉动字体会变大");
	
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
		label.setFont(new Font("楷体_GB2312",Font.BOLD,jBar.getValue()));
	}

}
