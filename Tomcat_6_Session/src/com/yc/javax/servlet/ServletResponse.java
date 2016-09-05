package com.yc.javax.servlet;

import java.io.PrintWriter;

public interface ServletResponse {
	/**
	 * 获取输出流  
	 * @return
	 */
	public PrintWriter getWriter();
	/**
	 * 获取响应的内容类型
	 * @return
	 */
	public String getContentType();
}
