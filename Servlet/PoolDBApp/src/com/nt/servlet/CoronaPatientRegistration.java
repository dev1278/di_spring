package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CoronaPatientRegistration extends HttpServlet {
	private static final String INSERT_CORONA_QUERY="INSERT INTO CORONA_REGISTRATION_VALUES(?,?,?,?,?)";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  PrintWriter pw=null;
		  String patName=null;
		  String patAddr=null;
		  int  patAge=0;
		  String gender=null;
		  String stage=null;
		  Connection con=null;
		  PreparedStatement ps=null;
		  int count=0;
		  
		  pw=res.getWriter();
		 //set responce Context
		   res.setContentType("text/html");
		  //read form data
		    patName =req.getParameter("patName");
		    patAddr=req.getParameter("patAddr");
		    patAge=Integer.parseInt((req.getParameter("patAge")));
		    gender=req.getParameter("gender");
		    stage=req.getParameter("stage");
		    try {
		//get Pooled jdbc Connection object
		   con=getPooledConnection();
		//crete jdbc prepareStmt
		   ps=con.prepareStatement(INSERT_CORONA_QUERY);
		//set value to query param
		   ps.setString(1,patName);
           ps.setString(2,patAddr);
           ps.setString(3,gender);
           ps.setInt(4,patAge);
           ps.setString(5,stage);
           
       //execute Query
           count=ps.executeUpdate();
      //prepare the result
           if(count==0)
        	   pw.println("<h1 style=color:green;text-algin:center>Registation Success</h1>");
           else
        	   pw.println("<h1 style=color:red;text-algin:center>Registation failed</h1>");
		    }
		    catch(SQLException se) {
		    	pw.println("<h1 style=color:red;text-algin:center>Registation failed</h1>");
		    	se.printStackTrace();
		    }
		    catch(Exception e) {
		    	pw.println("<h1 style=color:red;text-algin:center>Unknow Exception</h1>");
		    	e.printStackTrace();
		    }
		    finally {
		    	try {
		    		if(ps!=null);
		    		ps.close();
		    	}
		    catch(SQLException se) {
		    	se.printStackTrace();
		    }
		    	try {
		    		if(con!=null);
		    		con.close();
		    	}
		    	catch(SQLException s) {
		    		s.printStackTrace();
		    	}
		    	pw.println("<h1><a href='register.html>home</a></h1>'");
		    }
		    try {
		    	if(pw!=null);
		    	pw.close();
		    }
		    catch(Exception e) {		    	e.printStackTrace();
		    }
	}//finally	   
		 @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res); 
	}
	
	private Connection getPooledConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds =null;
		Connection con=null;
 //create initialContext object
		ic=new InitialContext();
 //get data Source object throws lookup optretion
		ds=(DataSource)ic.lookup("DsJndi");
 //get pooled jdbc Connection
		con=ds.getConnection();
	return con;	
		
	}
		
	

}
