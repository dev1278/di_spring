package com.nt.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class MarriageServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, 
	IOException {
           
		
		System.out.println("MarriageServlet.doPost()"); 
		PrintWriter pw=null;
          String name =null;
          int cage =0;
          String tage =null;
          String gender=null;
          
          List<String> list =null;
          
             pw=res.getWriter();
             res.setContentType("text/html");
        
            //read request from parameter
            name=req.getParameter("pname");
            
            //tage=req.getParameter("page");
            tage=req.getParameter("page");
            gender=req.getParameter("gen");
            
            
           list =  new ArrayList<String>();
                   
      //  Form validation server side
           
           if(name==null || name.length()==0 || name.equals("")) {
            // pw.println("Please Enter Name::");
            	list.add("<h1> please Enter Name</h1>");
            }
            
            if(tage==null || tage.length()==0 || tage.equals("")) {
            	//pw.println("<h1 style='color:red;text-align:center'>Please enter age</h1>");
            	//pw.println(errorMsg);
            	  list.add("<h1>Please Enter Age</h1>");
            	
            }	
            	
         
            	try { 
            		cage=Integer.parseInt(tage);
            		if(cage<1 || 125<cage) {
            			//pw.println("<h1 style='color:red;text-align:center'>Please enter age between 1year to 125 year</h1>");
            			list.add("<h1>Please Enter Age between 1year to 125 year</h1>"); 
            		}
            	}
            	
            catch(NumberFormatException nfe) {
            	//pw.println("<h1 style='color:red;text-align:center'>Please enter integer value form</h1>");
                if(tage!="")
            	list.add("<h1>Please Enter Integer Value</h1>");
                
             } 
            	if(list.size()!=0) {
            		for(String errMsg:list) {
            			pw.println(errMsg);
            		}
            		return ;
            	}
            
            
            
       //b.logic
            if(cage>21 && gender.matches("male")) {
            	pw.println("<h1 style='color:green;text-align:center'>"+name+"::you are  Teen boy Eligible for Marriage</h1>");
            }
            else if(cage>18 && gender.matches("female")) {
            	pw.println("<h1 style ='color:green;text-align:center'>"+name+" ::you are Eligible for Marriage</h1>");
            }
            else {
            	pw.println("<h1 style='color: red;text-align:center'>"+name+ "::you are not Eligible for Marriage</h1>");
            }
            
            pw.println("<a href='input.html'>home<img src ='home.jpg'> ");
            pw.println("<a href='AboutUs.html'>aboutUs</a>");
            
            pw.close();
	   } 

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, 
	IOException {
		
		doPost(req,res);
		
		
		
	} 
  }

      
	


