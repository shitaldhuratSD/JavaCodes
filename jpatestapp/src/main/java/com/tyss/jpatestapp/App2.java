package com.tyss.jpatestapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyss.jpatestapp.dto.Movie;

public class App2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em=emf.createEntityManager();
		
		Movie m=em.find(Movie.class, 12);
		
		System.out.println("movie info........");
		System.out.println(m.getId());
		System.out.println(m.getName());
		System.out.println(m.getRating());

	}

}
