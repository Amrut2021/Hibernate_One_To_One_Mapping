package com.Main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entities.Laptop;
import com.entities.Student;



public class FetchAllRecord {
	public static void main(String[] args) {
		
	
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");
	cfg.addAnnotatedClass(Student.class);
	SessionFactory sf = cfg.buildSessionFactory();
	Session ss = sf.openSession();
	Transaction tr = ss.beginTransaction();

	
	String hqlQuery1="from Laptop";
	Query<Laptop>query1=ss.createQuery(hqlQuery1);
	List<Laptop> list1=query1.getResultList();
	for(Laptop laptop:list1) {
		System.out.println(laptop);
		
	}
	
//	String hqlQuery = "from Student";
//	Query<Student> query = ss.createQuery(hqlQuery);
//	List<Student> list = query.getResultList();
//	for (Student student : list) {
//		System.out.println(student);
//	}
	tr.commit();
	ss.close();
	}
	

}
