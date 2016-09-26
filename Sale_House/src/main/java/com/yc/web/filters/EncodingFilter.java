package com.yc.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	private String encodeName = "utf-8";
	public void init(FilterConfig filterConfig) throws ServletException {
		if(filterConfig.getInitParameter("encodeName") != null ){
			this.encodeName = filterConfig.getInitParameter("encodeName");
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encodeName);
		chain.doFilter(request, response);
	}
	public void destroy() {
		
	}

}
