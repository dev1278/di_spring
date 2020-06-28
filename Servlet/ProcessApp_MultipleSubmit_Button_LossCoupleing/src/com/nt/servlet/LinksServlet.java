package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,
	IOException{
		//print Writer
		PrintWriter pw=null;
		String comp=null;
		float first=0.0f,second=0.0f;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		 
	//read form data 
		comp=req.getParameter("source");
		
		if(comp.equalsIgnoreCase("add")) {
			first=Float.parseFloat(req.getParameter("t1"));
			second=Float.parseFloat(req.getParameter("t2"));
			pw.println("Addition::"+(first+second));
		}
		else if(comp.equalsIgnoreCase("sub")) {
			first=Float.parseFloat(req.getParameter("t1"));
			second=Float.parseFloat(req.getParameter("t2"));
			pw.println("Substraction::"+(first-second));
			
		}
		else if(comp.equalsIgnoreCase("div")) {
			first=Float.parseFloat(req.getParameter("t1"));
			second=Float.parseFloat(req.getParameter("t2"));
			pw.println("Division::"+(first/second));
		}
		else if(comp.equalsIgnoreCase("mul")) {
			first=Float.parseFloat(req.getParameter("t1"));
			second=Float.parseFloat(req.getParameter("t2"));
			pw.println("Multiplication::"+(first*second));
		}
		
			
		
		else if (comp.equalsIgnoreCase("link")) {
			pw.println("System properties::"+System.getProperties());
		}
	
		//add hyperlinks
		pw.println("<a href='home.html'>home</a>");
	
	}//doGet	
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,
	IOException{
		
		doGet(req,res);
	}
  }		
		
	


