package com.yc.javax.servlet.http;

import com.yc.javax.servlet.JspWriter;
import com.yc.javax.servlet.ServletResponse;
/**
 * 处理http方式的
 * @author Rainbow
 *
 */
public interface HttpServletResponse extends ServletResponse {
	/**response.addCookie 添加cookie写到客户端 说明 response 有 cookie对象 
	 * 同时 response可以 添加多个cookie 集合存储cookie对象
	 * 
	 * 
	 * 重定向
	 */
	public void sendRedirect();
	public void addCookie(Cookie cookie);
	public JspWriter getJSpWriter();
	public Cookie[] getCookies();
}
