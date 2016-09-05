package com.yc.server;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yc.javax.servlet.JspWriter;
import com.yc.javax.servlet.http.Cookie;
import com.yc.javax.servlet.http.HttpServletResponse;

public class YcHttpServletResponse implements HttpServletResponse {
	private String http;// 协议
	private String contentType;// 协议
	private int statusCode;// 状态码
	private String status;// 请求状态
	private OutputStream os = null;
	private YcHttpServletRequest request;
	private Cookie[] cookies = new Cookie[50];
	private int cookieIndex = 0;
	//请求完成 创建 response 响应对象时 将sessionID 传人cookie写到 客户端
	public YcHttpServletResponse(YcHttpServletRequest request, OutputStream os) {
		this.request = request;
		this.os = os;
		Cookie cookie = new Cookie(Constants.SESSIONID, request.getSessionId());
		cookies[cookieIndex] = cookie;
		cookieIndex ++;
	}
	public void sendRedirect() {
		String uri = request.getRequestURI();
		String realPath = request.getRealPath();
		File file = new File(realPath, uri);
		String responseprotocal = null;
		byte[] fileContent = null;// 响应正文内容
		if (!file.exists()) {
			fileContent = readFile(new File(realPath, request.getContextPath()
					+ "/404.html"));
			responseprotocal = Out404Page(fileContent.length);
		} else {
			fileContent = readFile(file);
			responseprotocal = Out200Page(fileContent.length);
		}
		try {
			os.write(responseprotocal.getBytes());
			os.flush();
			os.write(fileContent);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					this.os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private byte[] readFile(File file) {
		FileInputStream fis = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();// 字节数组输出流，存储在内存中
		try {
			fis = new FileInputStream(file);
			byte[] bs = new byte[1024];
			int length = -1;
			while ((length = fis.read(bs, 0, bs.length)) != -1) {
				baos.write(bs, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos.toByteArray();
	}

	private String Out200Page(long bodyLength) {
		String uri = this.request.getRequestURI();
		int index = uri.indexOf(".");
		if (index >= 0) {
			index = index + 1;
		}
		String fileExtension = uri.substring(index);
		String protocal200 = null;
		if ("JPG".equalsIgnoreCase(fileExtension)
				|| "JEPG".equalsIgnoreCase(fileExtension)) {
			contentType = "image/JPEG";
			protocal200 = "HTTP/1.1 200 OK\r\nContent-Type: " + contentType
					+ "\r\nContent-Length: " + bodyLength + "\r\n\r\n";
		} else if ("PNG".equalsIgnoreCase(fileExtension)) {
			contentType = "image/PNG";
			protocal200 = "HTTP/1.1 200 OK\r\nContent-Type: " + contentType
					+ "\r\nContent-Length: " + bodyLength + "\r\n\r\n";
		} else if ("json".equals(fileExtension)) {
			contentType = "application/json";
			protocal200 = "HTTP/1.1 200 OK\r\nContent-Type: " + contentType
					+ "\r\nContent-Length: " + bodyLength + "\r\n\r\n";
		} else {
			contentType = "text/html;charset=utf-8";
			protocal200 = "HTTP/1.1 200 OK\r\nContent-Type: " + contentType
					+ "\r\nContent-Length: " + bodyLength + "\r\n\r\n";
		}
		return protocal200;
	}
	private String Out404Page(int bodyLength) {
		String protocal404 = "HTTP/1.1 404 File Not Found\r\nContent-Type: text/html;charset=utf-8\r\nContent-Length:"
				+ bodyLength + "\r\n\r\n";
		return protocal404;
	}

	@Override
	public PrintWriter getWriter() {
		PrintWriter pw = new PrintWriter( this.os );
		return pw;
	}

	@Override
	public String getContentType() {
		return this.contentType;
	}
	@Override
	public void addCookie(Cookie cookie) {
		if(cookieIndex >= cookies.length){
			return;
		}
		cookies[cookieIndex] = cookie;
		cookieIndex ++;
	}
	//response 的输出流  
	@Override
	public JspWriter getJSpWriter() {
		JspWriter jw =  new JspWriter(os, this);
		return jw;
	}
	@Override
	public Cookie[] getCookies(){//得到当前实际的cookie，因为最大值 是多个
		Cookie[] cs = new Cookie[cookieIndex];
		for ( int i=0;i<cookieIndex ; i++) {
			cs[i] = cookies[i];
		}
		return cs;
	}
}
