package com.eec.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 
  *  <p>Class Name: DateUtils.java</p>
  *  <p>Description: 日期转换工具类   Java里面用的日期类型是util，数据库里面是sql
  *  1、将字符串转换为java.util.Date
  *  2、将java.util.Date转换为java.sql.Date
  *  </p>
  *  @author  舒家峰  DateTime 2018年2月12日 下午10:22:26 
  *  @company 安徽科技学院 
  *  @email  1185577383@qq.com  
  *  @version 1.0
 */
public class DateUtils {

	/**
	 * 将字符串转换为java.util.Date
	 * @param str  需要转换为java.util.Date的字符串
	 * @return  返回java.util.Date类型的日期
	 */
	public static java.util.Date strToUtilDate(String str){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date=null;
		try {
			date=sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 将java.util.Date转换为java.sql.Date
	 * @param utilDate
	 * @return
	 */
	public static java.sql.Date utilDateTosqlDate(java.util.Date utilDate){
		java.sql.Date sqlDate=null;
		long times=utilDate.getTime();
		sqlDate=new java.sql.Date(times);
		return sqlDate;
	}
}
