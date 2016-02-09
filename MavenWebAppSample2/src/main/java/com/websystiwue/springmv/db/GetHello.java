package com.websystiwue.springmv.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.naming.NamingException;


import com.websystiwue.springmv.domain.Message;


public class GetHello {
	
	private String name;
	
	
	
	public GetHello(String name) {
		super();
		this.name = name;
	}



	public Message getHello(){
		
		Message message = null;
		
		try {
			Connection conn = JDBCConnection.getConnection();		
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery
					(
							
							"select \'Hello " + this.name + " from HANA\' AS \"Greeting\" from dummy"
							
							);
			
			
			while(rs.next()){
			  String greeting = rs.getString("Greeting");
			  message = new Message(name, greeting);
			}
	
		   
		  rs.close();
		  stmt.close();
		  conn.close();
		  
		  
		} catch (ClassNotFoundException | IOException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		  return message;
	
	}

}
