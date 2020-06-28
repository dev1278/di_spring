package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/thirdurl")
public class ThirdServlet extends HttpServlet {
	
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		HttpSession ses=null;
        //get printWriter
		pw=res.getWriter();
       //setContentType
		res.setContentType("text/html");
	 //create session object
	 ses=req.getSession();	
       //read and Display request attribute values
		pw.println("<br><b>(thirdServlet)req attribute(attr1)value::"+req.getAttribute("attr1")+"</b>");
		pw.println("<br><b>(thirdSession)req attribute(attr2)value::"+ses.getAttribute("attr2")+"<b>");
	//close Stream
		pw.close();
	
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
