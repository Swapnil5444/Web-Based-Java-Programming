package example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import example.entity.Exam;
import example.utils.HibernateUtils;
import org.hibernate.Transaction;

public class CreateExamMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
			    Session sessionObj = factory.openSession()
			    ){
			Exam examObj = new Exam("E03","Computer Networks","MCQ", 30);
			Transaction tx = sessionObj.beginTransaction();
		    sessionObj.persist(examObj);
			tx.commit();
			System.out.println("Exam created successfully!!!");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		}
}
