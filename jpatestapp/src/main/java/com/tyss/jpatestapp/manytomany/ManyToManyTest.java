package com.tyss.jpatestapp.manytomany;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ManyToManyTest {

	public static void main(String[] args) {
		
		Courses course=new Courses();
		course.setCid(15);
		course.setCname("Hibernate");
		
		Courses course1=new Courses();
		course1.setCid(16);
		course1.setCname("Angular");
		
		ArrayList<Courses> arrayList=new ArrayList<Courses>();
		arrayList.add(course);
		arrayList.add(course1);
		
		Student student=new Student();
		student.setSid(105);
		student.setSname("Mona");
		
		Student student1=new Student();
		student1.setSid(106);
		student1.setSname("Vishal");
		
		
		student1.setCourses(arrayList);
		
		
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager= entityManagerFactory.createEntityManager();
			transaction=entityManager.getTransaction();
			transaction.begin();
			System.out.println("unidirection");
			entityManager.persist(student);
			entityManager.persist(student1);
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
