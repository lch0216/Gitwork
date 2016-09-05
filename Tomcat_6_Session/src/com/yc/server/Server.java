package com.yc.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.yc.javax.servlet.ServletResponse;
import com.yc.javax.servlet.http.HttpSession;
import com.yc.javax.servlet.http.HttpSessionContext;

import threadPool.ThreadPoolManager;
/**
 * 加入多线程 提高访问页面的 效率
 * @author Rainbow
 */
public class Server {
	private ThreadPoolManager tpm = null;
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.startServer();
	}

	private void startServer() {
		ServerSocket ss = null;
		int port = parseServerXml();
		tpm = new ThreadPoolManager(10, null);
		try {
			ss = new ServerSocket(port);
			Constants.logger.debug("tomcat is starting ,listening " + ss.getLocalPort() + "端口");
		} catch (IOException e) {
			e.printStackTrace();
			Constants.logger.debug("端口" + ss.getLocalPort() + "被占用");
			return;// 端口被占用
		}
		// System.out.println("服务器启动：监听"+ss.getLocalPort()+"端口");
		while (true){
			try {
				Socket s = ss.accept();
				Timer timer = new Timer ();
				timer.scheduleAtFixedRate(new TimerTask() {
					
					@Override
					public void run() {
						HttpSessionContext context = YcHttpSessionContext.getInstance();
						
					}
				}, 10, 5000);
				Constants.logger.debug(s.getLocalAddress() + "is starting ....");
				ClientTask ct = new ClientTask(s);
				tpm.Process(ct);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private int parseServerXml() {
		List<Integer> portlist = new ArrayList<Integer>();
		//step1 创建解析器工厂
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document document ;
		try {
			// step 2:获得具体的dom解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// step3: 解析一个xml文档，获得Document对象（根结点）
			document = db.parse(Constants.SERVERCONFIG);
			NodeList list = document.getElementsByTagName("Connector");
			for (int i = 0; i < list.getLength(); i++) {
				Element element = (Element) list.item(i);
				portlist.add(Integer.parseInt(element.getAttribute("port")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return portlist.get(0);
	}
}