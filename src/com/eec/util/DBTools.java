package com.eec.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBTools {

	/**
	 * 获取数据库的连接
	 * 
	 * @return 返回的是数据库的连接对象
	 */
	public static Connection getConnection() {
		Connection conn = null;
		// 读取配置文件配置的信息，数据库驱动类、url、user、password
		InputStream in = DBTools.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop = new Properties();
		try {
			// 加载属性文件
			prop.load(in);
			// 通过反射加载类的驱动
			Class.forName(prop.getProperty("driver"));
			// 获取数据库连接对象
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
					prop.getProperty("pwd"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭释放所有的资源
	 * 
	 * @param rs
	 *            结果集对象
	 * @param pstmt
	 *            命令对象：执行SQL语句
	 * @param conn
	 *            连接对象
	 */
	public static void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
