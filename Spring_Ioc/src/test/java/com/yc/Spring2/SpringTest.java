package com.yc.Spring2;



import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.bean.Address;

public class SpringTest extends TestCase {
	 
    @Test  
    public void test() {
    	//加载配置文件的同时 会自动创建 bean对象实例 （且为单例模式 可以配置  scope="prototype" 实现多实例并且加载配置文件时不会创建对象 ）
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
    	Address obj = (Address) context.getBean("address");
    	System.out.println(obj);
    }
    
   
    
}
