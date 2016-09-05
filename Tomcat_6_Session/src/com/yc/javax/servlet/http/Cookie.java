package com.yc.javax.servlet.http;

public class Cookie {
	private String name ;
	private String value;
	private int maxAge;
	private String domain;
	private String comment;
	private boolean secure;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isSecure() {
		return secure;
	}
	public void setSecure(boolean secure) {
		this.secure = secure;
	}
	public Cookie(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	public Cookie() {
		super();
	}
	@Override
	public String toString() {
		return name+"="+value+" \r";
	}
	
}
