package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
   
	private static final String INSERT_COOKIE_PERSON_QUERY="INSERT INTO COOKIE_PERSON_INFO VALUE(COOKIE_PID.NEXTVAL,?,?,?,?,?)"
;	@Resource(name="DsJndi")  
	private DataSource ds=null;
  
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  PrintWriter pw=null;
	  float income=0.0f,tax=0.0f;
	  Cookie cookie[]=null;
	  String pname=null,fname=null,gender=null;
	  Connection con=null;
	 PreparedStatement ps=null;
	  int count=0;
	  
	 //getPrintWriter
	  pw=res.getWriter();
	 //setContentType
	  res.setContentType("text/html");
	//read form2/req2 data
	  income=Float.parseFloat(req.getParameter("income"));
	  tax=Float.parseFloat(req.getParameter("tax"));
	  
	//read form1/req1 data as cookies value
	  cookie=req.getCookies();
	   if(cookie!=null) {
		   pname=cookie[0].getValue();
		   fname=cookie[1].getValue();
		   gender=cookie[2].getValue();
		   
	   }
	//write form1/req1 data to Db table as record
	   try {
		  //get pooled jdbc connection
		  con=ds.getConnection();
		// create preparedStatement
		  ps=con.prepareStatement(INSERT_COOKIE_PERSON_QUERY);
	//set value to query param
		  ps.setString(1,pname);
		  ps.setString(2,fname);
		  ps.setString(3,gender);
		  ps.setFloat(4,income);
		  ps.setFloat(5,tax);
	//process the result set	  
		  count=ps.executeUpdate();
		  
		  if(count==0) {
			  pw.println("<h1 style='color:red;align:center;'>Registration Failed</h1>");
		  }
		  else {
			  pw.println("<h1 style='color:green;align:center;'>Registraion Success</h1>");
		  }
			  
	   }
	   catch(SQLException se) {
		   se.printStackTrace();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   finally {
		try {
			if(ps!=null) {
				ps.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		try {
			if(con!=null) {
				con.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}//finally
	  //display form1/req1 data and form2/req2 data dynamically
	   pw.println("<br>form1/req1 data::"+pname+"...."+fname+"...."+gender+"....");
	   pw.println("<h3>form2/req2 data::"+income+"..."+tax+"</h3>");
	  
	   
	   
	   pw.println("<br><a href='input.html'>home</a>");
	  
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
