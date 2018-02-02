package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_DBUtil {
	static Connection connect = null;

	public static Connection getConnect() {
		return connect;
	}

	static {
		try {
			// 加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库的连接
			connect = DriverManager.getConnection(
					"jdbc:mysql://172.20.46.16:3306/data?useUnicode=true&characterEncoding=utf-8&useSSL=false", "zero",
					"devil");
			// 通过数据库的连接操作数据库，实现增删改
			Statement state = connect.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
