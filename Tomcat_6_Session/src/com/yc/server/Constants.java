package com.yc.server;

import org.apache.log4j.Logger;
public class Constants {
	public static final String SERVERCONFIG="conf/server.xml";
	public static final String SESSIONID="LSESSIONID";
	public static final String TOMCAT_BASEPATH=System.getProperty("user.dir");
	public static final Logger logger = Logger.getLogger(Constants.class);
}
