package com.tyss.flipcartapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ProductDemo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		EntityManagerFactory entityManagerFactory = null;

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager=entityManagerFactory.createEntityManager();
			//transaction.

			System.out.println("Press 1: to show all the Items");
			System.out.println("Press 2: to Buy items");
			System.out.println("");

			int num;
			System.out.println("Choose Any one Options : ");

			num = sc.nextInt();

			switch (num) {
			case 1: 
				System.out.println("Show all the Items : ");
				Product_Info p=entityManager.find(Product_Info.class, 1);  // Entity class
				Product_Info p1=entityManager.find(Product_Info.class, 2); 

				Product_Info p3=entityManager.find(Product_Info.class, 3);

				System.out.println("--------------------------------");
				System.out.println("Product Id: "+p.getPId());
				System.out.println("Product Name: "+p.getPName());
				System.out.println("Product Cost: "+p.getPCost());
				System.out.println("Product Color: "+p.getPColor());
				System.out.println("Product Description: "+p.getDescription());
				System.out.println("--------------------------------");


				System.out.println("Product Id: "+p1.getPId());
				System.out.println("Product Name: "+p1.getPName());
				System.out.println("Product Cost: "+p1.getPCost());
				System.out.println("Product Color: "+p1.getPColor());
				System.out.println("Product Description: "+p1.getDescription());
				System.out.println("--------------------------------");

				System.out.println("Product Id: "+p3.getPId());
				System.out.println("Product Name: "+p3.getPName());
				System.out.println("Product Cost: "+p3.getPCost());
				System.out.println("Product Color: "+p3.getPColor());
				System.out.println("Product Description: "+p3.getDescription());
				System.out.println("--------------------------------");


				break;

			case 2: 

				int cardNum ;   
				String cvv ;

				String add;
				System.out.println("Buy Items : ");
				System.out.println("");
				System.out.println("Enter card number:  ");
				
				
				Pattern pat = Pattern.compile("\\d{16}"); 
				Matcher mat = pat.matcher(sc.next());  
				boolean b = mat.matches();
				System.out.println(b);

				System.out.println("Enter cvv: ");

				cvv=sc.next();
				Pattern pat1 = Pattern.compile("[A-Za-z]{1,3}\\s[A-Za-z]{1,3}"); 
				Matcher mat1 = pat1.matcher(cvv);  
			
				boolean b1 = mat1.matches();
				System.out.println(b1);

				System.out.println("Enter Address: ");
				add=sc.next();

				break;

			default:
				System.out.println("Invalid Options");
				break;


			}


		} catch (Exception e) {
			e.printStackTrace();


		}


	}

}
