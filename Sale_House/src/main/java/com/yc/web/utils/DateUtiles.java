package com.yc.web.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class DateUtiles {
	//定义默认的时间格式
	private static final String LONG_PATTERN="yyyy年MM月dd日 HH:mm:ss";
	private static final String SHORT_PATTERN="yyyy年MM月dd日";
/**
 * 日期转换为字符串
 * @param d
 * @param pattern 日期格式
 * @return
 */
	public static String parse(Date d,String pattern){
		DateFormat df = null;
		if(pattern!=null && !"".equals(pattern)){
			df = new SimpleDateFormat(pattern);
			
		}else{
			df= new SimpleDateFormat(LONG_PATTERN);
		}
		return df.format(d);
	}

	/**
	 * 字符串转换为日期
	 * @param d
	 * @param pattern
	 * @return
	 */
	public static Date parseStringtoDate(String str ,String pattern){
		DateFormat df = null;
		if(pattern!=null && !"".equals(pattern)){
			df = new SimpleDateFormat(pattern);
			
		}else{
			df= new SimpleDateFormat(LONG_PATTERN);//无格式参数时使用默认格式
		}
		Date d= null;
		try {
			d = df.parse(str);
		} catch (ParseException e) {
			LogUtils.logger.debug(e);
		}
		return d;
	}

}
