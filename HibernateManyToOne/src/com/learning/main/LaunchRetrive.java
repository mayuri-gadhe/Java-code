package com.learning.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import com.learning.entity.Student;


public class LaunchRetrive
{
public static void main(String[] args) {
	Session session=null;
	SessionFactory sessionFactory=null;
	
	
	try
	{
		 sessionFactory = new Configuration().configure().buildSessionFactory();
		session=sessionFactory.openSession();
	if(session!=null)
	{
		
		Student student=session.get(Student.class, 1);
		System.out.println(student);
					}
	
	}
	catch(HibernateException e)
	{
		e.printStackTrace();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(session!=null)
			session.close();
		if(sessionFactory!=null)
			sessionFactory.close();
	}
}

}

