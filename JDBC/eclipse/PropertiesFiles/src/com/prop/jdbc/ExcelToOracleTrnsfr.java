package com.prop.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExcelToOracleTrnsfr {
	
	private static final String ORACLE_QUERY="INSERT INTO COLLAGE VALUES (?,?,?)";
	public static void main(String[]args) {
		Connection con=null;
		Connection con1=null;
		Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int sno=0,count=0;
		String name=null,addr=null;
		try {
//register jdbc
			Class.forName("oracle.jdbc.driver.OracleDriver");
//register txt file
			Class.forName("com.hxtt.sql.excel.ExcelDriver");
//established the Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
// established the connection for txt file
			con1=DriverManager.getConnection("jdbc:Excel:///F:\\ExcelProperties");
//create statement
			if(con!=null)
			st=con.createStatement();
//create prepare statement object
			if(con1!=null)
			ps=con1.prepareStatement(ORACLE_QUERY);
//create resultSet object
			if(st!=null)
				rs=st.executeQuery("select * from collage.sheet1");
//execute result object
			if(rs!=null) {
				while(rs.next()) {
					sno=rs.getInt(1);
					name=rs.getString(2);
					addr=rs.getString(3);
//set value value to query param
					ps.setInt(1, sno);
					ps.setString(2,name);
					ps.setString(3,addr);
					
					
					
					count=ps.executeUpdate();
				}//while
			}//if
			if(count==0)
			System.out.println("Record not  Inserted");
			else
			System.out.println("Record Inserted");
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
		finally {
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
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
