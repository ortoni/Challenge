package dataBaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 *  Dependencies:
 *  
 * https://mvnrepository.com/artifact/mysql/mysql-connector-java
 * compile group: 'mysql', name: 'mysql-connector-java', version: '5.1.6'
*/

public class DataBaseConnection {
	
	public void database(String data){
		// JDBC driver name and database URL
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://13.233.35.41:3306/opentaps";
		
		// DataBase Credentials
		final String user = "opentaps";
		final String pass = "Leaf@123";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			// Register JDBC Driver
			Class.forName(JDBC_DRIVER);
			
			// Open a Connection
			try {
				conn = DriverManager.getConnection(DB_URL, user, pass);
				
				// Execute a Query
				stmt = conn.createStatement();
				
				String sql = "SELECT FIRST_NAME, LAST_NAME FROM OPENTAPS.PERSON WHERE PARTY_ID = "+data;
				ResultSet executeQuery = stmt.executeQuery(sql);
				
				// Extract Data from Result Set
				while(executeQuery.next()) {
					String fName = executeQuery.getString("FIRST_NAME");
					String lName = executeQuery.getString("LAST_NAME");
					
					System.out.print("First Name: "+fName+ " Last Name: "+lName);
				}
				
				// Close all connections
				executeQuery.close();
				stmt.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		}
	

}










