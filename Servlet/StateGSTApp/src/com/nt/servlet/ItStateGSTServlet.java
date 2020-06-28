package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.css.Style;


@WebServlet("/sgsturl")
public class ItStateGSTServlet extends HttpServlet {
	
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  String pname=null,company=null,ptype=null;
	  float cost=0.0f,sgst=0.0f;
	  PrintWriter pw=null;
	  ServletContext sc1=null,sc2=null;
	  RequestDispatcher rd=null;
	  //read form  data
	  pw=res.getWriter();
	  res.setContentType("text/html");
    //read form data
        pname=req.getParameter("pname");
        company=req.getParameter("company");
        ptype=req.getParameter("ptype");
        cost=Float.parseFloat(req.getParameter("cost"));
        pw.println("servlet doGet()");
   //display details
        pw.println("<h1 style='color:red;text-align:center'>GST INfo</h1>");
        pw.println("<br><b>Project name:::"+pname+"</b>");
        pw.println("<br><b>Project company:::"+company+"</b>");
        pw.println("<br><b>Project type:::"+ptype+"</b>");
        pw.println("<br><b>Cost:::"+cost+"</b>");
        
        
        
        //Calculate state CSt
         if(ptype.equalsIgnoreCase("product"))
           sgst=cost*0.12f;
           else if(ptype.equalsIgnoreCase("service")) 
        	    sgst=cost*0.1f;
           else if(ptype.equalsIgnoreCase("startup"))
        	   sgst=cost*0.03f;
         pw.println("<br><b><i>State GST:::"+sgst+"<i></b>");
         
         
     //Communication with Destination Servlet CentralGSTApp  usimg cross context Communication   
      //get ServletContext object of curent web application
         sc1=getServletContext();
         
       //get FoieginContext object of CentralGSTApp
          sc2=sc1.getContext("/CentralGSTApp");
          
          
          
      //get RequstDispatcher object pointing ITCentralGSTServlet ofCentralGSTApp
          
          rd=sc2.getRequestDispatcher("/cgsturl");
         
          
          
          rd.include(req,res);
          
     //add hyperlink
          pw.println("<br><br><a href='input.html'>home</a>");
          
          
     //close stream
          pw.close();
        
   }	
	
	

	 
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req,res);
	}

}
