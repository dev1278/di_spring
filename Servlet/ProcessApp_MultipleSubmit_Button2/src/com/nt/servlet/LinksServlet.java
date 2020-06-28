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
  
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,
IOException {

	PrintWriter pw=null;
  //set content type
	pw=res.getWriter();
	res.setContentType("textr/html");
	
	    
	
	
	
}
@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws 
	ServletException, IOException {
		
		doGet(req, res);
	}
}
		
	


