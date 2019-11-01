package com.tyss.jpatestapp.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpatestapp.dto.Movie;

public class UpdateDemoJpql {

	public static void main(String[] args) {
		 EntityTransaction transaction=null;
		 EntityManager entityManager=null;
		 EntityManagerFactory entityManagerFactory=null;
		 
		 try {
			entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			
			//String jpql="update Movie set name='Chichore' where id=103";		//Hard code
			String jpql="update Movie set name=:name1 where id=:id";		// Dynamically passing data 
			Query query = entityManager.createQuery(jpql);
			query.setParameter("name1", "Sairat");
			query.setParameter("id",103 );
			int result=query.executeUpdate();
			
			System.out.println(result+" Data Updated");
			
			transaction.commit();
			 
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}


	}

}
