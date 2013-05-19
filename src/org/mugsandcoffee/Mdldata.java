package org.mugsandcoffee;

import java.sql.Array;
import java.sql.Connection;

public class Mdldata {
	
	private String mServer;
	private String mDatabase;
	private String mUser;
	private String mPword;
	private Connection Conn;
	public String[] mResult;
	
	public Mdldata () {
		// loads the default connetion details
		this.mServer = "jdbc:mysql://localhost:3306/";
		this.mDatabase = "matsim";
		this.mUser = "root";
		this.mPword = "";
		
	}
	
	public boolean select() {
		
		return true;
	}
	

}
