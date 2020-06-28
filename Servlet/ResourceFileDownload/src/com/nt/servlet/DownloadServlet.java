package com.nt.servlet;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;


@WebServlet("/downloadurl")
public class DownloadServlet extends HttpServlet {
	 public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		File file=null;
		String fname=null;
		ServletContext sc=null;
	    String mimeType=null;
	    InputStream is=null;
	    OutputStream os=null;
		
	  //read file name to bo download as addition req param from hyperlink	
	     fname=req.getParameter("fileName");
	     
		//create file object locating and holding the downloadfile
		 file=new File("E:/store/"+fname);
	//get length of the file
		  res.setContentLengthLong(file.length());
	//get ServletContext object
		  sc.getServletContextName();
	//get MIME type of the file and make
		  mimeType=sc.getMimeType("E:/store/"+fname);
		  res.setContentType(mimeType!=null?mimeType:"application/octet-stream");
	//create InputStream pointing to file to be downloaded
		is=new FileInputStream(file) ;
    //create OutputStream pointing to response object
		os=res.getOutputStream();
	//	set Value to content-despotion response header
		res.setHeader("content-Dispostion","attachment;fileName="+fname);
	//copy to the file content to response object
		IOUtils.copy(is,os);
		
     is.close();
     os.close();
		
			
			  
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
