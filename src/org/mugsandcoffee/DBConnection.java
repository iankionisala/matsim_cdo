package org.mugsandcoffee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pst = null;
		
		String url = "jdbc:mysql://localhost:3306/matsim";
		String user = "root";
		String pword = "";
		
		try  {
			// connects to the mysql server
			conn = DriverManager.getConnection(url, user, pword);
			pst = conn.prepareStatement("INSERT INTO eventlog SET `time`=333.87, `type`='test type'");
			pst.execute();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
