package com.tyss.jpatestapp.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReadDemo {

	public static void main(String[] args) {
		
		try {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Movie movie=entityManager.find(Movie.class, 101);  // Entity class
		
		System.out.println(movie.getId());
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
