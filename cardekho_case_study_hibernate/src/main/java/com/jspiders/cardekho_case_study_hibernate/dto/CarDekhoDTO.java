package com.jspiders.cardekho_case_study_hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class CarDekhoDTO {
	@Id
	private int id;
	private String name;
	private String model;
	private String brand;
	private String fuelType;
	private double price;
	
	
	@Override
	public String toString() {
		return " [id=" + id + "||  name=" + name + "||  model=" + model + "||  brand=" + brand + "||  fuelType="
				+ fuelType + "||  price=" + price + "]";
	}
	
	
}
