package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		System.out.println("ErrServlet.doGet(-,-)");
		PrintWriter pw=null;
		//get PrintWriter
		pw=res.getWriter();
	//set response Content type
		res.setContentType("text/html");
    //display Message
		pw.println("<h1 style='color:red;text-align:center>Internal Problem--Try again</h1>");
		pw.println("<br> <a href='input.html'>home</a>");
		
  //close Stream
		pw.close();
		
	}//doGet(-,-)
	
	
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doGet(req,res);
	}//doPost(-,-)
}
