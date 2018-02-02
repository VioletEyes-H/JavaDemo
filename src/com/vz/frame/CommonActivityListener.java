package com.vz.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class CommonActivityListener implements ActionListener {
	Common ob;

	public CommonActivityListener(Common ob) {
		// TODO Auto-generated constructor stub
		this.ob = ob;
		ob.nameIn.setText("");
		ob.weightPass.setText("");
		ob.bSex.clearSelection();
		ob.sport.setSelected(false);
		ob.game.setSelected(false);
		ob.tour.setSelected(false);
		ob.read.setSelected(false);
		ob.cityBox.setSelectedItem(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "submit":
			this.submit();
			break;
		case "reset":
			this.reset();
			break;

		default:
			System.out.println("Erro");
			break;
		}
	}

	public void submit() {
		JFrame out = new JFrame("Your Basic Information");
		String output = "Your Basic Information\n";
		if (ob.nameIn.getText().trim().equals("")) {
			output += "Name:\t" + "Null\n";
		} else {
			output += "Name:\t" + ob.nameIn.getText() + "\n";
		}

		if (ob.boy.isSelected()) {
			output += "Sex:\tBoy\n";
		} else if (ob.girl.isSelected()) {
			output += "Sex:\tGirl\n";
		} else {
			output += "Sex:\tNull\n";
		}
		String weight = new String(ob.weightPass.getPassword());
		output += "Weight(kg):\t" + weight + " kg\n";
		output += "Hobby:\t";
		if (ob.read.isSelected()) {
			output += ob.read.getText() + " ";
		}
		if (ob.sport.isSelected()) {
			output += ob.sport.getText() + " ";
		}
		if (ob.tour.isSelected()) {
			output += ob.tour.getText() + " ";
		}
		if (ob.game.isSelected()) {
			output += ob.game.getText() + " ";
		}
		output += "\n";
		if (ob.nameIn.getText().equals("")) {
			JOptionPane.showMessageDialog(out, "Please Selected Your Name!");
			return;
		} else if (ob.boy.isSelected() == false && ob.girl.isSelected() == false) {
			JOptionPane.showMessageDialog(out, "Please Selected Your Sex!");
			return;
		} else if (weight.equals("")) {
			JOptionPane.showMessageDialog(out, "Please Selected Your Weight!");
			return;
		}
		try {
			output += "City:\t" + ob.cityBox.getSelectedItem().toString();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(out, "Please Selected Your City!");
			return;
		}

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int h = screen.height;
		int w = screen.width;
		int width = 300;
		int height = 200;
		int y = (h - height) / 2;
		int x = (w - width) / 2;
		out.setBounds(x, y, width, height);
		out.setVisible(true);
		JTextArea put = new JTextArea(output);
		put.setEditable(false);
		out.add(put);
	}

	public void reset() {
		ob.nameIn.setText("");
		ob.weightPass.setText("");
		ob.bSex.clearSelection();
		ob.sport.setSelected(false);
		ob.game.setSelected(false);
		ob.tour.setSelected(false);
		ob.read.setSelected(false);
		ob.cityBox.setSelectedItem(null);
	}
}
