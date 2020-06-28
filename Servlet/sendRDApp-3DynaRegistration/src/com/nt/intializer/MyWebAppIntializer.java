package com.nt.intializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.nt.servlet.SearchServlet;

public class MyWebAppIntializer implements ServletContainerInitializer {

	public MyWebAppIntializer() {
		System.out.println("MyWebAppIntializer::0-param Constructer");
	}
	
	@Override
	public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
	  System.out.println("MyWebAppIntializer.onStartup()");
	  SearchServlet servlet=null;
	  ServletRegistration.Dynamic dyna=null;
	  //create Servlet class  Object
	  servlet= new SearchServlet();
	  //register servlet
	  dyna=sc.addServlet("search",servlet);
	  //provide Url pattern
	  dyna.addMapping("/searchurl");
	  //enabling Load-on-startup
	  dyna.setLoadOnStartup(1);

	}

}
