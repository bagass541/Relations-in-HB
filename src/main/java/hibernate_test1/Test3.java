package hibernate_test1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate_test1.entity.Employee;



public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory =  new Configuration()
				.configure("hibernate_test1/hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Employee> emps = session.createQuery("from Employee " +
					"where surname = 'Bogos' AND salary>200")
					.getResultList();
			
			for(Employee e : emps)
			{
				System.out.println(e);
			}
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
		
	}

}
