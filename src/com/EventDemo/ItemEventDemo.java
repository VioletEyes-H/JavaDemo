package com.EventDemo;

import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
/*
	�б�����¼�
 */
public class ItemEventDemo extends JFrame implements ItemListener{
	JLabel city = new JLabel("��ѡ����ϲ���ĳ��У�");
	List cityList = new List(3);
	JLabel msg = new JLabel("sad");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ItemEventDemo();
	}
	public ItemEventDemo() {
		// TODO Auto-generated constructor stub
		setTitle("ItemEvent");
		setVisible(true);
		setBounds(300,300,300,300);
		add(city,BorderLayout.NORTH);
		cityList.add("�Ϻ�");
		cityList.add("����");
		cityList.add("����");
		add(cityList,"Center");
		add(msg,"South");
		cityList.addItemListener(this);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		msg.setText("��ϲ���ĳ����ǣ�"+cityList.getSelectedItem()+"  �б�����ǣ�"+e.getItem());//cityList.getSelectedIndex()
	}

}
