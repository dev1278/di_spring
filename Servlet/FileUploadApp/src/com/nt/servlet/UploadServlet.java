package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;
@WebServlet("uploadurl")
public class UploadServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		MultipartFormDataRequest nreq=null;
		UploadBean bean=null;
		Vector vector=null;
		UploadParameters param=null;
		
		//getPrintWriter
		pw=res.getWriter();
		//setContentType
		 res.setContentType("text/html");
		try {
		 //createMultiFormDataRequst object
		 nreq=new MultipartFormDataRequest(req);
		//perform file uploading
		 bean=new UploadBean();
		  bean.setFolderstore("e:/store");
		 //restriction 
		  bean.setOverwrite(false);
		  bean.setMaxfiles(10);
		  bean.setFilesizelimit(20*1024);
		  bean.setBlacklist("*.exe,*.zip");
		//upoload file  
		  bean.store(nreq);
		  pw.println("<h1 style='color: red'>File are Uploaded succesfully</h1>");
		//display the uploaded file name
		  vector=bean.getHistory();
		  for(int i=1;i<vector.size();++i) {
			  param=(UploadParameters)vector.elementAt(i);
			  pw.println("<b> file::"+param.getFilename()+"size::"+param.getFilesize()+"type::"+param.getContenttype()+"modal::"+param.getStoreinfo()+"</b><br>");
		  }//for		  
		}//try
		catch(Exception e) {
			pw.println("<h1 style='color: red;text-align:center'>Problem in Uploading---->"+e.getMessage()+"</h2>");
			e.printStackTrace();
		}
	//add hyperlink
		pw.println("<a href='upload.html'>home</a>");
		
		 
	
		
		
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}

}
