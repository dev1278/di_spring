package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String link=null;
		Locale locale[]=null;
		
		//get PrintWrinte
		pw=res.getWriter();
	
	    //set  response content type	
	     res.setContentType("text/html");
   
	     // read form data
		 link=req.getParameter("l1");
		  
		 if(link.equalsIgnoreCase("link1")) {
			  locale=Locale.getAvailableLocales(); 
			  for(Locale l:locale) {
				  pw.println(l.getDisplayLanguage()+"<br>");
			         }
		         }
			  
		  else if(link.equalsIgnoreCase("link2")) {
				  locale=Locale.getAvailableLocales();
				  for(Locale l:locale) {
					  pw.println(l.getDisplayCountry()+"<br>");
				  }
			  }
			 
		  
		  else {
				  pw.println("Date and Time"+new java.util.Date()+"</br>");
			  }
		  
		  
		  //add hyperlink
		    pw.println("<h2 style='color:red;text-align:center'><a href='Multiplelinks.html'>home</a></h2>");
		  
			//close Stream  
		    pw.close();
	      }  
		  
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	    doGet(req,res);
	}
	
}
