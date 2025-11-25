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
	public Student getOne(Integer studentid) {
		//This method accepts an integer value indicating Student ID 
		//and returns the Student object matching with that ID 
		//If the ID is non-existing,it returns null.
		Student foundStudent = null;
		String sqlQuery = "select student_name,student_city,student_id from students where student_id = ?";
		try (
				Connection dbConnection = JDBCUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				){
					//Substituting studentId in place of '?'
					pstmt.setInt(1, studentid);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {
						String name = rs.getString(1);//Name
						String city = rs.getString(2);//City
						int id = rs.getInt(3);//ID
						foundStudent = new Student(id,name,city);
					}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return foundStudent;
	}

	@Override
	public void create(Student studentObj) {
		//This method accept the student object and stores it as a record into Student table.
		String sqlQuery = "insert into students values(?,?,?)";
		try (
				Connection dbConnection = JDBCUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				){
					//Fetching the value from Student object
					int id = studentObj.getStudentId();
					String name = studentObj.getName();
					String city =studentObj.getCity();
					//Substituting these values in place of '?'
					pstmt.setInt(1, id);
					pstmt.setString(2, name);
					pstmt.setString(3, city);
					
					int count = pstmt.executeUpdate();
                    System.out.println(count + "Record Inserted");				
		}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		
		
	}

	@Override
	public void update(Student modifiedStudentObj) {
		//This method received modified state of the Student Object and 
		//reflects that state back to DB to complete the UPDATE operation.
		String sqlQuery = "update students set student_name = ?,student_city = ? where student_id = ?";
			try (
					Connection dbConnection = JDBCUtils.getConnection();
					PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
					){
					//Fetching the value from Student object
					int id = modifiedStudentObj.getStudentId();
					String name = modifiedStudentObj.getName();
					String city =modifiedStudentObj.getCity();
					//Substituting these values in place of '?'
					pstmt.setInt(3, id);
					pstmt.setString(1, name);
					pstmt.setString(2, city);
					
					int count = pstmt.executeUpdate();
                    System.out.println(count + "Record Updated");				
		}
			catch(Exception ex) {
				ex.printStackTrace();
			}
	}

	@Override
	public void deleteOne(Integer studentid) {
		//This method accepts ID of the student and deletes 
		//the relevant records from the DB table.
		String sqlQuery = "delete from students where student_id = ?";
		try (
				Connection dbConnection = JDBCUtils.getConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery);
				){
				//Substituting these values in place of '?'
				pstmt.setInt(1, studentid);
				int count = pstmt.executeUpdate();
				if(count!= 0)
                System.out.println(count + "Record Deleted");
				else
					System.out.println("Student with given ID does not exist.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
