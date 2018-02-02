package com.EventDemo;

import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
/*
	列表监听事件
 */
public class ItemEventDemo extends JFrame implements ItemListener{
	JLabel city = new JLabel("请选择你喜欢的城市：");
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
		cityList.add("上海");
		cityList.add("北京");
		cityList.add("深圳");
		add(cityList,"Center");
		add(msg,"South");
		cityList.addItemListener(this);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		msg.setText("你喜欢的城市是："+cityList.getSelectedItem()+"  列表序号是："+e.getItem());//cityList.getSelectedIndex()
	}

}
