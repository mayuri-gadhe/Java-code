package com.learning.main;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.learning.entity.Account;
import com.learning.entity.Employee2;
import com.learning.util.HibernateUtil;

public class LaunchOneToOne {
	
	public static void main(String[] args) {
		Session session=null;
		SessionFactory factory=null;
		Transaction transaction=null;
		boolean flag=true;
		
		try
		{
			session=HibernateUtil.getSession();
			if(session!=null)
			{
				transaction=session.beginTransaction();
				Account acc=new Account();
				acc.setAccId("T001");
				acc.setAccName("Mayuri Gadhe");
				acc.setAccType("Saving");
				
				Employee2 emp=new Employee2();
				emp.setEname("Mayuri Gadhe");
				emp.setCity("Rahuri");
				emp.setSalary(70000.90);
				emp.setAccount(acc);
				
				session.save(emp);
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
					System.out.println("Failed To save Data");
				}
			}
				
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
