package com.yc.javax.servlet;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class YcServletContext implements ServletContext {
	private Map<String,Servlet> servlets = new Hashtable<String, Servlet>();
	private Map<String ,Object> attributes = new HashMap<String, Object>();
	private  static YcServletContext ycservletContext;
	//私有化构造函数
	private YcServletContext(){}
	public synchronized static YcServletContext getInstance(){
		if(ycservletContext == null){
			ycservletContext = new YcServletContext();
		}
		return ycservletContext;
	}
	@Override
	public Map<String, Servlet> getServlets() {
		return this.servlets;
	}
	@Override
	public Servlet getServlet(String servletName) {
		return this.servlets.get(servletName);
	}
	@Override
	public void setServlet(String servletName, Servlet servlet) {
		this.servlets.put(servletName, servlet);
	}

	@Override
	public void setAttribute(String key, Object value) {
		this.attributes.put(key, value);
	}

	@Override
	public Object getAttribute(String key) {
		return this.attributes.get(key);
	}

}
