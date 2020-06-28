package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class LcTest extends HttpServlet {
	static {
		System.out.println("LcTest.Static block");
	}

	public LcTest() {
		System.out.println("LcTest.0-param constructor");
	}

	/*
	 * @Override public void init(ServletConfig cg) throws ServletException {
	 * System.out.println("LcTest.initialization");
	 * System.out.println("LcTest.init()"); String url=cg.getInitParameter("url");
	 * String dbuser=cg.getInitParameter("dbuser"); String
	 * dbpwd=cg.getInitParameter("dbpwd"); System.out.println(url);
	 * System.out.println(dbuser); System.out.println(dbpwd);
	 * 
	 * try { Connection con=DriverManager.getConnection(url, dbuser, dbpwd); }
	 * catch(SQLException se) { se.printStackTrace(); }
	 * 
	 * }
	 */
		@Override
		public void init() throws ServletException {
			System.out.println("LcTest.init()");
		}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("LcTest.service(-,-)");
		// get PrintWriter
		PrintWriter pw = null;
		pw = res.getWriter();
		// set Content Writer
		res.setContentType("text/html");
		Date d = new Date();
		pw.println("<h1 align='center' style='color:blue'> Date and time:: " + d.toString() + "</h1>");
		pw.println("<table border='1' align='center'>");
		pw.println("<tr><td>politician</td><td>party</td><td>Role</td></tr>");
		pw.println("<tr><td>Akhilesh</td><td>SP</td><td>Cm</td></td></tr>");
		pw.println("</table>");
		pw.close();
	}
}
