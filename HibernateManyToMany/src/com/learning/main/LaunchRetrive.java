package com.learning.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.learning.entity.Student2;
import com.learning.util.HibernateUtil;

public class LaunchRetrive {

	public static void main(String[] args) {
     Session session=null;
	
		try
		{
		session = HibernateUtil.getSession();
		if(session!=null)
		{
			Student2 st1 = session.get(Student2.class, 1);
			System.out.println(st1);
			System.out.println("******************");
			Student2 st2 = session.get(Student2.class, 2);
			System.out.println(st2);
			System.out.println("******************");
			Student2 st3 = session.get(Student2.class, 3);
			System.out.println(st3);
			System.out.println("******************");
		     
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
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}


	}


	}


