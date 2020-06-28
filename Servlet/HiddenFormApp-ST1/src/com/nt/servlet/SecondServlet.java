  package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private static final String PERSON_INFO_QUERY="INSERT INTO PERSON_INFO VALUES(PID_SEQ.NEXTVAL,?,?,?,?,?)";
	@Resource(name="DsJndi")
	private DataSource ds;
       
    
  
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pname=null;
		String fname=null;
		String ms=null;
		 String f2val1=null;
		 String f2val2=null;
		 Connection con=null;
		 PreparedStatement ps=null;
		 int result=0;
	//get PrintWriter
		pw=res.getWriter();
	//setContenType
		res.setContentType("text/html");
	//read form1/req1 date and from the hidden boxes of form2
		pname=req.getParameter("hpname");
		fname=req.getParameter("hfname");
		ms=req.getParameter("hms");
		
	//read form2/req2 date
		f2val1=req.getParameter("f1t1");
		f2val2=req.getParameter("f2t2");
		
	//write both form1/req1 data and form2/req2 data to db table as record
		try {
	//get pooled  jdbc connection object
			con=ds.getConnection();
	//create PreparedStament object
			ps=con.prepareStatement(PERSON_INFO_QUERY);
	//set query param values
			ps.setString(1,pname);
			ps.setString(2,fname);
			ps.setString(3,ms);
			ps.setString(4,f2val1);
			ps.setString(6,f2val2);
			
	//execute the query
		result=ps.executeUpdate();
	//process the result
		if(result==0)
			pw.println("<br> <b>Person Registration failed</b>");
		else
			pw.println("<br><b>Person Registration Succeded</b>");
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		//close jdbc object
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}	
	//display dynamic web page having form1/req1 and form2/req2 data
		pw.println("<h1 style='color:red;text-align:center'>Result Page</h1>");
		pw.println("<br>form1/req1 data::"+pname+"...."+fname+"...."+ms+"....");
		pw.println("<br>Form2/req2 data::"+f2val1+"....."+f2val2);
	// add hyperlink	
		pw.println("<br><br><a href='input.html'>home</a>");
	//close Stream
		pw.close();
   		
		
		
		
		
		
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
