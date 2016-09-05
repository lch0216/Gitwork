

import java.io.PrintWriter;

import com.yc.javax.servlet.ServletContext;
import com.yc.javax.servlet.http.HttpServlet;
import com.yc.javax.servlet.http.HttpServletRequest;
import com.yc.javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	public HelloServlet(){
		System.out.println(" servlet create newinstance ");
	}
	public void init(){
		super.init();
		System.out.println("servlet init");
	}
	public void service(HttpServletRequest request ,HttpServletResponse response){
		System.out.println("servlet service method");
		super.service(request, response);
	}
	protected void doGet(HttpServletRequest request ,HttpServletResponse response){
		System.out.println(" doGet method ");
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request ,HttpServletResponse response){
		System.out.println(" doPost Method ");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("计数器开始计数");
		ServletContext application = request.getServletContext();
		Integer count  = new Integer(0);
		if(application.getAttribute("count") != null ){
			count = (Integer) application.getAttribute("count");
		}
		count++;
		application.setAttribute("count", count);
		System.out.println("计数"+count);
		// 对客户端的响应
		String html = "<html><head></head><body><hr/> 访问次数"+count+"姓名"+name+"年龄"+age+"</body></html>";
		PrintWriter out = response.getWriter();
		String protocal = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\nContent-Length: " + html.getBytes().length + "\r\n\r\n";
		
		out.println( protocal);
		out.println(html);
		out.flush();
	}
}
