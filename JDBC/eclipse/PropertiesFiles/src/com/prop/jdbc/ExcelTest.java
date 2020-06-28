package com.prop.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExcelTest {
 public static void main(String[]args) {
	Connection con=null;
	Statement st=null;
	ResultSet rs=null ;
	try{
//register jdbc		
		Class.forName("com.hxtt.sql.excel.ExcelDriver");
//establish the  connection	
	con=DriverManager.getConnection("jdbc:Excel:///F:\\ExcelProperties");
//	create Statement  object
	if(con!=null)
	st=con.createStatement();
//send and Excute Query
	if(st!=null)
	rs=st.executeQuery("select * from collage.sheet1");	
//process the ResultSet
	if(rs!=null) {
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}//while
	  }//if
	}//try
	catch(SQLException se) {
		se.printStackTrace();
	}
	catch(ClassNotFoundException cnf) {
		cnf.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally{
		try {
			if(con!=null)
				con.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}//finally
	
  }//main
}//class
	

