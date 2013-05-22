package org.mugsandcoffee.datasource;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.FontMetrics;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import org.mugsandcoffee.ParseXML;

public class mncTable {

	private ParseXML Conn;
	private Connection ojbConn;
	
	public mncTable() {
		// opens connecton to database
		this.Conn = new ParseXML();
		this.ojbConn = Conn.connectToDB();
	}
	
	public JTable buildGrid()throws SQLException {
		
		String strQry = "SELECT p.name, r.links, r.distance, r.timefrom, r.timeto, r.timeelapsed, r.direction FROM route r LEFT JOIN person p ON r.agent=p.idw";
		Statement rstQry = this.ojbConn.createStatement();
		ResultSet rstRecord = rstQry.executeQuery(strQry);
		ResultSetMetaData rsMeta = rstRecord.getMetaData();
		
		// defines the column names
		String[] tblHeader = {"Agent Name", "Links", "Distance", "From", "To", "Elapse Time", "Direcion"};
		
		// defines column count
		int colCount = rsMeta.getColumnCount();
		int rowCount = this.getRowCount(rstRecord);
		
		Object allRow[][] = new Object[rowCount][colCount];
		int cntr = 0;
		
		// loops thru the resultset
		while(rstRecord.next()) {
			for(int i = 0; i < 7; i++) {
				allRow[cntr][i] = rstRecord.getString(i + 1);
			}
			cntr ++;
		}

		// closes the opened database connection
		this.Conn.closeConnection();

		JTable tblGrid = new JTable(allRow, tblHeader);
		
		return tblGrid;
	}
	
	protected int getRowCount(ResultSet rst) throws SQLException {
		int cntr = 0;
		
		while(rst.next()) {
			cntr++;
		}
		
		// reverts the record pointer to the BOF
		rst.beforeFirst();
		
		return cntr;
	}
	
	public void showTable() throws Exception {
		JFrame frame = new JFrame();
		mncTable tb = new mncTable();
		JScrollPane jScroll = new JScrollPane(tb.buildGrid());
		frame.setTitle("Route Analysis Report");
		frame.add(jScroll);
		frame.setBounds(200, 200, 800, 600);
		frame.setVisible(true);
	}
}
