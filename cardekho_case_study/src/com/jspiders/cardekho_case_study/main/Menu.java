package com.jspiders.cardekho_case_study.main;

import java.util.Scanner;

import com.jspiders.cardekho_case_study.operation.CarOperation;

public class Menu {
	static boolean flag = true;
	CarOperation operation = new CarOperation();
	
	Scanner s = new Scanner(System.in);
	public static void main(String[] args) 
	{
		Menu main = new Menu();
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
					+ "3. Search by Car Brand\n"
					+ "4. Search by Car Fuel-Type\n"
					+ "5. Go Back\n");
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
				operation.searchBrand();
				break;
			case 4:
				operation.searchFuelType();
				break;
			case 5:
				menu();
				break;
			default:
				System.out.println("Invalid Option!! Try Again");
				break;
			}
			break;
		case 3:
			
			operation.updateCar();	
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
