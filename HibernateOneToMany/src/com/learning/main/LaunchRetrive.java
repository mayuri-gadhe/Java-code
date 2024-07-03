package com.learning.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import com.learning.entity.Department;
import com.learning.entity.Employee;

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
		Department dept=session.get(Department.class, "T10");
			System.out.println(dept);
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

