package com.tyss.jpatestapp.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

public class ReadDemo2 {

	public static void main(String[] args) {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Movie movie=entityManager.find(Movie.class, 102);  // Entity class and Query will execute without using data members
			System.out.println(movie.getClass());
			System.out.println(entityManager.contains(movie));
			entityManager.detach(movie);
			System.out.println(entityManager.contains(movie));
			
//			Movie movie=entityManager.getReference(Movie.class, 103);
//			System.out.println(movie.getClass());
			
  //        System.out.println(movie.getId());
//			System.out.println(movie.getName());
//			System.out.println(movie.getRating());
			
			}catch(Exception e) {
	
				e.printStackTrace();
			}finally {
				//entityManager.close();
			}
			
	}

}
