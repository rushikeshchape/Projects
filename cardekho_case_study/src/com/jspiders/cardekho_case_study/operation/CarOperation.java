package com.jspiders.cardekho_case_study.operation;

import java.util.ArrayList;
import java.util.Scanner;

import com.jspiders.cardekho_case_study.entity.Car;

public class CarOperation
{
	ArrayList<Car> al = new ArrayList<Car>();
	Scanner s = new Scanner(System.in);
	
	public  void addCar() 
	{		
		System.out.println("How many car details you want to add : ");
		int num = s.nextInt();
		for(int i=1;i<=num;i++)
		{
			System.out.println("\nEnter the "+i+" Car details : ");
			Car c1 = new Car();
			
			System.out.println("Enter car id : ");
			c1.setCar_id(s.nextInt());
			System.out.println("Enter car name : ");
			c1.setName(s.next());
			System.out.println("Enter car model : ");
			c1.setModel(s.next());
			System.out.println("Enter car brand : ");
			c1.setBrand(s.next());
			System.out.println("Enter car fuel-type : ");
			c1.setFuel_type(s.next());
			System.out.println("Enter car price : ");
			c1.setPrice(s.nextDouble());
			
			al.add(c1);
			
		}
		System.out.println("\n"+num+" Cars Details Added Successfully!!\n\n");
		System.out.println("Car_ID  "+"Car_Name      "+"Car_Brand      "+"Car_Model      "+"Car_FuelType     "+"Car_Price  \n"
						+"==================================================================================");
		for(Car addedCar : al)
		{
			System.out.println(addedCar);
		}
		
	}
	
	
	public void allCars() 
	{
		if(al.isEmpty()==false)
		{
			System.out.println("Car_ID  "+"Car_Name      "+"Car_Brand      "+"Car_Model      "+"Car_FuelType     "+"Car_Price  \n"
					+"==================================================================================");
			for(Car i : al)
			{
				System.out.println(i);
			}
		}
		else
		{
			System.out.println("No Car Details Present!!");
		}
		
	}
	
	
	public void deleteCar() 
	{
		if(al.isEmpty()==false){
			allCars();
			System.out.println("Enter Car_ID to delete the car details : ");
			int cid = s.nextInt();
			
			for(Car i : al) 
			{
				
				if(i.getCar_id()==cid)
				{
					al.remove(i);
					System.out.println("Car ID "+i.getCar_id()+" Details Deleted!!!");
					break;
				}
			}
		}
		else
		{
			System.out.println("No Car Detail Present to Delete.");
		}
		
		
	}


	public void updateCar() 
	{
		
		if(al.isEmpty())
		{
			System.out.println("No Car Details Present to Update!!!");
		}
		else
		{
			allCars();
			System.out.print("Enter car_id to update details : ");
			int id = s.nextInt();
			for(Car i : al) 
			{
				if(i.getCar_id() == id)
				{
					System.out.print("Enter car name : ");
					i.setName(s.next());
					System.out.print("Enter car model : ");
					i.setModel(s.next());
					System.out.print("Enter car brand : ");
					i.setBrand(s.next());
					System.out.print("Enter car fuel-type : ");
					i.setFuel_type(s.next());;
					System.out.print("Enter car price : ");
					i.setPrice(s.nextDouble());

					System.out.println("Car Id "+i.getCar_id()+" Details Updated....");
					break;
				}
			}
		}
	}

	
	public void searchCarId() 
	{
		if(al.isEmpty())
		{
			System.out.println("No Car Details Present!!!");
		}
		else
		{
			System.out.print("Enter Car ID : ");
			int id = s.nextInt();
			System.out.println("Car_ID  "+"Car_Name      "+"Car_Brand      "+"Car_Model      "+"Car_FuelType     "+"Car_Price  \n"
					+"==================================================================================");
			for(Car i : al)
			{
				if(i.getCar_id() == id)
				{
					System.out.println(i);	
				}
			}
		}		
	}


	public void searchName() 
	{
		if(al.isEmpty())
		{
			System.out.println("No Car Details Present!!!");
		}
		else
		{
			System.out.print("Enter Car Name : ");
			String name = s.next();
			System.out.println("Car_ID  "+"Car_Name      "+"Car_Brand      "+"Car_Model      "+"Car_FuelType     "+"Car_Price  \n"
					+"==================================================================================");
			for(Car i : al)
			{
				if(i.getName().equalsIgnoreCase(name))
				{
					System.out.println(i);	
				}
			}
		}	
		
	}


	public void searchBrand()
	{
		if(al.isEmpty())
		{
			System.out.println("No Car Details Present!!!");
		}
		else
		{
			System.out.print("Enter Car Brand : ");
			String brand = s.next();
			System.out.println("Car_ID  "+"Car_Name      "+"Car_Brand      "+"Car_Model      "+"Car_FuelType     "+"Car_Price  \n"
					+"==================================================================================");
			for(Car i : al)
			{
				if(i.getBrand().equalsIgnoreCase(brand))
				{
					System.out.println(i);	
				}
			}
		}	
	}



	public void searchFuelType() {
		if(al.isEmpty())
		{
			System.out.println("No Car Details Present!!!");
		}
		else
		{
			System.out.print("Enter Car Fuel-Type : ");
			String fuel = s.next();
			System.out.println("Car_ID  "+"Car_Name      "+"Car_Brand      "+"Car_Model      "+"Car_FuelType     "+"Car_Price  \n"
					+"==================================================================================");
			for(Car i : al)
			{
				if(i.getFuel_type().equalsIgnoreCase(fuel))
				{
					System.out.println(i);	
				}				
			}
		}	
		
	}
	
	
}
