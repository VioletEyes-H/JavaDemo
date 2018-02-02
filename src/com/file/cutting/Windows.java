package com.file.cutting;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

public class Windows extends JFrame implements ActionListener {
	private static final long serialVersionUID = -182566503932148485L;

	/**
	 * 
	 */
	JTextField srcText = new JTextField("��ѡ����Ҫ�и���ļ�");
	JButton srcFile = new JButton("��");
	JTextField destText = new JTextField("��ѡ�񱣴��ļ���");
	JButton destFile = new JButton("����");
	JButton start = new JButton("��ʼ�ָ�");
	static JTextArea msg = new JTextArea();
	JScrollPane jsp = new JScrollPane(msg);
	String src = "", dest = "";
	String[] list = { "1M", "5M", "10M", "100M", "200M", "500M", "1G" };
	int[] sdsize = { 1, 5, 10, 100, 200, 500, 1024 };
	JComboBox<String> sd = new JComboBox<String>(list);
	int size = 1;

	public Windows() {
		// TODO Auto-generated constructor stub
		setTitle("File Cutting");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 400;
		int height = 500;
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		srcText.setEnabled(false);
		destText.setEnabled(false);
		setLayout(null);
		JPanel p1 = new JPanel();
		p1.setBounds(40, 20, 300, 35);
		srcText.setPreferredSize(new Dimension(200, 28));
		p1.add(srcText);
		p1.add(srcFile);
		add(p1);
		JPanel p2 = new JPanel();
		p2.setBounds(40, 60, 300, 35);
		destText.setPreferredSize(new Dimension(200, 28));
		p2.add(destText);
		p2.add(destFile);
		add(p2);
		JPanel p3 = new JPanel();
		p3.setBounds(138, 100, 100, 45);
		p3.add(start);
		sd.setBounds(280, 105, 70, 25);
		add(sd);
		add(p3);
		msg.setEditable(false);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);// ������ʾ���������
		msg.setLineWrap(true);// �Զ�����
		msg.setWrapStyleWord(true);
		jsp.setBounds(30, 150, 330, 300);
		add(jsp);

		start.addActionListener(this);
		srcFile.addActionListener(this);
		destFile.addActionListener(this);
		DefaultCaret caret = (DefaultCaret) msg.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);// ������һֱ��������
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "��ʼ�ָ�":

			size = sdsize[sd.getSelectedIndex()];
			if (dest != "" || src != "") {
				new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Action.cut(new File(src), dest, size);
					}
				}).start();
			} else {
				JOptionPane.showMessageDialog(this, "��ѡ���ļ��򱣴�·��", "��ʾ:", JOptionPane.INFORMATION_MESSAGE);
			}

			break;
		case "��":
			src = Action.src();
			srcText.setText(src);
			msg.append("ѡ�����ļ�:\n" + src + "\n");
			break;
		case "����":
			dest = Action.dest();
			destText.setText(dest);
			msg.append("�ļ����浽:\n" + dest + "\n");
			break;
		}
	}
}
