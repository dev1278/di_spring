package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormVaildation extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req ,HttpServletResponse res)throws ServletException,IOException{
		String name=null,email=null,fb=null,gender=null,dob=null,mts=null,cont=null,addr=null,mob=null,color=null;
		int cage=0,sal=0;
		String[] crs=null;
		String[] hob=null;

		
		
		
		//printWriter
		PrintWriter pw=null;
		 pw=res.getWriter();
		   res.setContentType("text/html");
		   
		//Read from data
		   name=req.getParameter("pname");
		   email=req.getParameter("email");
		   fb=req.getParameter("face");
		   dob=req.getParameter("date");
		   mts = req.getParameter("ms");
		   cont=req.getParameter("phone");
		    addr=req.getParameter("addr");
		    mob=req.getParameter("mob");
		   color=req.getParameter("col");
		   cage=Integer.parseInt(req.getParameter("page"));
		   crs=req.getParameterValues("crs");   
		   hob=req.getParameterValues("hb");
		   gender=req.getParameter("gen");
	 //b.logic
		   if(gender.equalsIgnoreCase("M")){
			   if(cage<=5)
			   pw.println("<h1 style='color:green;text-align:center'>"+name+"::you are baby boy</h1>");
		   else if(cage<=15) 
				   pw.println("<h1 style='color:green;text-align:center'>"+name+":: you are young boy</h>");
		   else if(cage<=35)
			    pw.println("<h1 style='color:green;text-align:center'>"+name+":: you are Merried man</h>");
		   else
			   
			   pw.println("<h1 style='color:green;text-align:center'>"+name+":: you are Buddha</h>");
				   
		      }
		   else if(gender.equalsIgnoreCase("F")) {
			   
			   if(cage<=5)
				   pw.println("<h1 style='color:green;text-align:center'>"+name+"::you are baby girl</h1>");
			   else if(cage<=15) 
					   pw.println("<h1 style='color:green;text-align:center'>"+name+":: you are young girl</h>");
			   else if(cage<=35)
				    pw.println("<h1 style='color:green;text-align:center'>"+name+":: you are Merried Woman</h>");
			   else
				   
				   pw.println("<h1 style='color:green;text-align:center'>"+name+":: you are Buddhi</h>");
		   }
		   
		   pw.println("<br>email="+email);
		   pw.println("<br>facebook="+fb);
		   pw.println("<br>DateOfBrith="+dob);
		   pw.println("<br>MeritalStatus="+mts);
		   pw.println("<br>Contact="+cont);
		  
		   pw.println("<br>Address="+addr);
		   pw.println("<br>MobileNo="+mob);
		   pw.println("<br>Color="+color);
		   pw.println("<br>Courses="+Arrays.toString(crs));
		   pw.println("<br>Hobbey="+Arrays.toString(hob));
	      }  
		     
	   @Override
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
			doPost(req,res);
		}      
		    
     }	      
		     
		  
	   
	
	 
	
		   
   	   
		    
		    
		    
		 
		
	


