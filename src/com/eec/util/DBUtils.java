package com.eec.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class DBUtils {

	/**
	 * 执行增删改的通用方法
	 * 
	 * @param sql
	 *            SQL语句
	 * @param objs
	 *            SQL语句对应的参数也就是占位符问号？
	 * @return 返回的是受影响的行数
	 */
	public int update(String sql, Object... objs) {
		int lines = -1;// 记录受影响的行数
		Connection conn = DBTools.getConnection();// 获取数据库连接对象
		PreparedStatement pstmt = null;// 创建命令对象
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			lines = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTools.closeAll(null, pstmt, conn);// 关闭所有资源
		}
		return lines;
	}

	/**
	 * 返回单个实体，例如根据用户名查询，或者根据id查询
	 * 
	 * @param clazz
	 *            具体的某个类
	 * @param sql
	 *            SQL语句
	 * @param objs
	 *            SQL语句携带参数
	 * @return 返回的是某个类的实体
	 */
	public <T> T getForObject(Class<T> clazz, String sql, Object... objs) {
		T entity = null;
		Connection conn = DBTools.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			rs = pstmt.executeQuery();
			if (rs.next()) {
				entity = clazz.newInstance();// 确保每个实体类都要有无参构造器
				ResultSetMetaData rsmd = rs.getMetaData();
				// 读取的列和列对应的值放入Map集合
				Map<String, Object> map = new HashMap<>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					// 取出列名
					String columnLabel = rsmd.getColumnLabel(i + 1);
					// 取出类对应的值
					Object columnValue = rs.getObject(i + 1);
					// 存入Map集合
					map.put(columnLabel, columnValue);
				}
				if (map.size() > 0) {
					for (String key : map.keySet()) {
						// 通过反射，给类的属性一一赋值
						BeanUtils.setProperty(entity, key, map.get(key));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			DBTools.closeAll(rs, pstmt, conn);
		}
		return entity;
	}

	/**
	 * 查询大于一条信息的方法，返回一个列表
	 * 
	 * @param clazz
	 *            具体的某个类
	 * @param sql
	 *            SQL语句
	 * @param objs
	 *            SQL语句携带参数
	 * @return 返回列表
	 */
	public <T> List<T> getForList(Class<T> clazz, String sql, Object... objs) {
		List<T> list = new ArrayList<>();

		Connection conn = DBTools.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			rs = pstmt.executeQuery();
			// 读取的列和列对应的值放入Map集合
			List<Map<String, Object>> list2 = new ArrayList<>();
			Map<String, Object> map = null;
			while (rs.next()) {

				ResultSetMetaData rsmd = rs.getMetaData();
				map=new HashMap<>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					// 取出列名
					String columnLabel = rsmd.getColumnLabel(i + 1);
					// 取出类对应的值
					Object columnValue = rs.getObject(i + 1);
					// 存入Map集合
					map.put(columnLabel, columnValue);
				}
				list2.add(map);
			}
			if (list2.size() > 0) {
				for (int i = 0; i < list2.size(); i++) {
					T entity = clazz.newInstance();// 确保每个实体类都要有无参构造器
					for (String key : list2.get(i).keySet()) {
						// 通过反射，给类的属性一一赋值
						BeanUtils.setProperty(entity, key, list2.get(i).get(key));
					}
					list.add(entity);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			DBTools.closeAll(rs, pstmt, conn);
		}
		return list;
	}

	/**
	 * 返回某个类的对象
	 * 
	 * @param sql
	 *            SQL语句
	 * @param objs
	 *            SQL语句携带参数
	 * @return 返回某个类的对象
	 */
	public Object getForValue(String sql, Object... objs) {
		Object obj = null;
		Connection conn = DBTools.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i + 1, objs[i]);
			}
			rs = pstmt.executeQuery();
			// 判断是否有数据
			if (rs.next()) {
				// 查询总行数
				obj = rs.getObject(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBTools.closeAll(rs, pstmt, conn);
		}
		return obj;
	}
}
