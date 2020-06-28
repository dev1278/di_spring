//XmlServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class XmlServlet extends HttpServlet {
	static {
		System.out.println("XmlServlet.Static block");
	}
	public XmlServlet() {
		System.out.println("XmlServlet.0-param constructor");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("XmlServlet.initialization");
	}
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		System.out.println("XmlServlet.service(-,-)");
		PrintWriter pw=null;
		pw=res.getWriter();

		res.setContentType("text/xml");

		pw.println("<table border='1' align='center'>");
		pw.println("<tr><th>politician</th><th>party</th><th>role</th></tr>");
		pw.println("<tr><td>Narendra Modi</td><td>BJP</td><td>PM</td></tr>");
		pw.println("<tr><td>Amit Shah</td><td>BJP</td><td>party chairman</td></tr>");
		pw.println("<tr><td>Rahul Gandhi</td><td>Congress</td><td>MP</td></tr>");
		pw.println("<tr><td>Arvind Kejriwal</td><td>AAP</td><td>CM</td></tr>");
		pw.println("<tr><td>KCR</td><td>TRS</td><td>CM</td></tr>");
		pw.println("</table>");

		pw.close();

		

	}//service(-,-)
}//class
