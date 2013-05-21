package org.menu_builder;

import java.awt.Color;

import javax.swing.*;
import javax.swing.table.TableColumn;

import org.matsim.matrices.Matrices;
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
		String data_unpreped = search_street();
		String[] each_data = data_unpreped.split("|");
		System.out.println(each_data);
		int n = each_data.length;
		System.out.println(n);
		String[][] data = new String[n][7];
		for(int i=0; i<each_data.length; i++){
			String[] parsed_clm = each_data[i].split("\\-");
			 System.out.println("column:"+parsed_clm[0]);
			
//			data[i][0] = parsed_clm[0];
//			data[i][1] = parsed_clm[1];
//			data[i][2] = parsed_clm[2];
//			data[i][3] = parsed_clm[3];
//			data[i][4] = parsed_clm[4];
//			data[i][5] = parsed_clm[5];
//			data[i][6] = parsed_clm[6];
		}
		
		JTable tb1 = layout.buildJtable(data, columnNames, 300, 400, 0, 0);
		layout.addbuilder(tb1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate_table();
	}
	
	public static String search_street() {
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
            
            String data = "";
            
            int i=0;
            while(rs.next()){
            	data = rs.getString("name")+ "-" + rs.getString("links") + "-" + rs.getString("distance") + "-" + rs.getString("timefrom") + "-" + rs.getString("timeto") + "-" + rs.getString("timeelapsed") + "-" + rs.getString("direction") + "|";
            	i++;
            }
            data = data.substring(0, data.length()-1);
            return data;
           
        } catch (SQLException ex) {
        	System.out.println("catches exception: " + ex);
        	return "";
        }
		
       
	}
	
	
}
