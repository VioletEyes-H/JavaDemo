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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/*
 * 滚动 窗口案例
 */
public class JScrollPaneDemo extends JFrame implements ActionListener {
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	int w = screen.width;
	int h = screen.height;
	JLabel img = new JLabel(new ImageIcon("img/icon.png"));
	JButton b1 = new JButton("显");//显示滚动条
	JButton b2 = new JButton("隐");//隐藏滚动条
	JButton b3 = new JButton("必");//必要时显示滚动条
	JScrollPane js = new JScrollPane(img);
	JPanel jp = new JPanel(new GridLayout(1, 3));
	
	public JScrollPaneDemo() {
		Container c = getContentPane();
		c.add(js, "Center");
		c.add(jp, "South");
		jp.add(b1);
		jp.add(b2);
		jp.add(b3);
		setTitle("滚动窗口");
		int x = (w-200)/2;
		int y = (h-200)/2;
		setBounds(x, y, 200, 200);
		validate();
		setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JScrollPaneDemo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("显"))
		{
			js.setVerticalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		}
	}

}
