

import java.io.PrintWriter;

import com.yc.javax.servlet.JspWriter;
import com.yc.javax.servlet.ServletContext;
import com.yc.javax.servlet.http.Cookie;
import com.yc.javax.servlet.http.HttpServlet;
import com.yc.javax.servlet.http.HttpServletRequest;
import com.yc.javax.servlet.http.HttpServletResponse;
import com.yc.javax.servlet.http.HttpSession;

public class HelloServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request ,HttpServletResponse response){
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request ,HttpServletResponse response){
		Cookie c = new Cookie("name", "LL");
		Cookie c1 = new Cookie("pwd", "a");
		response.addCookie(c);
		response.addCookie(c1);
		int count =0;
		HttpSession session = request.getSession();
		if(session.getAttribute("count") != null ){
			count = Integer.parseInt( session.getAttribute("count").toString() );
		}
		count++;
		session.setAttribute("count", count);
		// 对客户端的响应
		String html = "<html><head></head><body><hr/> visited Count:"+count+"</body></html>";
		JspWriter jw = response.getJSpWriter();
		jw.println( html);
	}
}
