package com.yc.web.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class prac {
	//一日期转换
	private static final String Long_pattern = "yyyy年mm月dd日 HH:mm:ss";
	private static final String short_pattern = "yyyy年mm月dd日";
	/**
	 * 
	 * 
	 * @param str
	 * @param pattern 指定格式字符串
	 * @return
	 */
	public String date(Date d ,String pattern ){
		DateFormat df = null;
		if(pattern!=null && !"".equals(pattern)){
			df = new SimpleDateFormat(pattern);
		}else{
			df = new SimpleDateFormat(Long_pattern);
		}
		return df.format(d);
		
	}
	
	
	
	
	

}
