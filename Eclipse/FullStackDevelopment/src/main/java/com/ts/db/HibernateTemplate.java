package com.ts.db;

import java.io.Serializable;





import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;


import com.dto.User;




public class HibernateTemplate {

	private static SessionFactory sessionFactory;
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static int addObject(Object obj){
		System.out.println("Inside Template...");
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.save(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;
		
		try {			
			return sessionFactory.openSession().get(c,serializable);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public static Object getObjectByUserMail(String mailId,String password) {
	
	String queryString = "from User where mailId = :mailId and password =:password";
	  Query query = sessionFactory.openSession().createQuery(queryString);
	  query.setString("mailId", mailId);
	  query.setString("password", password);
	  Object queryResult = query.uniqueResult();
	  User user = (User)queryResult;
	  return user; 
	}
	
	public static List<Object> getObjectListByQuery(String query) {
		return sessionFactory.openSession().createQuery(query).list();
	}
	
	/*public static Object getProductByFarmId(int farmerId) {
		
		String queryString = "from Product where farmerId = :farmerId";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setInteger("farmerId", farmerId);
		  Object queryResult = query.uniqueResult();
		  Product product = (Product)queryResult;
		  //System.out.println(farmer);
		  return product; 
		}*/
	/*public static Object getObjectByMail(String mailId, String password) {
		
		String queryString = "from Manufacturer where mailId = :mailId and password =:password";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("mailId", mailId);
		  query.setString("password", password);
		  Object queryResult = query.uniqueResult();
		  Manufacturer manufacturer = (Manufacturer)queryResult;
		  return manufacturer; 
		}*/
	
	/*public static int updateProducts(int productId, String status) {
		String queryString = "Product set status = :status where productId = :productId";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("status", status);
		query.setInteger("productId", productId);
		int res = query.executeUpdate();
		return res;
		
	}*/
	
	
	
	public static int updateObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Object obj=session.get(c,serializable);
			
			session.delete(obj);
			
			tx.commit();
			
			result=1;
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
		}
		
		return result;
	}

	public static List<Object> getObjectListByName(Class c, String columName, int id) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(c);
			Criterion nameCriterion = Restrictions.eq(columName, id);
			criteria.add(nameCriterion);
			return criteria.list();
	}
}
