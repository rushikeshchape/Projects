package com.jspiders.cardekho_case_study_hibernate.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.cardekho_case_study_hibernate.dto.CarDekhoDTO;

public class CarOperation {
	
	Scanner s = new Scanner(System.in);
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	private static void openConnection() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("alpha");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	
	public void addCar() {
		openConnection();
		entityTransaction.begin();
		
		System.out.println("How many car details you want to add : ");
		int num = s.nextInt();
		
		for (int i = 1; i <= num; i++) {
			
			System.out.println("\nEnter the " + i + " Car details : ");
			CarDekhoDTO car = new CarDekhoDTO();
			
			
			System.out.println("Enter car id : ");
			car.setId(s.nextInt());
			System.out.println("Enter car name : ");
			car.setName(s.next());
			System.out.println("Enter car model : ");
			car.setModel(s.next());
			System.out.println("Enter car brand : ");
			car.setBrand(s.next());
			System.out.println("Enter car fuel-type : ");
			car.setFuelType(s.next());
			System.out.println("Enter car price : ");
			car.setPrice(s.nextDouble());
			
			entityManager.persist(car);
			
			
			
		}	
		System.out.println(num+ " car details added...!!!");
		entityTransaction.commit();
		closeConnection();	
	}

	public void deleteCar() {
		allCars();
		openConnection();
		entityTransaction.begin();
		System.out.println("\nEnter Car_ID to delete the car details : ");
		int cid = s.nextInt();
		CarDekhoDTO car = entityManager.find(CarDekhoDTO.class, cid);
		
		entityManager.remove(car);
		System.out.println("Car with ID  : "+cid+" is deleted...!!!");
		entityTransaction.commit();
		closeConnection();
		
	}

	public void allCars() {
		
		openConnection();
		entityTransaction.begin();
		
		Query query = entityManager.createQuery("SELECT c from CarDekhoDTO c");
		@SuppressWarnings("unchecked")
		List<CarDekhoDTO> car = query.getResultList();
		if (car.isEmpty()) {
			System.out.println("No record found..!!!");
		}
		else {
			for(CarDekhoDTO ele : car) {
				System.out.println(ele);
			}
		}
		
		entityTransaction.commit();
		closeConnection();
	}

	public void updateCarName() {
		allCars();
		openConnection();
		entityTransaction.begin();
		System.out.println("\nEnter Car_ID to update the car details : ");
		int cid = s.nextInt();
		CarDekhoDTO car = entityManager.find(CarDekhoDTO.class, cid);
		
		System.out.println("Enter Car's New Name  :");
		car.setName(s.next());
		entityManager.persist(car);
		
		System.out.println("Car Name Updated...!!!");
		
		entityTransaction.commit();
		closeConnection();
	}

	public void updateCarModel() {
		allCars();
		openConnection();
		entityTransaction.begin();
		System.out.println("\nEnter Car_ID to update the car details : ");
		int cid = s.nextInt();
		CarDekhoDTO car = entityManager.find(CarDekhoDTO.class, cid);
		
		System.out.println("Enter Car's New Model  :");
		car.setModel(s.next());
		entityManager.persist(car);
		
		System.out.println("Car Model Updated...!!!");
		
		entityTransaction.commit();
		closeConnection();
		
	}

	public void updateCarBrand() {
		allCars();
		openConnection();
		entityTransaction.begin();
		System.out.println("\nEnter Car_ID to update the car details : ");
		int cid = s.nextInt();
		CarDekhoDTO car = entityManager.find(CarDekhoDTO.class, cid);
		
		System.out.println("Enter Car's New Brand  :");
		car.setBrand(s.next());
		entityManager.persist(car);
		
		System.out.println("Car Brand Updated...!!!");
		
		entityTransaction.commit();
		closeConnection();
		
	}

