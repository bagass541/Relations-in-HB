package hibernate_test1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate_test1.entity.Employee;



public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory =  new Configuration()
				.configure("hibernate_test1/hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete Employee where firstName = 'Elena'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
		
	}

}
