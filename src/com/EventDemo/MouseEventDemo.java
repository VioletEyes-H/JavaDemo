package com.EventDemo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MouseEventDemo extends JFrame implements MouseListener,MouseMotionListener{
	JTextArea msg= new JTextArea("�������¼�");
	JScrollPane bar = new JScrollPane(msg);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseEventDemo();
	}
	public MouseEventDemo() {
		// TODO Auto-generated constructor stub
		setTitle("MouseEven");
		setVisible(true);
		setBounds(300,300,300,300);
		add(bar);
		msg.setEditable(false);
		msg.addMouseListener(this);
		msg.addMouseMotionListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		msg.append("�������\n");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		msg.append("������Label\n");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		msg.append("����뿪��Label\n");
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getButton()==MouseEvent.BUTTON1)
		{
			msg.append("����������\n");
		}else if(e.getButton()==MouseEvent.BUTTON2)
		{
			msg.append("��������м�\n");
		}else if(e.getButton()==MouseEvent.BUTTON3)
		{
			msg.append("��������Ҽ�\n");
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		msg.append("�ͷ�����갴��\n");
	}
	@Override
	public void mouseDragged(MouseEvent e) { //��갴��ʱ����
		// TODO Auto-generated method stub
		msg.append(String.valueOf("X="+e.getX())+"\n");
		msg.append(String.valueOf("Y="+e.getY())+"\n");
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
