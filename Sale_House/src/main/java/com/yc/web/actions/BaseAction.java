package com.yc.web.actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.yc.web.model.JsonModel;

public abstract class BaseAction extends ActionSupport {
	protected JsonModel jsonModel = new JsonModel();
	private static final long serialVersionUID = 7639792203953478199L;
	public String parseJson(JsonModel jsonModel){
		Gson gson = new Gson();
		return gson.toJson(jsonModel);
	}
	// 输出 json字符串的操作
	public void outJson(JsonModel jsonModel,HttpServletResponse response) throws IOException{
		String json = parseJson(jsonModel);
		//跨域
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}
}
