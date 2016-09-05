package com.yc.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


import threadPool.Taskable;

import com.yc.javax.servlet.DynamicProcessor;
import com.yc.javax.servlet.StaticProcessor;
import com.yc.server.Constants;

public class ClientTask implements Taskable {
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private boolean flag;

	public ClientTask(Socket socket){
		this.socket = socket;
		try {
			this.is = this.socket.getInputStream();
			this.os = this.socket.getOutputStream();
			this.flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			this.flag = false;
			Constants.logger.debug("获取流信息失败....");
		}
	}
	@Override
	public Object doTask() {
		/**
		 * 执行请求响应的 request 中 包含获取 客户端 地址 请求 的函数 所以 request对象 应该有socket的流信息
		 */
		YcHttpServletRequest request = new YcHttpServletRequest(this.is);
		YcHttpServletResponse response = new YcHttpServletResponse(request,this.os);
		Processor processor = null;
		if(request.getRequestURI().endsWith(".do") || request.getRequestURI().endsWith(".action")){
			processor = new DynamicProcessor();
		}else{
			processor = new StaticProcessor();
		}
		processor.process(request, response);
		flag = false;// http协议 是一个请求一个响应 无状态 每次请求完成 请求响应对象就不存在了
		try {
			this.socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