	public void updateCarFuelType() {
		allCars();
		openConnection();
		entityTransaction.begin();
		System.out.println("\nEnter Car_ID to update the car details : ");
		int cid = s.nextInt();
		CarDekhoDTO car = entityManager.find(CarDekhoDTO.class, cid);
		
		System.out.println("Enter Car's New FuelType  :");
		car.setFuelType(s.next());
		entityManager.persist(car);
		
		System.out.println("Car FuelType Updated...!!!");
		
		entityTransaction.commit();
		closeConnection();
		
	}

	public void updateCarPrice() {
		allCars();
		openConnection();
		entityTransaction.begin();
		System.out.println("\nEnter Car_ID to update the car details : ");
		int cid = s.nextInt();
		CarDekhoDTO car = entityManager.find(CarDekhoDTO.class, cid);
		
		System.out.println("Enter Car's New Price  :");
		car.setPrice(s.nextDouble());
		entityManager.persist(car);
		
		System.out.println("Car Price Updated...!!!");
		
		entityTransaction.commit();
		closeConnection();
		
	}

	public void searchCarId() {
		
		openConnection();
		entityTransaction.begin();

		System.out.println("Enter the Car Id : ");
		int cid = s.nextInt();
		
		Query query = entityManager.createQuery("SELECT c from CarDekhoDTO c where c.id = :cid");
		query.setParameter("cid", cid);
		@SuppressWarnings("unchecked")
		List<CarDekhoDTO> car = query.getResultList();
		if (car.isEmpty()) {
			System.out.println("No record found..!!!");
		}
		else {
			for(CarDekhoDTO ele : car) {
				System.out.println(ele);
			}
		}	
	}

	public void searchName() {
		openConnection();
		entityTransaction.begin();

		System.out.println("Enter the Car Name : ");
		String carName = s.next();
		
		Query query = entityManager.createQuery("SELECT c from CarDekhoDTO c where c.name = :carName");
		query.setParameter("carName", carName);
		@SuppressWarnings("unchecked")
		List<CarDekhoDTO> car = query.getResultList();
		if (car.isEmpty()) {
			System.out.println("No record found..!!!");
		}
		else {
			for(CarDekhoDTO ele : car) {
				System.out.println(ele);
			}
		}		
	}

	public void searchModel() {
		openConnection();
		entityTransaction.begin();

		System.out.println("Enter the Car Model : ");
		String carModel = s.next();
		
		Query query = entityManager.createQuery("SELECT c from CarDekhoDTO c where c.model = :carModel");
		query.setParameter("carModel", carModel);
		@SuppressWarnings("unchecked")
		List<CarDekhoDTO> car = query.getResultList();
		if (car.isEmpty()) {
			System.out.println("No record found..!!!");
		}
		else {
			for(CarDekhoDTO ele : car) {
				System.out.println(ele);
			}
		}	
	}

	public void searchBrand() {
		openConnection();
		entityTransaction.begin();

		System.out.println("Enter the Car Brand : ");
		String carBrand = s.next();
		
		Query query = entityManager.createQuery("SELECT c from CarDekhoDTO c where c.brand = :carBrand");
		query.setParameter("carBrand", carBrand);
		@SuppressWarnings("unchecked")
		List<CarDekhoDTO> car = query.getResultList();
		if (car.isEmpty()) {
			System.out.println("No record found..!!!");
		}
		else {
			for(CarDekhoDTO ele : car) {
				System.out.println(ele);
			}
		}
	}

	public void searchFuelType() {
		openConnection();
		entityTransaction.begin();

		System.out.println("Enter the Car FuelType : ");
		String carFuelType = s.next();
		
		Query query = entityManager.createQuery("SELECT c from CarDekhoDTO c where c.fuelType = :carFuelType");
		query.setParameter("carFuelType", carFuelType);
		@SuppressWarnings("unchecked")
		List<CarDekhoDTO> car = query.getResultList();
		if (car.isEmpty()) {
			System.out.println("No record found..!!!");
		}
		else {
			for(CarDekhoDTO ele : car) {
				System.out.println(ele);
			}
		}
	}
}
