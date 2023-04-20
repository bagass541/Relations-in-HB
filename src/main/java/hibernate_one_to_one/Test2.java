package hibernate_one_to_one;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;





public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory =  new Configuration()
				.configure("hibernate_test1/hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Detail.class)
				.buildSessionFactory();
		
		Session session = null;
		try {
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			
			
			
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}






