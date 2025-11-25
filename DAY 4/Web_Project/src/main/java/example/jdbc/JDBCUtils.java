package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//This method used to establish connection with DB and return the same 
		String connectionUrl = "jdbc:mysql://localhost:3306/ycp?useSSL=false&allowPublicKeyRetrieval=true";
		String userId = "root";
		String password ="Ycpait24";
		Connection dbConnection = DriverManager.getConnection(connectionUrl,userId,password);
		return dbConnection;
	}

}
