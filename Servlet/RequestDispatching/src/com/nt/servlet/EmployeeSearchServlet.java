package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet {
	private static final String  GET_EMP_DETAILS_BY_NO="SElECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM  WHERE EMPNO=?";
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		System.out.println("EmployeeSearchServlet.doGet(-,-)");
		PrintWriter pw=null;
		int eno=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ServletConfig cg=null;
		String driver=null,url=null,user=null,pwd=null;
		RequestDispatcher rd=null;
		try {
		//get printlWriter
			pw=res.getWriter();
	// set Response Object
			res.setContentType("text/html");
	//red Form data
			eno= Integer.parseInt(req.getParameter("eno"));
	//get Access to servletConfig Object
			driver=cg.getInitParameter("driver");
			     url =cg.getInitParameter("url");
			     user=cg.getInitParameter("dbuser");
			       pwd=cg.getInitParameter("dbpwd");
			 pw.println("<b> seraching and giving details</b><br>"); 
	//register jdbc driver
			  Class.forName(driver);
    //create connection 
			  con=DriverManager.getConnection(url,user,pwd);
	 //create prepared stmt having pre compile query
			  ps=con.prepareStatement(GET_EMP_DETAILS_BY_NO);
	 //set query param value
			  ps.setInt(1,eno);
    //execute query
			 rs=ps.executeQuery();
	 //process the resultset object
			
			 if(rs.next()) {
			 pw.println("<h1>Employee Details are </h1>");
			pw.println("<b> empno::"+rs.getInt(1)+"<br>");
			pw.println("<b> emp name::"+rs.getString(2)+"<br>");
			pw.println("<b> emp JoB::"+rs.getString(3)+"<br>");
			pw.println("<b> emp SAl::"+rs.getString(4)+"<br>");
			pw.println("<b>emp DEPTNO::"+rs.getShort(5)+"<br>");
			
			 
			}
		else {
			pw.println("<h1 style='color:red'>Employee Not Found</h1>");
		}
		
	 }//try
		catch(Exception e) {
		 e.printStackTrace();	
		}
		 
	finally {
	//close jdbc object
		try {
			if(rs!=null) {
				rs.close();
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
			}
		try {
			if(pw!=null) {
				pw.close();
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		  }//finally
		}
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		  doGet(req,res);
	}
   
}	
		
		


