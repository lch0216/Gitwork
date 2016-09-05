package com.yc.server;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.yc.javax.servlet.ServletContext;
import com.yc.javax.servlet.http.HttpSession;

public class YcHttpSession implements HttpSession{
	private Map<String ,Object> attributes = new HashMap<String ,Object>();

	private String sessionId;
	private long creationTime;
	private long lastAccessTime;//最后访问时间 判断过期时间 
	public YcHttpSession (){
		this.sessionId = UUID.randomUUID().toString();
		Date d = new Date();
		this.creationTime = d.getTime();
		this.lastAccessTime = creationTime;
	}
	@Override
	public String getId() {
		return this.sessionId;
	}
	@Override
	public Object getAttribute(String key) {
		if(this.attributes != null && attributes.containsKey(key)){
			return attributes.get(key);
		}else {
			return null;
		}
		
	}
	@Override
	public void setAttribute(String key, Object value) {
		this.attributes.put(key, value);
	}
	@Override
	public ServletContext getServletContext() {
		return null;
	}
	@Override
	public long getCreationTIme() {
		return this.creationTime;
	}
	@Override
	public long getLastAccessTIme() {
		return this.lastAccessTime;
	}
	@Override
	public String toString() {
		return "YcHttpSession [attributes=" + attributes + ", sessionId="
				+ sessionId + ", creationTime=" + creationTime
				+ ", lastAccessTime=" + lastAccessTime + "]";
	}
	@Override
	public void removeAttribute(String name ) {
		if(attributes.containsKey(name) ){
			attributes.remove(name);
		}
		Date  d= new Date();
		this.lastAccessTime = d.getTime();
	}
	
	
}
