package org.menu_builder;

import java.awt.Color;

import javax.swing.*;
import javax.swing.table.TableColumn;
import org.menu_builder.*;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class gridlayout {

	public static void generate_table(){
		LayoutBuilder layout = new LayoutBuilder(500, 600, "Routes");
		String[] columnNames = {
				"Name",
                "Links",
                "Distance",
                "Time-From",
                "Time-To",
                "Time-Elapsed",
                "Direction"
                };
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
		System.out.println("printing data");
		search_street();
		System.out.println("data printed");
		JTable tb1 = layout.buildJtable(data, columnNames, 300, 400, 0, 0);
		layout.addbuilder(tb1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate_table();
	}
	
	public static Object[][] search_street() {
		String dbURL = "jdbc:mysql://localhost:3306/matsim";
        String username ="root";
       
        Connection dbCon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       
       
       
        try {
            //getting database connection to MySQL server
            dbCon = DriverManager.getConnection(dbURL, username, "");
           
            //getting PreparedStatment to execute query
            String query ="CALL sp_generate_analysis_report()";
            stmt = dbCon.prepareStatement(query);
           
            //Resultset returned by query
            stmt.executeQuery(query);
            
            String query2 ="SELECT p.name, r.links, r.distance, r.timefrom, r.timeto, r.timeelapsed, r.direction FROM route r LEFT JOIN person p ON r.agent=p.idw;";
            PreparedStatement stmt2 = dbCon.prepareStatement(query2);
            
            //Resultset returned by query
            rs = stmt2.executeQuery(query2);
            Object[][] data = null;
            int i=0;
            while(rs.next()){
            	System.out.println(rs.getString("links"));
//            	data[i][1] = rs.getString("name");
//            	data[i][2] = rs.getString("links");
//            	data[i][3] = rs.getString("distance");
//            	data[i][4] = rs.getString("timefrom");
//            	data[i][5] = rs.getString("timeto");
//            	data[i][6] = rs.getString("timeelapsed");
//            	data[i][7] = rs.getString("direction");
//            	data[i][8] = rs.getString("link_id");
            	i++;
            }
            System.out.println(data);
            return data;
           
        } catch (SQLException ex) {
        	
        }
		return null;
       
	}
	
	
}
