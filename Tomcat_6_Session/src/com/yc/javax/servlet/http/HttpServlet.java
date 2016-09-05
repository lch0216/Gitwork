package com.yc.javax.servlet.http;

import com.yc.javax.servlet.Servlet;
import com.yc.javax.servlet.ServletRequest;
import com.yc.javax.servlet.ServletResponse;
/**
 * 使用抽象类 应用适配器模式  HttpServlet的实现类 可以只实现部分方法
 * @author Rainbow
 *
 */
public abstract class HttpServlet implements Servlet{
	@Override
	public void init() {
		
	}
	@Override
	public void destory() {
		
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response){}
	protected void doPost(HttpServletRequest request,HttpServletResponse response){}
	protected void doDelete(HttpServletRequest request,HttpServletResponse response){}
	protected void doHead(HttpServletRequest request,HttpServletResponse response){}

	
	public void service(ServletRequest request ,ServletResponse response) {
		this.service((HttpServletRequest)request, (HttpServletResponse)response);
	}
	
	public void service(HttpServletRequest request ,HttpServletResponse response){
		String method = ((HttpServletRequest)request).getMethod();
		if( "GET".equalsIgnoreCase(method) ){
			doGet((HttpServletRequest)request, (HttpServletResponse)response);
		}else if("POST".equalsIgnoreCase(method)){
			doPost((HttpServletRequest)request, (HttpServletResponse)response);
		}else if("HEAD".equalsIgnoreCase(method)){
			doHead((HttpServletRequest)request, (HttpServletResponse)response);
		}else if("DELETE".equalsIgnoreCase(method)){
			doDelete((HttpServletRequest)request, (HttpServletResponse)response);
		}
	}
	
	
}