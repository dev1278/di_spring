package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
	String 	pname=null,fname=null,gender=null;
	Cookie cookie1=null,cookie2=null,cookie3=null;
	//getPrintWriter
	pw=res.getWriter();
	//setContentType
	res.setContentType("text/html");
	//read data from html page
	pname=req.getParameter("pname");
	fname=req.getParameter("fname");
	gender=req.getParameter("gender");
	//create InMemory Cookies having form1/req1 data
	  cookie1=new Cookie("pname","pname");
	  cookie2=new Cookie("fname","fname");
	  cookie3=new Cookie("gender","gender");
	  
	 //add Cookies to response
	  res.addCookie(cookie1);
      res.addCookie(cookie2);
      res.addCookie(cookie3);
      
      
     //generates form2 dynamically here
      pw.println("<h1 style='color:red;text-algin:center'>Provide Income Details</h1>");
      
      pw.println("<form action='secondurl' method='post'>");
      pw.println("<table border='0' bgcolor='cyan'align='center'>");
      pw.println("<tr><td>Income of this Year</td><td><input type='text'name='income'></td></tr>");
      pw.println("<tr><td>Tax</td><td><input type='text' name='tax'></td></tr>");
      pw.println("<tr><td><input type='submit' value='submit'></td><td><input type='reset' value='cancel'></td></tr>");
	//close stream
      pw.close();
	  
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
