package com.tyss.jpatestapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpatestapp.dto.Movie;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	
 
    EntityTransaction transaction = null;
	EntityManager entityManager = null;
	EntityManagerFactory entityManagerFactory = null;
	
	Movie movie=new Movie();
	movie.setId(102);
	movie.setName("Abcd");
	movie.setRating("good");
	
	
	try {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		entityManager=entityManagerFactory.createEntityManager();
		transaction=entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(movie);
		System.out.println("saved");
		transaction.commit();
	}catch(Exception e) {
		transaction.rollback();
		e.printStackTrace();
		
	}finally {
		entityManager.close();
	
	}

}//end of the main method

}//end of the class
