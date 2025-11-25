package example.main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.entity.Exam;
import example.utils.HibernateUtils;


public class DeleteExamMain {

	public static void main(String[] args) {
		//This class is use to fetch a single Exam record based upon its id
		//and delete the same
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
			    Session sessionObj = factory.openSession()
			    ){
			Class<Exam> examClassType= Exam.class;
			Object examCode ="E03";
			Exam foundExam = sessionObj.find(examClassType,examCode);
			if(foundExam !=null) {
				Transaction tx = sessionObj.beginTransaction();
			    sessionObj.remove(foundExam);
			    tx.commit();
			    System.out.println("Exam record deleted successfully");
			}
			else {
				System.out.println("Exam with given ID does not exist");
			}
		}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}

}


