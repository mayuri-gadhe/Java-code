package com.learning.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.entity.Student;

public class LaunchApp {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Integer id = 1;
		Student st = session.get(Student.class, id);
      //Student st=session.load(student.class,id);
		if (st != null) {
			System.out.println("Control in if block..");
			Transaction transaction = session.beginTransaction();
			session.delete(st);
			transaction.commit();
		} else {
			System.out.println("record with id " + id + " not found");
		}

		session.close();
		sessionFactory.close();

	}

}
