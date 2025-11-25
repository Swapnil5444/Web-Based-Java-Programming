package example.jdbc;

import java.util.Collection;

public class DataRetrievalMain {

	public static void main(String[] args) {
		DaoInterface<Student,Integer> daoRef = new StudentDao();
		Collection<Student> allStudents = daoRef.getAll();
		//1.Imperative Approach
//		for(Student st : allStudents) {
//			System.out.println(st);
		//2.Declarative Approach
		allStudents.stream().forEach(student -> System.out.println(student));
		
	}

}
