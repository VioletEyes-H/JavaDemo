package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDBC_Management {
	@SuppressWarnings("resource")
	public void addCommodity() {
		JDBC_Information info = new JDBC_Information();
		Scanner in = new Scanner(System.in);
		try {
			System.out.println();
			System.out.print("请输入商品名称：");
			info.setGoods_name(in.next());
			System.out.print("请输入商品分类（台式机\\笔记本\\游戏本\\超极本\\平板电脑\\服务器/工作站）：");
			info.setGoods_cate(in.next());
			System.out.print("请输入商品品牌：");
			info.setBrand_name(in.next());
			System.out.print("请输入商品价格：");
			info.setGoods_price(in.nextDouble());
			System.out.print("请输入商品库存：");
			info.setIs_show(in.nextInt());
			System.out.print("请输入商品售货状态（0.下架，1.热卖）：");
			info.setIs_saleoff(in.nextInt());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("输入类型错误，请检查后重新输入");
			return;

		}
		System.out.println("商品添加中...");
		Connection connect = JDBC_DBUtil.getConnect();
		// 预编译SQL语句
		try {
			PreparedStatement prepar = connect.prepareStatement("INSERT INTO tdb_goods"
					+ "(goods_name,goods_cate,brand_name,goods_price,is_show,is_saleoff)" + "VALUES(" + "?,?,?,?,?,?)");
			prepar.setString(1, info.getGoods_name());
			prepar.setString(2, info.getGoods_cate());
			prepar.setString(3, info.getBrand_name());
			prepar.setDouble(4, info.getGoods_price());
			prepar.setInt(5, info.getIs_show());
			prepar.setInt(6, info.getIs_saleoff());
			prepar.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("商品添加失败，请检查网络或者信息是否错误");
			e.printStackTrace();
		}
		System.out.println("商品添加成功");
	}

	public void delCommodity() {
		try {
			Scanner in = new Scanner(System.in);
			System.out.print("请输入需要删除的商品编号：");
			int del_goods = in.nextInt();
			Connection conncet = JDBC_DBUtil.getConnect();
			PreparedStatement prepar = conncet.prepareStatement("DELETE FROM tdb_goods WHERE goods_id=?");
			prepar.setInt(1, del_goods);
			prepar.execute();
			System.out.println("商品删除成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("商品删除失败");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("请正确输入商品编号");
			return;
		}
	}

	public void updateCommodity() {
		JDBC_Information info = new JDBC_Information();
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tdb_goods SET ");
		Scanner in = new Scanner(System.in);
		System.out.print("请输入需要修改的商品编号：");
		info.setGoods_id(in.nextInt());
		System.out.print("请输入修改后名称(不修改输入null)：");
		info.setGoods_name(in.next());
		System.out.print("请输入修改后类型(不修改输入null)：");
		info.setGoods_cate(in.next());
		System.out.print("请输入修改后品牌(不修改输入null)：");
		info.setBrand_name(in.next());
		System.out.print("请输入修改后价格(不修改输入-1)：");
		info.setGoods_price(in.nextDouble());
		System.out.print("请输入修改后库存(不修改输入-1)：");
		info.setIs_show(in.nextInt());
		System.out.print("请输入修改后的状态(不修改输入5)：");
		info.setIs_saleoff(in.nextInt());

		if (!info.getGoods_name().equals("null"))
			sql.append("goods_name=" + info.getGoods_name()+",");
		if (!info.getGoods_cate().equals("null"))
			sql.append("goods_cate=" + info.getGoods_cate()+",");
		if (!info.getBrand_name().equals("null"))
			sql.append("brand_name=" + info.getBrand_name()+",");
		if (info.getGoods_price() != -1)
			sql.append("goods_price=" + info.getGoods_price()+",");
		if (info.getIs_show() != -1)
			sql.append("is_show=" + info.getIs_show()+",");
		if (info.getIs_saleoff() != -1)
			sql.append("is_saleoff=" + info.getIs_saleoff()+" ");
		sql.append("WHERE goods_id=" + info.getGoods_id());

		Connection conncet = JDBC_DBUtil.getConnect();
		Statement state;
		try {
			state = conncet.createStatement();
			state.executeUpdate(sql.toString());
			System.out.println("修改商品信息成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			System.out.println("失败");
			System.out.println(sql.toString());
			return;
		}

	}

	public List<JDBC_Information> query() {
		List<JDBC_Information> list = new ArrayList<JDBC_Information>();
		try {
			Connection connect = JDBC_DBUtil.getConnect();
			JDBC_Information im = null;
			Statement state = connect.createStatement();
			ResultSet res = state.executeQuery("SELECT * FROM tdb_goods");
			while (res.next()) {
				im = new JDBC_Information();
				im.setGoods_id(res.getInt("goods_id"));
				im.setGoods_name(res.getString("goods_name"));
				list.add(im);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void showCommodity(int i) {
		Connection connect = JDBC_DBUtil.getConnect();
		Statement state;
		try {
			state = connect.createStatement();
			ResultSet res_Goods = state.executeQuery("SELECT * FROM tdb_goods WHERE goods_id=" + i);
			if (res_Goods.next()) {
				System.out.println("商品编号：" + res_Goods.getString("goods_id"));
				System.out.println("商品名称：" + res_Goods.getString("goods_name"));
				System.out.println("商品类型：" + res_Goods.getString("goods_cate"));
				System.out.println("商品品牌：" + res_Goods.getString("brand_name"));
				System.out.println("商品价格：" + res_Goods.getString("goods_price"));
				System.out.println("商品库存：" + res_Goods.getString("is_show"));
				if (res_Goods.getString("is_saleoff").equals("1"))
					System.out.println("售货状态：热卖");
				else
					System.out.println("售货状态：已下架");
			} else {
				System.out.println("商品不存在");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
