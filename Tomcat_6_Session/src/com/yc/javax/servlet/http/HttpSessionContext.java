package com.yc.javax.servlet.http;
// session 容器  此类要保证只实例化一次 --》在每次 服务器运行过程中 保证其中的session 不会改变
public interface HttpSessionContext{
	public HttpSession getSession(String sessionId);
	public void setSession(String sessionId,HttpSession session);
}
