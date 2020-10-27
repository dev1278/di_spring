package com.jdbc.my;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BankTrasferMony {
	public static void main(String[] args) {
		Scanner sc = null;

		int scrAccnt = 0, DestiAccnt = 0;
		float Amunt = 0.0f;
		Connection con = null;
		Statement st = null;
		int result[] = null;
		boolean flag = false;

		try {

			sc = new Scanner(System.in);
			if (sc != null) {
				
				System.out.println("Enter Consumer account No::");
				scrAccnt = sc.nextInt();

				System.out.println("EnterDestiNo:: ");
				DestiAccnt = sc.nextInt();

				System.out.println("Enter Amunt::");
				Amunt = sc.nextFloat();
			}
//Register jdbc
			Class.forName("oracle.jdbc.driver.OracleDriver");
//established the Connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");

			// Begin Transaction
			if (con != null) {
				con.setAutoCommit(false);

//createStatement Object	  
				st = con.createStatement();
			}
			if (st != null) {
//add Query to batch
// withdraw amount from Source Accunt
				st.addBatch("update BANK_ACCOUNT set balance=balance-" + Amunt + "WHERE ACCUNTNO=" + scrAccnt);
//diposit amount into dest account
				st.addBatch("update BANK_ACCOUNT set balance=balance+" + Amunt + "WHERE ACCUNTNO=" + DestiAccnt);
//execute batch
				result = st.executeBatch();

//perform TxMgmt
				if (result != null) {
					for (int i = 0; i < result.length; ++i) {
						if (result[i] == 0) {
							flag = true;
							break;
						} // if
					} // for
				} // if
			}

		} // try
		catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (flag == true) {
					con.rollback();
					System.out.println("Tx rollback- mony not transfer");
				} else {
					con.commit();
					System.out.println("Tx Commit_ mony Transfer");
				} // else

			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (sc != null)
					sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
