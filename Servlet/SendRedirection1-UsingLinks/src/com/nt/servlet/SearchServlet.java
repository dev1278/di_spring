package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String ss=null;
	//get PrintWriter
		pw=res.getWriter();
	//set ContentType
		res.setContentType("text/html");
   //read form data from html page
		ss=req.getParameter("ss");
  //using hyperlInks  for SendRedirection
		pw.println("<a href='https://www.google.com/search?q="+ss+"'>go to google</a>");
		
	
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req,res);
	}

}
