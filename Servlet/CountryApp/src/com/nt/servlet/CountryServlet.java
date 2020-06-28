package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;     //using java Script using onchange direct change 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CountryServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, 
	IOException {
		String statesIndia[]= {"up","mp","hk","uk"};
		String statesUsa[]= {"British Columbia","Idaho","Olympia"};
		String country=null;
		//get printwriter
		  PrintWriter pw=null;
		   pw=res.getWriter();
		     res.setContentType("text/html");
		     
		 //read from data
		     
		      country=req.getParameter("country");
		     if(country.equals("india")) {
		    	 pw.println("<h1 style='color:green;text-align:left'>Indianstates="+statesIndia[0]+" "+statesIndia[1]+" "
		                 +statesIndia[2]+" "+statesIndia[3]);
		     }
		     else if(country.equalsIgnoreCase("usa")) {
		    	 pw.println("states="+statesUsa[0]+statesUsa[1]+statesUsa[2]+statesUsa[3]);
		    	 
		     }
		     else
		    	 pw.println("not found");
		     
		     pw.println("<a href='country.html'>home</a>");  
	          pw.close();
	    
	}
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,
	IOException{
		
		doGet(req,res);
		
	}
	
	
	

}
