package com.yc.web.utils;

import java.lang.reflect.Type;

import com.google.gson.Gson;


/**
 * java对象和json字符串的相互转化
 * @author Rainbow
 *
 */
public final  class JsonUtils {
	  private JsonUtils(){}  
      
	    /** 
	     * 对象转换成json字符串 
	     * @param obj  
	     * @return  
	     */  
	    public static String toJson(Object obj) {  
	        Gson gson = new Gson();  
	        return gson.toJson(obj);  
	    }  
	  
	    /** 
	     * json字符串转成对象 ，利用反射机制
	     * @param str   
	     * @param  type即为类对象 obj.class 
	     * @return  
	     */  
	    public static <T> T fromJson(String str, Type type) {  
	        Gson gson = new Gson();  
	        return gson.fromJson(str, type);  
	    }  
	  
	    /** 
	     * json字符串转成对象 
	     * @param str   
	     * @param type  即为类对象 obj.class
	     * @return  
	     */  
	    public static <T> T fromJson(String str, Class<T> type) {  
	        Gson gson = new Gson();  
	        return gson.fromJson(str, type);  
	    } 
}
