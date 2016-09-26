package com.yc.web.utils;

public class MoneyUtils {
	private static final String unit= "万仟佰拾亿仟佰拾万仟佰拾元角分";
	private static final String digit= "零壹贰叁肆伍陆柒捌玖";
	private static final double MAX_VALUE = 999999999999.99D;
	
	public static String change(double v){
		if(v<0 || v > MAX_VALUE){
			return "参数非法！";
		}
		
		long l = Math.round(v * 100);
		if(l==0){
			return "零元整";
		}
		String strValue = l + "";
		//用i来控制数
		int i = 0;
		//用j来控制单位
		int j = unit.length()-strValue.length();
		String rs = "";
		boolean isZero = false;
		for(;i<strValue.length();i++,j++){
			char ch = strValue.charAt(i);
			if(ch=='0'){
				isZero=true;
				if(unit.charAt(j)=='亿'|| unit.charAt(j)=='万'|| unit.charAt(j)=='元'){
					rs = rs+unit.charAt(j);
				}
			}else{
				if(isZero){
					rs= rs+"零";
					isZero = false;					
				}
				rs = rs+ digit.charAt(ch-'0')+unit.charAt(j);		
			}
		}
		//金额数为整数
		if(!rs.endsWith("分")){
			rs = rs+"整";
		}
		rs = rs.replaceAll("亿万", "亿");
		return rs;	
	}
}
