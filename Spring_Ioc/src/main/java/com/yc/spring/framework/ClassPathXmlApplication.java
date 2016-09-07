package com.yc.spring.framework;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ClassPathXmlApplication {
	private Map<String,Object> beans = new HashMap<String,Object>();
	
	
	public ClassPathXmlApplication(String xml) throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException{
		//读取xml文件（dom，sax ，jdom ，dom4j），创建bean的对象object到beans
		SAXBuilder sb = new SAXBuilder();
		Document doc = sb.build( this.getClass().getClassLoader().getResourceAsStream(xml));
		Element root = doc.getRootElement();
		List beanSon = root.getChildren();
		for (int i=0;i<beanSon.size();i++) {
			//根据配置文件取出 id 以及class
			Element bean = (Element)beanSon.get(i);
			String id  = bean.getAttributeValue("id");
			String className = bean.getAttributeValue("class");
			//使用反射根据class创建实例对象
			Object obj = Class.forName(className).newInstance();
			String init_method = bean.getAttributeValue("init-method");
			if(init_method != null && "".equals(init_method.trim())){
				Method initMethod = getMethodByName(init_method,className);
				initMethod.invoke(obj, null);
			}
			beans.put(id, obj);
			setPropertyValue(bean,className,obj);//通过bean节点取出property子节点
		}
	}

	private void setPropertyValue(Element bean, String className, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		List propertySon = bean.getChildren();
		if(propertySon != null && propertySon.size() >0){
			for (int i = 0; i < propertySon.size(); i++ ) {
				Element el = (Element) propertySon.get(i);
				String propertyName = el.getAttributeValue("name");
				String methodName = getMethodName( propertyName );
				
				Method m = getMethodByName(methodName, className);
				String propertyValue= el.getAttributeValue("value");
				String propertyRef= el.getAttributeValue("ref");
				if(propertyValue != null){
					Class[] parameterTyPes = m.getParameterTypes();
					if("int".equals(parameterTyPes[0].getName() ) || "java.lang.Integer".equals(parameterTyPes[0].getName())){
						m.invoke(obj, propertyValue);
					}
				}
			}
		}
	}
	private String getMethodName(String propertyName) {
		
		return "set"+ propertyName.substring(0,1).toUpperCase() + propertyName.substring(1);
	}

	private Method getMethodByName(String methodName, String className) throws ClassNotFoundException {
		Class c = Class.forName(className);
		Method[] ms = c.getMethods();
		if(ms !=null && ms.length >0){
			for (Method method : ms) {
				if(method.getName().equals(methodName)){
					return method;
				}
			}
		}
		
		return null;
	}
}
