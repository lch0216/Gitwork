package com.yc.javax.servlet;

import java.util.Map;

public interface ServletContext {
	public Map<String,Servlet> getServlets();
	
	public Servlet getServlet(String servletName);
	public void setServlet(String servletName,Servlet servlet);
	public void setAttribute(String key,Object value);
	public Object getAttribute(String key);
 }
