package com.ds.servlet;
import javax.servlet.*;
import java.io.*;
import java.util.*;
public class DateServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException	{
		Date d=null;
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		d=new Date();
		pw.print("<h1 style:align:=center>DATE:::"+d.toString()+"</h1>");
		pw.close();
	}
}
