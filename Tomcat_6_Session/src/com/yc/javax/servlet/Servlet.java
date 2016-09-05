package com.yc.javax.servlet;

public interface Servlet {
	/**
	 * 创建servlet 按生命周期调用对应的方法
	 */
	public void init();
	public void service(ServletRequest request ,ServletResponse response);
	public void destory();
	
}
