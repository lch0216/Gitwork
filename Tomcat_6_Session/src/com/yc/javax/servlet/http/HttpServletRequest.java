package com.yc.javax.servlet.http;

import com.yc.javax.servlet.ServletContext;
import com.yc.javax.servlet.ServletRequest;
import com.yc.server.YcHttpSession;

public interface HttpServletRequest extends ServletRequest {
	public String getMethod();
	public String getRequestURI();
	public ServletContext getServletContext();
	public HttpSession getSession();
	public String getHead(String name);
}
