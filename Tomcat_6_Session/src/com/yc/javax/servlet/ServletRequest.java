package com.yc.javax.servlet;

import java.util.Map;

public interface ServletRequest {
	public String getRealPath();
	public Object getAttribute(String key);
	public void setAttribute(String key,Object value);
	/**
	 * 通过解析url地址 获取参数 
	 * @param key
	 * @return
	 */
	public String getParameter (String key);
	
	public Map<String ,String> getParameterMap();
	/**
	 * 解析uri --》解析出参数--》 解析出请求方式 get post head 
	 * @return
	 */
	public void parse();
	/**
	 * 获取请求URI
	 * @return
	 */
	public String getServerName();
	public int getServerPort();
}
