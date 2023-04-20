package hibernate_one_to_many_bi;

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
//			Department department = new Department("Sales", 800, 1500);
//			Employee emp1 = new Employee("Sasha", "Bagas", 900);
//			Employee emp2 = new Employee("Elena", "Smirnova", 1099);
//			Employee emp3 = new Employee("Anton", "Sidorov", 1299);
//			
//			department.addEmployeeToDepartment(emp1);
//			department.addEmployeeToDepartment(emp2);
//			department.addEmployeeToDepartment(emp3);
//			
//			session.beginTransaction();
//			
//			session.save(department);
//			
//			session.getTransaction().commit();
//			System.out.println("Done");
			
			//*********************************
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("Get department");
			Department department = session.get(Department.class, 5);
			
			System.out.println("Show department");
			System.out.println(department);
			
			System.out.println("Подгрузим наших работников");
			department.getEmps().get(0);
		
			session.getTransaction().commit();
			
			System.out.println("Show employees");
			System.out.println(department.getEmps());
			
			System.out.println("Done");
			
			//*********************************
//			session = factory.getCurrentSession();
//			
//			session.beginTransaction();
//			
//			Employee employee = session.get(Employee.class, 1);
//			
//			System.out.println(employee);
//			System.out.println(employee.getDepartment());
//		
//			
//			session.getTransaction().commit();
//			System.out.println("Done");
			
			//*********************************
//			session = factory.getCurrentSession();
//			
//			session.beginTransaction();
//		
//			Employee employee = session.get(Employee.class, 1);
//			
//			session.delete(employee);
//			
//			session.getTransaction().commit();
//			System.out.println("Done");
			
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






