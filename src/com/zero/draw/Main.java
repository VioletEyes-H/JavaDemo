package com.zero.draw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

public class Main extends JFrame {
	private Graphics g;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

	public Main() {
		// TODO Auto-generated constructor stub
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		panle jp = new panle();
		int width = 500;
		int height = 500;
		int wx = (screen.width - width) / 2;
		int hy = (screen.height - height) / 2;
		setTitle("MouseDraw");
		setBounds(wx, hy, width, height);
		setVisible(true);
		setLayout(null);
		JPanel draw = new JPanel();
		// draw.setPreferredSize(new Dimension(300, 300));
		// draw.setBackground(Color.WHITE);
		draw.setBounds(10, 10, 400, 400);
		this.add(draw);
		g = draw.getGraphics();
		jp.setG(g);
		draw.addMouseListener(jp);
		draw.addMouseMotionListener(jp);
	}

}

class panle implements MouseListener, MouseMotionListener {
	Color black = Color.black;
	int x = -1;
	int y = -1;
	static int array[] = new int[10000];
	int i, x1, x2, y1, y2;
	private Graphics g;

	public void setG(Graphics g) {
		this.g = g;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		x1 = e.getX();
		y1 = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();
		// g.drawLine(x1, y1, x2, y2);
//		g.drawRect(x1, y1, x2-x1, y2-y1);//画正方形
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		g.drawLine(x, y, x1, y1);	//画线条	
		x1 = x;
		y1 = y;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}