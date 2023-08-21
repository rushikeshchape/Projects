package com.jspiders.cardekho_case_study_hibernate.dao;

import java.util.Scanner;



public class CarMain {
	static boolean flag = true;
	CarOperation operation = new CarOperation();
	
	Scanner s = new Scanner(System.in);
	public static void main(String[] args) 
	{
		CarMain main = new CarMain();
		while(flag) 
		{
			main.menu();
		}
	}
	
	public void menu() 
	{
		
		System.out.println("\n*******************MENU*******************");
		System.out.println("1. Add Car Details.\n"
				+ "2. Search Car Details.\n"
				+ "3. Update Car Details.\n"
				+ "4. Delete Car Details.\n"
				+ "5. Show all Cars.\n"
				+ "6. Exit.\n");
				
		System.out.print("Enter your choice : ");
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			operation.addCar();
			break;
		case 2:
			System.out.println("1. Search by Car_ID\n"
					+ "2. Search by Car Name\n"
					+ "3. Search by Car Model\n"
					+ "4. Search by Car Brand\n"
					+ "5. Search by Car Fuel-Type\n"
					+ "6. Go Back\n");
			System.out.print("Enter your choice : ");
			int option = s.nextInt();
			switch (option) {
			case 1:
				operation.searchCarId();
				break;
			case 2:
				operation.searchName();
				break;
			case 3:
				operation.searchModel();
				break;
			case 4:
				operation.searchBrand();
				break;
			case 5:
				operation.searchFuelType();
				break;
			case 6:
				menu();
				break;
			default:
				System.out.println("Invalid Option!! Try Again");
				break;
			}
			break;
		case 3:
			System.out.println("1. Update Car Name\n"
					+ "2. Update Car Model\n"
					+ "3. Update Car Brand\n"
					+ "4. Update Car Fuel-Type\n"
					+ "5. Update Car Price\n");
			System.out.print("Enter your choice : ");
			int option1 = s.nextInt();
			switch (option1) {
			case 1:
				operation.updateCarName();
				break;
			case 2:
				operation.updateCarModel();
				break;
			case 3:
				operation.updateCarBrand();	
				break;
			case 4:
				operation.updateCarFuelType();
				break;
			case 5 :
				operation.updateCarPrice();
				break;
			default:
				System.out.println("Invalid Option!! Try Again...");
				break;
			}
			break;
		case 4:
			operation.deleteCar();
			break;
		case 5:
			operation.allCars();
			break;
		case 6 :
			flag=false;
			break;
		default:
			System.out.println("Invalid Option!! Try Again...");
			break;
		}

	}
}
