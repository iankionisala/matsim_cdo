package org.mugsandcoffee.datasource;

import javax.swing.*;
import javax.swing.JScrollPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import org.mugsandcoffee.ParseXML;

/**
 * 
 * Generates basic dynamic datagrid table
 * @author Mugs and Coffee
 * @coder Kenneth "digiArtist_ph" P. Vallejos
 * @since Wednesday, May 22, 2013
 * @version 1.1
 *
 */
public class mncTable {

	private ParseXML Conn;
	private Connection ojbConn;
	
	public mncTable() {
		// opens connecton to database
		this.Conn = new ParseXML();
		this.ojbConn = Conn.connectToDB();
	}
	
	public JTable buildGrid(String Qry, String[] colHeader)throws SQLException {
		
		String strQry = Qry;
		Statement rstQry = this.ojbConn.createStatement();
		ResultSet rstRecord = rstQry.executeQuery(strQry);
		ResultSetMetaData rsMeta = rstRecord.getMetaData();
		
		// defines the column names
		String[] tblHeader = colHeader;
		
		// defines column count
		int colCount = rsMeta.getColumnCount();
		int rowCount = this.getRowCount(rstRecord);
		
		Object allRow[][] = new Object[rowCount][colCount];
		int cntr = 0;
		
		// loops thru the resultset
		while(rstRecord.next()) {
			for(int i = 0; i < colCount; i++) {
				allRow[cntr][i] = rstRecord.getString(i + 1);
			}
			cntr ++;
		}

		// closes the opened database connection
		this.Conn.closeConnection();

		JTable tblGrid = new JTable(allRow, tblHeader);
		
		return tblGrid;
	}
	
	/**
	 * 
	 * Returns the count of records
	 * @param rst ResultSet
	 * @return number or records in the recordset/resultset
	 * @throws SQLException
	 */
	protected int getRowCount(ResultSet rst) throws SQLException {
		int cntr = 0;
		
		while(rst.next()) {
			cntr++;
		}
		
		// reverts the record pointer to the BOF
		rst.beforeFirst();
		
		return cntr;
	}
	
	/**
	 * 
	 * Shows the actual Datagrid table
	 * @param Qry SQL statement
	 * @param colHeader Array of string for the column header's name
	 * @param TableTitle Title of the table
	 * @throws Exception
	 */
	public void showTable(String strQry, String[] columnHeader, String TableTitle) throws Exception {
		JFrame frame = new JFrame();
		mncTable tb = new mncTable();
		JScrollPane jScroll = new JScrollPane(tb.buildGrid(strQry, columnHeader));
		
		frame.setTitle(TableTitle);
		frame.add(jScroll);
		frame.setBounds(200, 200, 800, 600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
}
