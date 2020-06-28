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
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		String searchinganythinks=null;
		 String engin=null;
		 String url=null;
	//getPrintWriter
		pw=res.getWriter();
	//set Content type
		res.setContentType("text/html");
	//read Form data from html page
		searchinganythinks=req.getParameter("searchinganythinks");
		engin=req.getParameter("engin");
		
	//prepare url based on the Search Engin
		if(engin.equalsIgnoreCase("google"))
			url="https://www.google.com/search?q="+searchinganythinks;
		else if(engin.equalsIgnoreCase("bing"))
			url="https://www.bing.com/search?q="+searchinganythinks;
		else if(engin.equalsIgnoreCase("yahoo"))
			url="https://in.search.yahoo.com/search?p="+searchinganythinks;
  //perform sendRedirection
       System.out.println("befor res.sendRedirection(-)method");
       pw.println("<b>befor... </b>");
		res.sendRedirect(url);
		System.out.println("after res.sendRedirection(-)method");
		pw.println("<b> after...</b>");

       
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
