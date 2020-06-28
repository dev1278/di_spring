package com.nt.servlet;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet {
	private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE  EMPNO=?";
	
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException {
	PrintWriter pw=null;
	int eno=0;
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	ServletConfig cg=null;
	String driver=null,url=null,pwd=null,user=null;
	
	try {
	//getPrintWriter
		pw=res.getWriter();
	//set response Content Type
		res.setContentType("text/html");
	//Read Form Data
		eno=Integer.parseInt(req.getParameter("eno"));
		driver=cg.getInitParameter("driver");
		url=cg.getInitParameter("url");
		user=cg.getInitParameter("dbuser");
		pwd=cg.getInitParameter("dbpwd");
  // register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
  //create Connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
  //create prepared stmt having pre compile query
	 ps=con.prepareStatement(GET_EMP_DETAILS_BY_NO);
 //set query param value
	 ps.setInt(1,eno);
  //execute query
	 rs=ps.executeQuery();
  //process the resultset object
	 if(rs.next()) {
		 pw.println("<h1> Employee Details are </h1>");
		 pw.println(" <b>empno::"+rs.getInt(1)+"<br>");
		 pw.println(" <b>emp name::"+rs.getString(2)+"<br>");
		 pw.println(" <b>emp job::"+rs.getString(3)+"<br>");
		 pw.println(" <b>emp SAl::"+rs.getString(4)+"<br>");
		 pw.println(" <b>emp DEPTNO::"+rs.getString(5)+"<br>");
	 }
	 else {
		 pw.println("<h1 style ='color:red'>Employee Not Found</h1>");
	 }
	 
	 pw.println("<br> <br> logical name of servlet::"+cg.getServletName());
	 pw.println("<br> ServletConfig obj class Name::"+cg.getClass());
	
		
	}//try
	catch(SQLException se) {
		pw.println("<h1 style ='color:red'>Internal DB Problem</h1>");
		se.printStackTrace();
	}
	catch(ClassNotFoundException cnf) {
		pw.println("<h1 style ='color:red'>DB Problem</h1>");
		cnf.printStackTrace();
	}
	
}	

}
