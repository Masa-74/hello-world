import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

import org.junit.Test;

import com.websystiwue.springmv.db.GetHello;
import com.websystiwue.springmv.db.JDBCConnection;
import com.websystiwue.springmv.domain.Message;

public class AccessHANATest {

	@Test
	public void getHello(){
		
		Message message = null;
		String name = "TEST";
		
		GetHello getHello = new GetHello(name);
		message = getHello.getHello();
		
		
//		try {
//			Connection conn = JDBCConnection.getConnection();		
//			Statement stmt = conn.createStatement();
//			
//			ResultSet rs = stmt.executeQuery
//					(
//							
//							"select \'Hello " + name + " from HANA\' AS \"Greeting\" from dummy"
//							
//							);
//			
//			
//
//			while(rs.next()){
//			  String greeting = rs.getString("Greeting");
//			  message = new Message(name, greeting);
//			}
//		   
//		  rs.close();
//		  stmt.close();
//		  conn.close();
//		  
//		  
//		} catch (ClassNotFoundException | IOException | SQLException | NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Message answer = new Message(name, "Hello " + name + " from HANA");
		if(message != null){
			assert(message.equals(answer));
		}
	
	}
	
}
