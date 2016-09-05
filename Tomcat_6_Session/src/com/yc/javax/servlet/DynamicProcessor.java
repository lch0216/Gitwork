package com.yc.javax.servlet;

import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import com.yc.javax.servlet.http.HttpServlet;
import com.yc.javax.servlet.http.HttpServletRequest;
import com.yc.javax.servlet.http.HttpServletResponse;
import com.yc.server.Constants;
import com.yc.server.Processor;

public class DynamicProcessor implements Processor{
	//private static Map<String ,Servlet> servlets = new HashMap<String, Servlet>();
	@Override
	public void process(ServletRequest request, ServletResponse response) {
		//1、取出请求uri 获取请求地址中的servlet名称保证sevlet的单实例
		try {
			
			String uri = ((HttpServletRequest)request).getRequestURI();
			String servletName = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));
			Servlet servlet = null;
			ServletContext application= YcServletContext.getInstance();
			if( application.getServlet(servletName) != null){
				servlet = application.getServlet(servletName);
			}else{
				//2、动态字节码加载 扫描项目下的 servlet 对应的字节码
				URL[] urls = new URL[1];//请求的servlet只有一个 
				urls[0] = new URL("file", null, Constants.TOMCAT_BASEPATH);
				URLClassLoader ucl = new URLClassLoader(urls);
				//3、 URL地址 （系统中对应的位置 文件协议：file：\\\\盘符:\\）
				//4、Class 得到 servlet对应的类文件（.java） urlloader.loadClass 
				Class c =  ucl.loadClass(servletName);
				servlet = (Servlet) c.newInstance();
				application.setServlet(servletName, servlet);
				if(servlet != null && servlet  instanceof Servlet){
					servlet.init();
				}
			}
			//5、 以反射的形式创建 servlet 实例 
			//6、 再以生命周期的形式调用servlet 中的方法
			 if(servlet != null && servlet  instanceof Servlet){
				 //父类引用只能调用子类重写了父类的方法而不能调用子类特有的方法
				((HttpServlet) servlet).service(((HttpServletRequest)request), ((HttpServletResponse)response) );
			 }
		} catch (Exception e) {//服务器内部错误
			String bodyContent = e.toString();//打印错误的堆栈信息
			long bodyLength = bodyContent.getBytes().length;
			String protocal = gen500(bodyLength);
			PrintWriter pw = response.getWriter();
			pw.println(protocal );
			pw.println( bodyContent );
			pw.flush();
		} 
	}
	private String gen500(long bodyLength){
		String protocal500 = "HTTP/1.1 500 Internal Server Error\r\nContent-Type: text/html;charset=utf-8\r\nContent-Length: "
			+ bodyLength + "\r\n\r\n";
		return protocal500;
	}
	
}
