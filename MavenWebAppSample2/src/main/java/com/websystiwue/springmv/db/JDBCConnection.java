package com.websystiwue.springmv.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class JDBCConnection {

	static Logger logger = Logger.getLogger(JDBCConnection.class.getName());

	static Connection connection = null;

	public JDBCConnection() {
		
	}

	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException, NamingException {
		if (connection == null || connection.isClosed()) {

			InputStream in = JDBCConnection.class.getClassLoader().getResourceAsStream("jdbc.dev.properties");
//			InputStream in = JDBCConnection.class.getClassLoader().getResourceAsStream("/MavenWebAppSample2/webapp/jdbc.dev.properties");
			
//			InputStream in = null;
			
			if (in != null) {
				logger.info("Using jdbc.dev.properties");
				Properties prop = new Properties();
				prop.load(in);
				in.close();

				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String pass = prop.getProperty("pass");
				String driver = prop.getProperty("driver");

				// Dev mode
				Class.forName(driver);
				connection = java.sql.DriverManager.getConnection(url, user, pass);
			} else {
				logger.info("Using data source");
				// Cloud mode
				InitialContext ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DefaultDB");
				connection = ds.getConnection();
			}

		}
		return connection;
	}
}
