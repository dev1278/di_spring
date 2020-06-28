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


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		RequestDispatcher rd=null;
		HttpSession ses=null;
	//get printWriter
		pw=res.getWriter();
	//setContentType
		res.setContentType("text/html");
  //read session value
			ses=req.getSession();
		
  //read and Display request attribute values
		pw.println("<br><b>(SecondServlet)req attribute(attr1)value::"+req.getAttribute("attr1")+"</b>");
	    pw.println("<br><b>(SecondSession)ses attribute(attr2)value::"+ses.getAttribute("attr2")+"</b>");
		
	
	//Forward request SecondServlet
		rd=req.getRequestDispatcher("/thirdurl");
		rd.forward(req,res);
   //closeStream
		pw.close();
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
