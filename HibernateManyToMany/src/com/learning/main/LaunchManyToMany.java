package com.learning.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learning.entity.Course;
import com.learning.entity.Student2;
import com.learning.util.HibernateUtil;

public class LaunchManyToMany {
	
	public static void main(String[] args)
	{
		Session session=null;
		SessionFactory factory=null;
		Transaction transaction=null;
		boolean flag=true;
		try
		{
			session=HibernateUtil.getSession();
			if(session!=null)
			{
				transaction= session.beginTransaction();
				Course c1=new Course(1,"JAVA",15000);
				Course c2=new Course(2,"SPRING-BOOT",20000);
				Course c3=new Course(3,"HIBERNATE",10000);
				
				Set<Course> set1=new HashSet<>();
				set1.add(c1);
				set1.add(c2);
				Set<Course> set2=new HashSet<>();
				set2.add(c1);
				set2.add(c2);
				set2.add(c3);
				Set<Course> set3=new HashSet<>();
				set3.add(c1);
				
				Student2 s1=new Student2("Mangesh","Pune", set1);
				Student2 s2=new Student2("Arjun","Thane",set2);
				Student2 s3=new Student2("Yogesh","Mumbai",set3);
				
				session.save(s1);
				session.save(s2);
				session.save(s3);
				flag=true;
				
				
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
			if(flag)
			{
			transaction.commit();
			System.out.println("Data Saved successfully");
			}
			else
			{
				if(transaction!=null)
				{
					transaction.rollback();
					System.out.println("Failed to save Data");
				}
			}
			
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
		
	}

}
