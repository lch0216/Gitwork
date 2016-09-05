package com.yc.javax.servlet.http;

import com.yc.javax.servlet.ServletContext;

public interface HttpSession {
	public String getId();
	public Object getAttribute(String key);
	public void setAttribute(String key ,Object value);
	public ServletContext getServletContext();
	public long getCreationTIme();
	public long getLastAccessTIme();
	public void removeAttribute(String name);
	
}
