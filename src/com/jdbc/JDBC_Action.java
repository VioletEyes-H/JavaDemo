package com.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDBC_Action {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("欢迎使用Zero商城管理系统");
		Scanner in = new Scanner(System.in);
		Boolean system = true;
		while (system) {
			JDBC_Action.menu();
			System.out.print("请输入系统指令：");
			String cmd = in.next();
			switch (cmd) {
			case "show":
				List<JDBC_Information> list = new JDBC_Management().query();
				for (JDBC_Information im : list) {
					System.out.println("商品编号：" + im.getGoods_id() + "\t商品名称：" + im.getGoods_name());
				}
				Boolean a = true;
				String temp = null;
				while (a) {
					System.out.print("请输入编号查看商品信息：");
					temp = in.next();
					if (temp.equals("exit")) {
						a = false;
						break;
					}
					try {
						int i = Integer.valueOf(temp);
						new JDBC_Management().showCommodity(i);
					} catch (Exception e) {
						System.out.println("请输入商品编号，退出请输入exit");
					}
				}
				break;
			case "add":
				new JDBC_Management().addCommodity();
				break;
			case "del":
				new JDBC_Management().delCommodity();
				break;
			case "update":
				new JDBC_Management().updateCommodity();
				break;
			case "exit":
				break;
			default:
				System.out.println("指令不存在");
				break;
			}
		}
	}

	public static void menu() {
		System.out.println("***********************************");
		System.out.println("*****       ADD：添加商品       *****");
		System.out.println("*****       DEL：删除商品        *****");
		System.out.println("*****  SHOW：显示商品列表  *****");
		System.out.println("***** UPDATE：修改商品信息 *****");
		System.out.println("*****    EXIT：退出管理系统    *****");
		System.out.println("***********************************");
	}

}
