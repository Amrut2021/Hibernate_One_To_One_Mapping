package com.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entities.Laptop;
import com.entities.Student;

public class UpdateData {
	
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Laptop.class);
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tr=ss.beginTransaction();
		
		String hqlQuery="Update Student set s_Name=:myName where s_id=:myid";	
		Query<Student> query=ss.createQuery(hqlQuery);
		query.setParameter("myName","Jija");
		query.setParameter("myid", 1);
		
		query.executeUpdate();
		tr.commit();
		ss.close();
		
	}

}
