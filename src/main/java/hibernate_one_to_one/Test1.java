package hibernate_one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;





public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory =  new Configuration()
				.configure("hibernate_test1/hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Detail.class)
				.buildSessionFactory();
		
		Session session = null;
		try {
//			Session session = factory.getCurrentSession();
//			Employee employee = new Employee("Alex", "Bagas", "IT", 500);
//			Detail detail = new Detail("Gomel", "12356675", "alexbagas@gmail.com");
//			employee.setEmpDetail(detail);
//			session.beginTransaction();
//			
//			session.save(employee);
//			
//			session.getTransaction().commit();
//			System.out.println("Done");
			
			
//			Session session = factory.getCurrentSession();
//			Employee employee = new Employee("Oleg", "Smrinov", "Sales", 200);
//			Detail detail = new Detail("Moscow", "98754321", "olegsm@gmail.com");
//			employee.setEmpDetail(detail);
//			session.beginTransaction();
//			
//			session.save(employee);
//			
//			session.getTransaction().commit();
//			System.out.println("Done");
			
			
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			Employee emp = session.get(Employee.class, 2);
			session.delete(emp);
			

			
			session.getTransaction().commit();
			System.out.println("Done");
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}






