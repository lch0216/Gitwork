package com.yc.javax.servlet;

import java.io.OutputStream;
import java.io.PrintWriter;

import com.yc.javax.servlet.http.Cookie;
import com.yc.javax.servlet.http.HttpServletResponse;

public class JspWriter extends PrintWriter{
	/**
	 * servlet中没有添加写出cookie的操作 ，所以此方法包含在输出流Writer中
	 * 写出cookie到客户端 
	 */
	private ServletResponse response;
	public JspWriter(OutputStream os) {
		super(os);
	}

	public JspWriter(OutputStream os,ServletResponse response) {
		super(os);
		this.response = response;
	}
	public void println(String content) {
		StringBuffer sb = new StringBuffer();
		String protocal = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\nContent-Length: " + content.getBytes().length+"\r\n";
		sb.append(protocal);
		Cookie[] cookies = ((HttpServletResponse)response).getCookies();
		if(cookies != null && cookies.length > 0 ){
			sb.append("Set-Cookie: ");
			for(Cookie c: cookies ){
				sb.append( c.toString() );
			}
		}
		sb.append("\r\n\r\n");
		sb.append(content);
		super.println( sb.toString() );
		super.flush();
	}
}
