package com.EventDemo;

import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TextEventDemo extends JFrame implements TextListener{
	TextArea input = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);//awt窗体设计，带滚动条
	TextArea output = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TextEventDemo();
	}
	public TextEventDemo() {
		// TODO Auto-generated constructor stub
		setTitle("TextEvent");
		setVisible(true);
		setBounds(300,300,300,300);
		JPanel p = new JPanel(new GridLayout(2,1));
		p.add(input);
		p.add(output);
		output.setEditable(false);
		input.addTextListener(this);
		add(p);
	}
	@Override
	public void textValueChanged(TextEvent e) {
		// TODO Auto-generated method stub
		output.setText(input.getText());
	}
}
