package com.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entities.Laptop;
import com.entities.Student;

public class MainClass {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Laptop.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		
		Laptop l=new Laptop();
		l.setL_id(140);
		l.setlName("HP");
		
		ss.persist(l);
		
		Student s= new Student();
		s.setS_id(2);
		s.setS_Name("Ayush");
		s.setLaptop(l);
		
		ss.persist(s);
		
		
		tr.commit();
		ss.close();
		
		
	}

}
