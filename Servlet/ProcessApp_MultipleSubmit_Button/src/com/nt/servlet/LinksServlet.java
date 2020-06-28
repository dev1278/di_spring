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
		float val1=0.0f,val2=0.0f;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		 
	//read form data 
		comp=req.getParameter("s1");
		
		if(comp.equalsIgnoreCase("add")) {
			val1=Float.parseFloat(req.getParameter("t1"));
			val2=Float.parseFloat(req.getParameter("t2"));
			pw.println("Addition::"+(val1+val2));
		}
		else if(comp.equalsIgnoreCase("sub")) {
			val1=Float.parseFloat(req.getParameter("t1"));
			val2=Float.parseFloat(req.getParameter("t2"));
			pw.println("Substraction::"+(val1-val2));
			
		}
		else if(comp.equalsIgnoreCase("div")) {
			val1=Float.parseFloat(req.getParameter("t1"));
			val2=Float.parseFloat(req.getParameter("t2"));
			pw.println("Division::"+(val1/val2));
		}
		else if(comp.equalsIgnoreCase("mul")) {
			val1=Float.parseFloat(req.getParameter("t1"));
			val2=Float.parseFloat(req.getParameter("t2"));
			pw.println("Multiplication::"+(val1*val2));
		}
		else if(comp.equalsIgnoreCase("link1")) {
			pw.println("Date and TYM::"+new Date());
		}
		else if(comp.equalsIgnoreCase("link2")) {
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
		
	


