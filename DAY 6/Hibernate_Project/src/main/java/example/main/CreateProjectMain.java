package example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import example.entity.Project;
public class CreateProjectMain {

	public static void main(String[] args) {
		//Configure Hibernate 
		Configuration cfg = new Configuration();
		cfg = cfg.configure();
		//Obtain SessionFactory
		SessionFactory factory = null;
		Session sessionObj = null;
		try {
			//Obtain SessionFactory
			factory= cfg.buildSessionFactory();
			//Obtain Session
			sessionObj = factory.openSession();
			//Instantiate Entity Class (Create an object of Entity Class)
			Project myProject = new Project(102,"Human Resource","C#",25);
			
			//Obtain Transaction
			Transaction tx = sessionObj.beginTransaction();
			
			//Store data into DB
			sessionObj.persist(myProject);//Stores a record
			
			//Commit the transaction to save changes
			tx.commit();
			//Close the session
			sessionObj.close();
			//Close the sessionFactory
			factory.close();
			System.out.println("Project created successfully!!!");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}

}
