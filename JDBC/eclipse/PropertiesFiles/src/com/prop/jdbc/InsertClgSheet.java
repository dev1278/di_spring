package com.prop.jdbc;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class InsertClgSheet {
		public static void main(String[] args) {
		 Scanner sc=null;
		 int no=0;	
		 String name=null,addr=null,query=null;
		 Connection con=null;
		 Statement st=null;
		 int result=0;
		 
			try {
				sc=new Scanner(System.in);
				if(sc!=null) {
					System.out.println("Enter emp  no::");
					no=sc.nextInt();//101
					
					System.out.println("Enter name::");
					name=sc.next();//deva
					
					System.out.println("Enter Addr::");
					addr=sc.next();// 
					
				}
				
				//convert input values as requerd for SQl Query
				
				name="'"+name+"'";
				addr="'"+addr+"'";
				
				//register jdbc driver
				Class.forName("com.hxtt.sql.excel.ExcelDriver");
				
				//stablish Connection
				
				con=DriverManager.getConnection("jdbc:Excel:///F:\\ExcelProperties");
				
				//create statement
				if(con!=null)
					st=con.createStatement();
				
				//prepare SQl QUery
				//query= insert into student values(401,'raja','mumbey);
				
				
				
				query="INSERT INTO COLLAGE VALUES("+no+","+name+","+addr+")";
				
				System.out.println(query);
				 
				
				//send and execute SQl query in database 
				
				if(st!=null)
					result=st.executeUpdate("insert into collage.sheet1 values(?,?,?)");
				
				if(result==0)
					System.out.println("Record not insert");
				
				else
					System.out.println("Record inserted");
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
				 try {
					 if(sc!=null)
						 sc.close();
				 }
				 catch(Exception e) {
					 e.printStackTrace();
				
				 }//finally
				 
		     }//main
		  }//class
	       
			


}
