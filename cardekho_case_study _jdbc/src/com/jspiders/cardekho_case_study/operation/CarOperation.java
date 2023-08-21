package com.jspiders.cardekho_case_study.operation;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import com.jspiders.cardekho_case_study.entity.Car;

public class CarOperation {
	private static Connection connection;
	private static PreparedStatement preparedStatement;

	private static int result;
	private static ResultSet resultSet;
	private static Properties properties = new Properties();
	private static FileInputStream file;
	private static String filePath = "D:\\WEJA2\\cardekho_case_study _jdbc\\resources\\db_info.properties";
	private static String query;

	Scanner s = new Scanner(System.in);

	public void addCar() {
	
		System.out.println("How many car details you want to add : ");
		int num = s.nextInt();

		try {
			
			openConnection();
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			query = "select * from car_dekho";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getInt(1));
			}
			System.out.println("Used Id : "+arrayList);
			query = "insert into car_dekho values(?,?,?,?,?,?)";

			preparedStatement = connection.prepareStatement(query);

			for (int i = 1; i <= num; i++) {
				
				System.out.println("\nEnter the " + i + " Car details : ");
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

				preparedStatement.setInt(1, c1.getCar_id());
				preparedStatement.setString(2, c1.getName());
				preparedStatement.setString(3, c1.getModel());
				preparedStatement.setString(4, c1.getBrand());
				preparedStatement.setString(5, c1.getFuel_type());
				preparedStatement.setDouble(6, c1.getPrice());

				result = result + preparedStatement.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			System.out.println("\n" + result + " Car Details Added in the Database!!");
			closeConnection();

		}

	}
	
	public void allCars() {

		try {
			openConnection();

			query = "select * from car_dekho";

			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			System.out.println("Car_ID  " + "Car_Name      " + "Car_Model      " + "Car_Brand     "
					+ "Car_FuelType     " + "Car_Price  \n"
					+ "==================================================================================");

			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t\t"
						+ resultSet.getString(3) + "\t\t" + resultSet.getString(4) + "\t\t" + resultSet.getString(5)
						+ "\t\t" + resultSet.getString(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	public void deleteCar() {
		
		try {
			allCars();
			
			openConnection();
			
			System.out.println("\nEnter Car_ID to delete the car details : ");
			int cid = s.nextInt();
			
			query = "delete from car_dekho where car_id = "+cid;

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
			System.out.println("\nCar details deleted...!!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	public void updateCarName() {

		try {

			allCars();
			openConnection();
			System.out.println("\nEnter Car_ID to update the car details : ");
			int cid = s.nextInt();
			System.out.println("Enter Car's New Name  :");
			String newValue = s.next();
			query = "update car_dekho set carName = ? where car_id = " + cid;

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, newValue);

			preparedStatement.executeUpdate();
			System.out.println("\nCar Name is updated.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	public void updateCarModel() {

		try {

			allCars();
			openConnection();
			System.out.println("\nEnter Car_ID to update the car details : ");
			int cid = s.nextInt();
			System.out.println("Enter Car's New Model  :");
			String newValue = s.next();
			query = "update car_dekho set carModel = ? where car_id = " + cid;

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, newValue);

			preparedStatement.executeUpdate();
			System.out.println("\nCar Model is updated.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
	
	public void updateCarBrand() {

		try {

			allCars();
			openConnection();
			System.out.println("\nEnter Car_ID to update the car details : ");
			int cid = s.nextInt();
			System.out.println("Enter Car's New Brand  :");
			String newValue = s.next();
			query = "update car_dekho set carBrand = ? where car_id = " + cid;

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, newValue);

			preparedStatement.executeUpdate();
			System.out.println("\nCar Brand is updated.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
		
	
	public void updateCarFuelType() {

		try {

			allCars();
			openConnection();
			System.out.println("\nEnter Car_ID to update the car details : ");
			int cid = s.nextInt();
			System.out.println("Enter Car's New FuelType  :");
			String newValue = s.next();
			query = "update car_dekho set FuelType = ? where car_id = " + cid;

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, newValue);

			preparedStatement.executeUpdate();
			System.out.println("\nCar FuelType is updated.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
	
	
	public void updateCarPrice() {

		try {

			allCars();
			openConnection();
			System.out.println("\nEnter Car_ID to update the car details : ");
			int cid = s.nextInt();
			System.out.println("Enter Car's New Price  :");
			Double newValue = s.nextDouble();
			query = "update car_dekho set FuelType = ? where car_id = " + cid;

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setDouble(1, newValue);

			preparedStatement.executeUpdate();
			System.out.println("\nCar Price is updated.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}


	public void searchCarId() {

		try {
			openConnection();
			System.out.println("Enter the Car Id : ");
			
			query = "select * from car_dekho where car_id = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, s.nextInt());
			
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("\nCar_ID  " + "Car_Name      " + "Car_Model      " + "Car_Brand     "
					+ "Car_FuelType     " + "Car_Price  \n"
					+ "==================================================================================");

			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t\t"
						+ resultSet.getString(3) + "\t\t" + resultSet.getString(4) + "\t\t" + resultSet.getString(5)
						+ "\t\t" + resultSet.getString(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}

	}
	
	public void searchName() {

		try {
			openConnection();
			System.out.println("Enter the Car Name : ");
			
			query = "select * from car_dekho where carName = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, s.next());
			
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("\nCar_ID  " + "Car_Name      " + "Car_Model      " + "Car_Brand     "
					+ "Car_FuelType     " + "Car_Price  \n"
					+ "==================================================================================");

			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t\t"
						+ resultSet.getString(3) + "\t\t" + resultSet.getString(4) + "\t\t" + resultSet.getString(5)
						+ "\t\t" + resultSet.getString(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}

	}
	
	public void searchBrand() {

		try {
			openConnection();
			System.out.println("Enter the Car Brand : ");
			
			query = "select * from car_dekho where carBrand = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, s.next());
			
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("\nCar_ID  " + "Car_Name      " + "Car_Model      " + "Car_Brand     "
					+ "Car_FuelType     " + "Car_Price  \n"
					+ "==================================================================================");

			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t\t"
						+ resultSet.getString(3) + "\t\t" + resultSet.getString(4) + "\t\t" + resultSet.getString(5)
						+ "\t\t" + resultSet.getString(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}

	}
	
	public void searchModel() {

		try {
			openConnection();
			System.out.println("Enter the Car Model : ");
			
			query = "select * from car_dekho where carModel = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, s.next());
			
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("\nCar_ID  " + "Car_Name      " + "Car_Model      " + "Car_Brand     "
					+ "Car_FuelType     " + "Car_Price  \n"
					+ "==================================================================================");

			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t\t"
						+ resultSet.getString(3) + "\t\t" + resultSet.getString(4) + "\t\t" + resultSet.getString(5)
						+ "\t\t" + resultSet.getString(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}

	}
	
	public void searchFuelType() {

		try {
			openConnection();
			System.out.println("Enter the Car FuelType : ");
			
			query = "select * from car_dekho where FuelType = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, s.next());
			
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("\nCar_ID  " + "Car_Name      " + "Car_Model      " + "Car_Brand     "
					+ "Car_FuelType     " + "Car_Price  \n"
					+ "==================================================================================");

			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t\t"
						+ resultSet.getString(3) + "\t\t" + resultSet.getString(4) + "\t\t" + resultSet.getString(5)
						+ "\t\t" + resultSet.getString(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}

	}
	
	public void searchPrice() {

		try {
			openConnection();

			query = "select * from car_dekho where Price between ? and ?";
			
			preparedStatement = connection.prepareStatement(query);
			System.out.println("Enter the lowest price : ");
			preparedStatement.setDouble(1, s.nextDouble());
			System.out.println("Enter the highest price");
			preparedStatement.setDouble(2, s.nextDouble());
			
			
			resultSet = preparedStatement.executeQuery();
			
			System.out.println("\nCar_ID  " + "Car_Name      " + "Car_Model      " + "Car_Brand     "
					+ "Car_FuelType     " + "Car_Price  \n"
					+ "==================================================================================");

			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t\t"
						+ resultSet.getString(3) + "\t\t" + resultSet.getString(4) + "\t\t" + resultSet.getString(5)
						+ "\t\t" + resultSet.getString(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}

	}
	
	private static void openConnection() {
		try {
			file = new FileInputStream(filePath);
			properties.load(file);

			Class.forName(properties.getProperty("driverPath"));

			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (file != null) {
				file.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (result != 0) {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet getCars() {
		try {
			openConnection();

			query = "select * from car_dekho";

			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

		} catch (Exception e) {

		} finally {
			closeConnection();
		}
		return resultSet;
	}

}
