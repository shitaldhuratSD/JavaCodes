package com.tyss.jpatestapp.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteJPQL {

	public static void main(String[] args) {
		
		 EntityTransaction transaction=null;
		 EntityManager entityManager=null;
		 EntityManagerFactory entityManagerFactory=null;
		 
		 try {
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			
			//String jpql="delete from Movie where id=105";
			String jpql="delete from Movie where id=:id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", 105);
			int result=query.executeUpdate();
			System.out.println(result+" Deleted Data");
			
			transaction.commit();
			 
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

}
