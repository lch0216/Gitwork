package com.yc.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.yc.javax.servlet.ServletContext;
import com.yc.javax.servlet.YcServletContext;
import com.yc.javax.servlet.http.HttpServletRequest;
import com.yc.javax.servlet.http.HttpSession;

public class YcHttpServletRequest implements HttpServletRequest{
	private String method;
	private String protocal;
	private String serverName;
	private int serverPort;
	private String requestURI;
	private String queryString;
	private String requestURL;
	private String contextPath;
	private String realPath = System.getProperty("user.dir")+"\\webapps";
	private InputStream is ;
	private String sessionId;
	private Map<String ,String> headers =  new HashMap<String, String>();
	public YcHttpServletRequest(InputStream is){
		this.is = is;
		parse();
	}
	@Override
	public HttpSession getSession() {
		HttpSession session = null;
		//从headers 中取出 cookie头 
		//从cookie头中取 sessionId Cookie：sessionId =xxx
		String cookieValue = headers.get("Cookie");
		if(cookieValue != null && cookieValue.length() > 0){
			String[] cookies = cookieValue.split("; ");
			for(String s: cookies ){
				String[] cookie = s.split("=");
				if( cookie[0].equals(Constants.SESSIONID) ){
					this.sessionId = cookie[1];
					break;
				}
			}
		}
		session = YcHttpSessionContext.getInstance().getSession( sessionId ) ;
		if(session == null ){// 第一次请求 session 未创建
			session = new YcHttpSession();
			this.sessionId = session.getId();
			YcHttpSessionContext.getInstance().setSession( sessionId, session);
		}
		return session;
	}
	
	public String getSessionId() {
		return this.sessionId;
	}

	@Override
	public String getHead(String name) {//获取 请求头 信息headers中以键值对的方式存储请求头中的信息 
		String value =null;
		if( headers.containsKey(name)){
			value = headers.get(name);
			return value;
		}else{
			return null;
		}
	}
	public void parse(){//解析请求信息
			String requestInfoString;
			try {
				requestInfoString = readFromInputStrean();
				if(requestInfoString!=null && !"".equals(requestInfoString)){
					parseRequestInfoString(requestInfoString);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	private void parseRequestInfoString(String requestInfoString){
		StringTokenizer st = new StringTokenizer(requestInfoString);
		if(st.hasMoreTokens()){
			this.method = st.nextToken();
			this.requestURI = st.nextToken();
			this.protocal = st.nextToken();
			this.contextPath ="/" + this.requestURI.split("/")[1] ;
		}
		parseParameter(requestInfoString);
		parseHeader(requestInfoString);
		//TODO：获取所有响应头信息
	}
	private void parseHeader(String requestInfoString){
		String head = requestInfoString.substring(0,requestInfoString.indexOf("\r\n\r\n"));
		String[] hs = head.split("\r\n");
		if(hs!= null && hs.length >0 ){
			for(int i =1;i<hs.length ;i++){//去掉请求头 GET XXXX HTTP 
				String[] params = hs[i].split(": ");
				headers.put(params[0], params[1]);
			}
		}
		getSession();
	}
	private void parseParameter(String requestInfoString) {
		//解决地址栏后面的参数解析
		if( requestURI.indexOf("?") >= 0){
			this.queryString = requestURI.substring( requestURI.indexOf("?") +1);
			this.requestURI = requestURI.substring( 0 ,requestURI.indexOf("?") );
			String[] reqparams = this.queryString.split("&");
			if(reqparams != null && reqparams.length > 0){
				for (String p : reqparams) {
					String[] paires = p.split("=");
					if(paires != null && paires.length > 0){
						this.paramters.put(paires[0], paires[1] );
					}
				}
			}
		}
		if( this.method.equals("POST")){
			//post实体中的参数 
			String preqparams = requestInfoString.substring(requestInfoString.indexOf("\r\n\r\n"));
			String[] reqparams = preqparams.split("&");
			if(preqparams != null && preqparams.length() > 0){
				for (String p : reqparams) {
					String[] paires = p.split("=");
					if(paires != null && paires.length > 0){
						this.paramters.put(paires[0], paires[1] );
					}
				}
			}
		}
	}
	private String readFromInputStrean() throws IOException{
		//读取流信息 一次读取所有头信息 否则 读取 到 \r\n 换行符 会一直等待 （以为已读取完）
		String protocal = null;
		StringBuffer sb = new StringBuffer(1024*10);
		byte[] bs= new byte[1024*10];
		int length=-1;
		try {
			length = this.is.read(bs);
		} catch (Exception e) {
			e.printStackTrace();
			length =-1;
		}
		for(int j=0;j<length;j++){
			sb.append((char) bs[j]);
		}
		protocal = sb.toString();
		return protocal;
	}
	public String getMethod() {
		return method;
	}
	public String getProtocal() {
		return protocal;
	}
	public String getServerName() {
		return serverName;
	}
	public int getServerPort() {
		return serverPort;
	}
	public String getRequestURI() {
		return requestURI;
	}
	public String getRequestURL() {
		return requestURL;
	}
	public String getContextPath() {
		return contextPath;
	}
	public String getRealPath() {
		return realPath;
	}
	Map<String,Object> attribute = new HashMap<String, Object>(); 
	@Override
	public Object getAttribute(String key) {
		return attribute.get(key);
	}
	@Override
	public void setAttribute(String key, Object value){
		attribute.put(key, value);
	}
	private Map<String,String> paramters = new HashMap<String, String>();
	@Override
	public String getParameter(String key) {
		return paramters.get(key);
	}
	@Override
	public Map<String, String> getParameterMap() {
		return this.paramters;
	}
	//在servlet中获取 application 的方法
	@Override
	public ServletContext getServletContext() {
		return YcServletContext.getInstance();
	}
	
	
}