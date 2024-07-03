package com.learning.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.learning.entity.Student;

public class LaunchApp1 {

	public static void main(String[] args) {
		
		Configuration config=new Configuration();
		config.configure();
		SessionFactory sessionFact = config.buildSessionFactory();
		Session session = sessionFact.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student st=new Student();
		st.setId(1);
		st.setName("Vandana");
		st.setAge(27);
		st.setCity("Pune");
		
		//session.save(st);
		//session.update(st);
		session.saveOrUpdate(st);
		transaction.commit();
	    sessionFact.close();
	    session.close();
		
		

	}

}
