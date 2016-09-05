package com.yc.server;

import com.yc.javax.servlet.ServletRequest;
import com.yc.javax.servlet.ServletResponse;
/**
 * 资源处理器：处理静态或动态的资源
 * @author Rainbow
 *
 */
public interface Processor {
	/**
	 * 处理资源方法
	 * @param request 请求对象：解析请求头 得到uri method（http） parse paramter 
	 * @param response：响应对象 输出 
	 */
	public void process( ServletRequest request,ServletResponse response);
}
