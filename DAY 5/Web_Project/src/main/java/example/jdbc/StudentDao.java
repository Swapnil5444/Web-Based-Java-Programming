package example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDao  implements DaoInterface<Student,Integer>{

	@Override
	public Collection<Student> getAll() {
//		This method retrieves all the records from Students table,
//		converts them into Java objects of Student class and returns all those 
//		objects in the form of Collection.
		
		//Declaring an empty Collection meant for holding objects of type :Student
		Collection<Student> allStudents = new ArrayList<>();
		
		String sqlQuery = "select student_name,student_city,student_id from students";
		
		try (
				Connection dbConnection = JDBCUtils.getConnection();
				Statement stmt = dbConnection.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);
				){
			while(rs.next()) {
				String name = rs.getString(1);//Name
				String city = rs.getString(2);//City
				int id = rs.getInt(3);//ID
				
				//Creating an object of Student class based upon ID,Name & City
				Student studentObj = new Student(id,name,city);
				
				//Adding the Student object into Student Collection:
				allStudents.add(studentObj);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return allStudents;
	}

	@Override

	public Student getOne(Integer studentId) {

		//This method accepts an integer value indicating Student ID and return the Student object matching with that

		//id. If the id is non-existing , it returns null

		Student foundStudent = null;

		String sqlQuery =

				"SELECT student_name, student_city, student_id FROM students WHERE student_id = ?";

		try(

			Connection dbConnection = JDBCUtils.getConnection();

			PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);

			){

				pstmt.setInt(1, studentId);

				ResultSet rs = pstmt.executeQuery();

				if(rs.next()) {

					String name = rs.getString(1);

					String city = rs.getString(2);

					int id = rs.getInt(3);

					foundStudent = new Student(id, name, city);

				}

		}catch(Exception ex) {

			ex.printStackTrace();

		}

		return foundStudent;

	}


}
