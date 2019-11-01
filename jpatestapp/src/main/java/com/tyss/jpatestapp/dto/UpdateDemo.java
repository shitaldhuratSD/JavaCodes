package com.tyss.jpatestapp.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateDemo {

	public static void main(String[] args) {
	 EntityTransaction transaction=null;
	 EntityManager entityManager=null;
	 EntityManagerFactory entityManagerFactory=null;
	 
	 try {
		entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
		entityManager=entityManagerFactory.createEntityManager();
		transaction=entityManager.getTransaction();
		transaction.begin();
		
		Movie movie=entityManager.find(Movie.class, 102);
		movie.setName("Dil to Pagal Hai");
		
//		System.out.println("record deleted");
		transaction.commit();
		 
	} catch (Exception e) {
		transaction.rollback();
		e.printStackTrace();
	}

	}

}
