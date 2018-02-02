package com.Thread.Demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.timer.TimerMBean;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ThreadDemo extends JFrame implements Runnable {
	JLabel msg = new JLabel("≤‚ ‘Œƒ◊÷");
	JLabel xx = new JLabel();
	Thread move;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadDemo();
	}

	public ThreadDemo() {
		// TODO Auto-generated constructor stub
		setTitle("ThreadDemo");
		setBounds(300, 300, 500, 200);
		setVisible(true);
		add(msg);
		setLayout(null);
		msg.setBounds(0, 0, 100, 20);
		xx.setBounds(0, 50, 100, 20);
		add(xx);
		move = new Thread(this);
		move.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int x = msg.getX();
		while (true) {

			if (x < 475) {
				x++;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				msg.setLocation(x, 0);
			}
			if (x >= 475) {
				x = 0;
			}

			xx.setText(String.valueOf(x));
		}
	}

}
