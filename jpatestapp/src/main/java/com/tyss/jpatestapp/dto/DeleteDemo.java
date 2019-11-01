package com.tyss.jpatestapp.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeleteDemo {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et =em.getTransaction();
		try {
			et.begin();
			Movie m =em.find(Movie.class, 1026);
			em.remove(m);
			System.out.println("data deleted...");
			et.commit();
		}catch (Exception e) {
			et.rollback();
		}finally {
			em.close();
		}
	}

}
