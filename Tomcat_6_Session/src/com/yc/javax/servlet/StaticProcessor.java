package com.yc.javax.servlet;

import com.yc.javax.servlet.http.HttpServletResponse;
import com.yc.server.Processor;

public class StaticProcessor implements Processor{
	//获取资源实现重定向
	@Override
	public void process(ServletRequest request, ServletResponse response) {
		((HttpServletResponse)response).sendRedirect();
	}
}
