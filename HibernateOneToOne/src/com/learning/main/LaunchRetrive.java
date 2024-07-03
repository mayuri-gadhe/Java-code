package com.learning.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.learning.entity.Employee2;
import com.learning.util.HibernateUtil;

public class LaunchRetrive {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				Employee2 emp = session.get(Employee2.class, 1);
				System.out.println(emp);
			}
		} catch (HibernateException e) {

		} catch (Exception e) {

		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
