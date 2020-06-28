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


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		RequestDispatcher rd=null;
		HttpSession ses=null;

	//create request attribute
		req.setAttribute("attr1","val1");
   
	//create/local session object		
	 ses=req.getSession();
	 ses.setAttribute("attr2","val2");
		
	//Forward request SecondServlet
		rd=req.getRequestDispatcher("/secondurl");
		rd.forward(req,res);
	//close Stream
		
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
