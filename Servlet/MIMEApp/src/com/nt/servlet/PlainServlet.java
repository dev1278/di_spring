//PlainServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class PlainServlet extends HttpServlet {
	static {
		System.out.println("PlainServlet.Static block");
	}
	public PlainServlet() {
		System.out.println("PlainServlet.0-param constructor");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("PlainServlet.initialization");
	}
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("PlainServlet.service(-,-)");
		PrintWriter pw=null;
		//get PrintWriter stream 
		pw=res.getWriter();
		

		//set content to display
		res.setContentType("text/plain");

		//output to display
		
		pw.println("<table border='1' align='center'>");
		pw.println("<tr><th>politician</th><th>party</th><th>role</th></tr>");
		pw.println("<tr><td>Narendra Modi</td><td>BJP</td><td>PM</td></tr>");
		pw.println("<tr><td>Amit Shah</td><td>BJP</td><td>party chairman</td></tr>");
		pw.println("<tr><td>Rahul Gandhi</td><td>Congress</td><td>MP</td></tr>");
		pw.println("<tr><td>Arvind Kejriwal</td><td>AAP</td><td>CM</td></tr>");
		pw.println("<tr><td>KCR</td><td>TRS</td><td>CM</td></tr>");
		pw.println("</table>");
		
		//close stream
		pw.close();

		

	}//service(-,-)
}//class
