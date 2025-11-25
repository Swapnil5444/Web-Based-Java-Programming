package example.jdbc;

public class DataInsertionMain {

	public static void main(String[] args) {
		DaoInterface<Student,Integer> daoRef = new StudentDao();
		
		Student std = new Student(21107009, "Rohan Waghode","Jalgaon");
		daoRef.create(std);



	}

}
