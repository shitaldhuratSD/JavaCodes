package com.tyss.jpatestapp.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpatestapp.dto.Movie;



public class ReadDemo {

	public static void main(String[] args) {


		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		EntityManagerFactory entityManagerFactory = null;

		entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		entityManager=entityManagerFactory.createEntityManager();
		//String jpql="from Movie"; 				 //1
		String jpql="select name from Movie";			//2
		Query query = entityManager.createQuery(jpql);
		List<String> resultList=query.getResultList();	// getting the only name column of Entity class results 2-1
		//List<Movie> resultList=query.getResultList();		//1-1

		for (String string : resultList) {

			System.out.println(string);
		}

		/*for(Movie movie : resultList) {		//1-2
				System.out.println(movie.getId());
			}*/
		
		
		/*for (String str : resultList) {
			System.out.println(str);
		}*/

	}

}
