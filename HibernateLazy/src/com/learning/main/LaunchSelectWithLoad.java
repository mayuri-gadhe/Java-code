package com.learning.main;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learning.entity.Student;

public class LaunchSelectWithLoad {

	public static void main(String[] args) throws IOException {
		Configuration config=new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Student st=session.load(Student.class, 2);
		System.out.println(st.getId());
		System.out.println(st.getSname());
		System.out.println(st.getSage());
		System.out.println(st.getScity()); 
		
		System.in.read();
		Student st1=session.load(Student.class, 2);
		System.out.println(st1.getId());
		System.out.println(st1.getSname());
		System.out.println(st1.getSage());
		System.out.println(st1.getScity()); 
		
		session.close();
		sessionFactory.close();
		
		}

}
