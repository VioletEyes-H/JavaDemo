package com.vz.frame;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TimerAndProgressBar extends JFrame implements ActionListener, ChangeListener {
	JButton start = new JButton("Start");
	JButton stop = new JButton("Stop");
	JProgressBar bar = new JProgressBar();
	JLabel msg = new JLabel("aaa", JLabel.CENTER);
	Timer time = new Timer(100, this);
	JPanel p1 = new JPanel(new GridLayout(3, 1));
	JPanel b1 = new JPanel(new GridLayout(1, 2));

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TimerAndProgressBar();
	}

	public TimerAndProgressBar() {
		// TODO Auto-generated constructor stub
		Container c = getContentPane();
		setTitle("ProgressBar");
		setBounds(200, 200, 300, 140);
		setVisible(true);
		JPanel p = new JPanel();
		c.setLayout(null);
		p.setBounds(0, 0, 300, 40);
		p.add(start);
		p.add(Box.createHorizontalStrut(20));
		p.add(stop);
		c.add(bar);
		bar.setBounds(0, 40, 300, 40);
		bar.setString("Loading...");
		// bar.setPreferredSize(new Dimension(300, 40));//初始化进度条尺寸
		bar.setStringPainted(true);// 是否呈现文字
		bar.setBackground(Color.white);
		bar.setForeground(Color.black);
		bar.addChangeListener(this);
		msg.setBounds(0, 80, 300, 20);
		c.add(msg);
		c.add(p);
		start.addActionListener(this);
		stop.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == start) {
			time.start();
		} else if (e.getSource() == stop) {
			time.stop();
		} else if (e.getSource() == time) {
			int value = bar.getValue();
			if (value < 100) {
				value++;
				bar.setValue(value);
			} else {
				time.stop();
				bar.setValue(0);
			}
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		int value = bar.getValue();
		if (e.getSource() == bar) {
			msg.setText("目前已完成:" + Integer.toString(value) + "%");
		}
	}

}
