package com.tyss.jpatestapp.onetoone;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OneToManyTest {

	public static void main(String[] args) {
		Pencile p1 = new Pencile();
		p1.setId(1);
		p1.setName("Natraj");
		
		Pencile p = new Pencile();
		p.setId(2);
		p.setName("Apsara");
		
		ArrayList<Pencile> ape=new ArrayList<Pencile>();
		ape.add(p1);
		ape.add(p);
		
		PencileBox box=new PencileBox();
		box.setPid(90);
		box.setPname("ApsaraBox");
		box.setPencil(ape);
		
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager= entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			System.out.println("unidirection");
			entityManager.persist(box);
			System.out.println("saved");
			transaction.commit();

		}catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			entityManager.close();
		}

	}

}
