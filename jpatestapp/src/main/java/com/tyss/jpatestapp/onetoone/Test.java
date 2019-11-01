package com.tyss.jpatestapp.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {		// one to one class

	public static void main(String[] args) {

		Person person=new Person();

		person.setId(101);
		person.setName("Radha");
		person.setAge(23);

		VoterCard vc=new VoterCard();
		vc.setV_id(11);
		vc.setV_name("Mona");
		person.setVoterCard(vc);

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager= entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			//entityManager.persist(person);
			VoterCard voterCard= entityManager.find(VoterCard.class, 11);
			voterCard.getPerson1().getName();
			System.out.println("saved");
			transaction.commit();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			entityManager.close();
		}
	}

}
