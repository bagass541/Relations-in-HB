package hibernate_test1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate_test1.entity.Employee;



public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory =  new Configuration()
				.configure("hibernate_test1/hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		try {
			Session session = factory.getCurrentSession();
			Employee emp = new Employee("Oleg", "Sidorov", 
					"HR", 550);
			session.beginTransaction();
			session.save(emp);
			//session.getTransaction().commit();
			
			int myId = emp.getId();
		//	session = factory.getCurrentSession();
		//	session.beginTransaction();
			Employee employee = session.get(Employee.class, myId);
			session.getTransaction().commit();
			System.out.println(employee);
			
			System.out.println("Done");
		}
		finally {
			factory.close();
		}
		
	}

}
