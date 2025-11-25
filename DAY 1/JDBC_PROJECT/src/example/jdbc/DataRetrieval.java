package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataRetrieval {

	public static void main(String[] args) {
		//Program to retrieve data from DB using SELECT query and display it.
		
		//Step 1:Load the Driver
		String driverClass ="com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driverClass);
			System.out.println("Driver Loaded");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Step 2:Establish Connection
		String connectionUrl = "jdbc:mysql://localhost:3306/ycp?useSSL=false";
		String userId = "root";
		String password ="Ycpait24";
		Connection dbConnection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			dbConnection = DriverManager.getConnection(connectionUrl,userId,password);
			System.out.println("Connected to Database");
			
		 //Step 3: Obtain some Statement
			stmt = dbConnection.createStatement();
			
		//Step 4: Execute SQL Query
			String sqlQuery = "select student_name,student_city,student_id from students";
			rs = stmt.executeQuery(sqlQuery);
			
		//Step 5: Perform Navigation on ResultSet.
			while(rs.next()) {
				String name = rs.getString(1);//Name
				String city = rs.getString(2);//City
				int id = rs.getInt(3);//ID
				System.out.println(id + " ," +name + " ," + city);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
