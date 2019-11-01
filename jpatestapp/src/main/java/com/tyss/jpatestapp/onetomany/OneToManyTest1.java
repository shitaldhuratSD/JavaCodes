package com.tyss.jpatestapp.onetomany;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpatestapp.onetoone.Pencile;
import com.tyss.jpatestapp.onetoone.PencileBox;

public class OneToManyTest1 {

	public static void main(String[] args) {
		Pencile1 p1 = new Pencile1();
		p1.setId(1);
		p1.setName("Natraj");
		
		Pencile1 p = new Pencile1();
		p.setId(2);
		p.setName("Apsara");
		
		ArrayList<Pencile1> ape=new ArrayList<Pencile1>();
		ape.add(p1);
		ape.add(p);
		
		PencileBox1 box=new PencileBox1();
		box.setPid(90);
		box.setPname("ApsaraBox");
		box.setPencil1(ape);
		
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
