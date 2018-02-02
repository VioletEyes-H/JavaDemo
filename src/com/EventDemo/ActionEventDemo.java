package com.EventDemo;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * 动作事件监听
 * 如按钮，选择菜单等点击事件
 * 
 *
 */
public class ActionEventDemo extends JFrame implements ActionListener{
	JButton btn = new JButton("Action");
	public ActionEventDemo() {
		setTitle("ActionEvent");
		setBounds(300,300,100,100);
		setVisible(true);
		Container c = getContentPane();
		JPanel p = new JPanel();
		p.add(btn);
		c.add(p,BorderLayout.CENTER);
		validate();
		btn.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ActionEventDemo();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn)
		{
			JOptionPane.showMessageDialog(this,"按钮被点击了");
		}
	}
}
