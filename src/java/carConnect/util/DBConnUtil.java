package carConnect.util;

import java.sql.*;

public class DBConnUtil {

	public static Connection getConnection(String connectionString) throws SQLException{
	    Connection connection=null;    
	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                //System.out.println("Driver Loaded");
	                connection = DriverManager.getConnection(connectionString);
	                //System.out.println("Database Connection Established.");
	            } catch (SQLException err) {
	                err.printStackTrace();
	                throw new SQLException("Failed to Establish Connection.", err);
	            } catch (ClassNotFoundException err) {
	                err.printStackTrace();
	                throw new RuntimeException("Driver Loading Failed.", err); 
	            }
	        return connection;
	    }

}
