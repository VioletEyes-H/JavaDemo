package com.EventDemo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyEventDemo extends JFrame implements KeyListener{
	JLabel show  = new JLabel("A");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KeyEventDemo();
	}
	public KeyEventDemo() {
		// TODO Auto-generated constructor stub
		setTitle("KeyEvent");
		setVisible(true);
		setLayout(null);
		setBounds(300,300,300,300);
		show.setBounds(0,0,10,10);
		add(show);
		addKeyListener(this);
	}
	@Override
	public void keyPressed(KeyEvent e) {//敲击时调用
		// TODO Auto-generated method stub
		int x = show.getX();
		int y = show.getY();
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			y=y-10;
			if(y<0)
				y=250;
		}else if(KeyEvent.getKeyText(e.getKeyCode()).equals("向下箭头"))//有两种方法实现按钮监听
		{
			y+=10;
			if(y>250)
				y=0;
			
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			x-=10;
			if(x<0)
				x=270;
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			x+=10;
			if(x>270)
				x=0;
		}
		show.setLocation(x, y);
	}
	@Override
	public void keyReleased(KeyEvent e) {//按下时调用
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {//释放时调用
		// TODO Auto-generated method stub
		
	}
}
