package com.vz.frame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * 综合控件使用
 */
public class Common extends JFrame {

	JLabel title = new JLabel("Input your basic infomation");
	JLabel name = new JLabel("your name:");
	JLabel sex = new JLabel("your sex:");
	JLabel weight = new JLabel("your weight(kg):");
	JLabel inter = new JLabel("your interest:");
	JLabel city = new JLabel("the city you want live ...");
	JTextField nameIn = new JTextField();
	JPasswordField weightPass = new JPasswordField();
	JRadioButton boy = new JRadioButton("boy");
	JRadioButton girl = new JRadioButton("girl");
	ButtonGroup bSex = new ButtonGroup();
	JButton submit = new JButton("submit");
	JButton reset = new JButton("reset");
	JCheckBox read = new JCheckBox("Read");
	JCheckBox tour = new JCheckBox("Tour");
	JCheckBox sport = new JCheckBox("Sport");
	JCheckBox game = new JCheckBox("Game");
	String[] cityList = { "BeiJing", "ShangHai", "GuangZhou", "ShenZhen" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox cityBox = new JComboBox(cityList);
	CommonActivityListener listen = new CommonActivityListener(this);

	public Common() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int w = screen.width;
		int h = screen.height;
		int width = 320;
		int height = 300;
		int x = (w - width) / 2;
		int y = (h - height) / 2;
		Container c = getContentPane();
		c.setLayout(null);
		JPanel p = new JPanel();
		p.setBounds(0, 0, 300, 30);
		p.add(title);
		JPanel p1 = new JPanel(new GridLayout(5, 2, 10, 10));
		p1.setBounds(0, 30, 300, 180);
		p1.add(name);
		p1.add(nameIn);
		p1.add(sex);
		JPanel box = new JPanel(new GridLayout(1, 2));
		box.add(boy);
		box.add(girl);
		bSex.add(boy);
		bSex.add(girl);
		p1.add(box);
		p1.add(weight);
		p1.add(weightPass);
		p1.add(inter);
		JPanel checkbox = new JPanel(new GridLayout(2, 2));
		checkbox.add(read);
		checkbox.add(tour);
		checkbox.add(sport);
		checkbox.add(game);
		p1.add(checkbox);
		p1.add(city);
		p1.add(cityBox);
		JPanel btn = new JPanel(new GridLayout(1, 2));
		btn.setBounds(0, 220, 300, 40);
		btn.setLayout(new BoxLayout(btn, BoxLayout.X_AXIS));// 从左到右水平布局
		btn.add(Box.createHorizontalStrut(50));// 创建一个不可见的固定宽度组件
		btn.add(submit);
		btn.add(Box.createHorizontalStrut(50));
		btn.add(reset);
		submit.addActionListener(listen);
		reset.addActionListener(listen);
		c.add(p1);
		c.add(p);
		c.add(btn);
		setTitle("Common Swing Demo");
		setBounds(x, y, width, height);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		sex.setHorizontalAlignment(SwingConstants.CENTER);
		weight.setHorizontalAlignment(SwingConstants.CENTER);
		inter.setHorizontalAlignment(SwingConstants.CENTER);
		city.setHorizontalAlignment(SwingConstants.CENTER);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Common();

	}

}
