package com.example.studentMgmt.crudUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.studentManagement.entity.Course;
import com.example.studentManagement.entity.Employee;
import com.example.studentManagement.entity.Feedback;
import com.example.studentManagement.entity.Gender;
import com.example.studentManagement.entity.Instructor;
import com.example.studentManagement.entity.Student;
import com.example.util.HibernateUtil;

/**
 * 
 * This class performs CRUD operation on Students using HQL.
 * This is useful when we are not using default CRUD operation 
 * for JPA repository.
 * 
 */
public class ExampleCRUD {
	public static boolean crateEmployee ( Employee  emp) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			// Create 	
			Transaction transaction = session.beginTransaction();
			session.save(emp);
			transaction.commit();
			//System.out.println ("Employee  Created Successfully");
		}

		catch (Exception e) {
			return false;

		}
		finally {
			if (session!=null) session.close();
			//if (sessionFactory!=null) sessionFactory.close();
		}
		return true;
	}


	// Create a row in the database table student with the student data

	public static boolean crateStudent ( Student student) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			// Create 
			student.setGender(Gender.MALE);
			Transaction transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			System.out.println ("Student Created Successfully");
		}

		catch (Exception e) {
			return false;

		}
		finally {
			if (session!=null) session.close();
			//if (sessionFactory!=null) sessionFactory.close();
		}
		return true;
	}

	//  Update an existing student with the student data
	public static boolean updateStudent ( Student student) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			// Create 
			student.setGender(Gender.MALE);
			Transaction transaction = session.beginTransaction();
			session.update(student);
			transaction.commit();
			System.out.println ("Student Created Successfully");
		}

		catch (Exception e) {
			return false;

		}
		finally {
			if (session!=null) session.close();
			//if (sessionFactory!=null) sessionFactory.close();
		}
		return true;
	}

	// Retrieve student by ID
	// It returns fully initialized object so this method 
	// 	performs eager loading of  the object.   
	//  Return null if not found
	public static Student findStudent ( int studentID) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {

			Student student = (Student) session.get(Student.class, studentID);
			System.out.println(student.getId() + " - " + student.getFirstName());     
			return  student;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
		finally {
			if (session!=null) session.close();
			//if (sessionFactory!=null) sessionFactory.close();
		}
	}

	//  Load  student by ID
	//  It is different from findStudent because it just return the reference 
	//  as it performs lazy loading.  
	//  It throws exception if not found
	//  Visit for more info: https://www.tutorialspoint.com/difference-between-get-and-load-in-hibernate
	public static Student loadStudent ( int studentID) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {

			Student dbStudent = (Student) session.load(Student.class, studentID);
			System.out.println(dbStudent.getId() + " - " + dbStudent.getFirstName());     
			return  dbStudent;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
		finally {
			if (session!=null) session.close();
			//if (sessionFactory!=null) sessionFactory.close();
		}
	}


	public static boolean crateInstructor ( Instructor instr) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			// Create 
			Transaction transaction = session.beginTransaction();
			session.save(instr);
			transaction.commit();
		}

		catch (Exception e) {
			return false;

		}
		finally {
			if (session!=null) session.close();
			//if (sessionFactory!=null) sessionFactory.close();
		}
		return true;
	}

	public static boolean crateCourset(Course crs) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			// Create 
			Transaction transaction = session.beginTransaction();
			session.save(crs);
			transaction.commit();
		}

		catch (Exception e) {
			return false;

		}
		finally {
			if (session!=null) session.close();
			//if (sessionFactory!=null) sessionFactory.close();
		}
		return true;
	}

	public static void main(String[] args) {

		//		Employee emp = new Employee();
		//		emp.setName("Pranoti");
		//		crateEmployee(emp);

		for (int i = 0; i < 3; i++) {
			Employee emp = new Employee();
			emp.setName("John-" +i);
			emp.setSalary(20000);
			crateEmployee(emp);
		}
	}


	public static boolean saveFeedBack(Feedback feed) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			// Create a row in the table
			Transaction transaction = session.beginTransaction();
			session.save(feed);
			transaction.commit();
		}

		catch (Exception e) {
			return false;

		}
		finally {
			if (session!=null) session.close();
			//if (sessionFactory!=null) sessionFactory.close();
		}

		return true;

	}


}


