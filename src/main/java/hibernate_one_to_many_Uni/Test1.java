package hibernate_one_to_many_Uni;

import org.hibernate.Session;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory =  new Configuration()
				.configure("hibernate_test1/hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Department.class)
				.buildSessionFactory();
		
		Session session = null;
		try {
			
//			session = factory.getCurrentSession();
//			Department department = new Department("HR", 400, 1500);
//			Employee emp1 = new Employee("Oleg", "Ivanov", 500);
//			Employee emp2 = new Employee("Andrew", "Sidorov", 1099);
//			
//			department.addEmployeeToDepartment(emp1);
//			department.addEmployeeToDepartment(emp2);
//			
//			session.beginTransaction();
//			
//			session.save(department);
//			
//			session.getTransaction().commit();
//			System.out.println("Done");
			
			
//			session = factory.getCurrentSession();
//			
//			session.beginTransaction();
//			
//			Department department = session.get(Department.class, 4);
//			
//			System.out.println(department);
//			System.out.println(department.getEmps());
//		
//			
//			session.getTransaction().commit();
//			System.out.println("Done");
			
			
//			session = factory.getCurrentSession();
//			
//			session.beginTransaction();
//			
//			Employee employee = session.get(Employee.class, 1);
//			
//			System.out.println(employee);
//		
//			
//			session.getTransaction().commit();
//			System.out.println("Done");
			
//			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
		
			Department department = session.get(Department.class, 4);
			
			session.delete(department);
			
			session.getTransaction().commit();
			System.out.println("Done");
			
			//*********************************
//			session = factory.getCurrentSession();
//			
//			session.beginTransaction();
//	
//			Employee employee = session.get(Employee.class, 5);
//			
//			session.delete(employee);
//			
//			session.getTransaction().commit();
//			System.out.println("Done");
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}






