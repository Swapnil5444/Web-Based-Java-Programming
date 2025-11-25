package example.jdbc;

public class DataUpdationMain {

	public static void main(String[] args) {
		DaoInterface<Student,Integer> daoRef = new StudentDao();
		Student foundStudent = daoRef.getOne(21107008);
		if(foundStudent!= null) {
			foundStudent.setName("Rohan Shirish Waghode");
			foundStudent.setCity("Mumbai");
			daoRef.update(foundStudent);
		}else 
			System.out.println("Student with given ID does not exist.");
	}
}
