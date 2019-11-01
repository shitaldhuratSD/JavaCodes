package com.tyss.jpatestapp.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ReattachedDemo {

	public static void main(String[] args) {
		 EntityTransaction transaction=null;
		 EntityManager entityManager=null;
		 EntityManagerFactory entityManagerFactory=null;
		 
		try {
		 entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		 entityManager =entityManagerFactory.createEntityManager();
		 transaction=entityManager.getTransaction();
			transaction.begin();
		Movie movie=entityManager.find(Movie.class, 102);  // Entity class
		System.out.println(movie.getClass());
		System.out.println(entityManager.contains(movie));
		entityManager.detach(movie);
		
		System.out.println(entityManager.contains(movie));
		movie.setName("Dill");
		
		entityManager.merge(movie);			//re-attached
		System.out.println(entityManager.contains(movie));
		transaction.commit();
			
        System.out.println(movie.getId());

			
     
			}catch(Exception e) {
				transaction.rollback();
				e.printStackTrace();
			}finally {
				 entityManager.close();
			}
			

	}

}
