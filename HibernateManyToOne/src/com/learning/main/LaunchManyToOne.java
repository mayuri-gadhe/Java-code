package com.learning.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learning.entity.Branch;
import com.learning.entity.Student;
import com.learning.util.HibernateUtil;

public class LaunchManyToOne {

	public static void main(String[] args) {
		Session session=null;
		SessionFactory factory=null;
		Transaction transaction=null;
		boolean flag=false;
		try
		{
		session=HibernateUtil.getSession();
		if(session!=null)
		{
			transaction=session.beginTransaction();
			Branch branch=new Branch();
			branch.setBid("M10");
			branch.setBranchName("Electrical");
			branch.setBranchLocation("Mumbai");
			
			Student s1=new Student("Supriya","pune",branch);
			Student s2=new Student("Rutuja","Thane",branch);
			Student s3=new Student("Darshana","Bengluru",branch);
			
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
				System.out.println("Data Saved Successfully"); 
			}
			else
			{
				if(transaction!=null)
				{
					transaction.rollback();
					System.out.println("Data not saved successfully");
				}
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
		
	}
}
