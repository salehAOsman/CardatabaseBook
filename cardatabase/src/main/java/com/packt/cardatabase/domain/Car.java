package com.packt.cardatabase.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // after you write make save all
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String brand, model, color, registerNamber;
	private int year, price;
	
	//when we don't need getId and setId() and in constructor as parameter   
	
	public Car() {
	}
	public Car(String brand, String model, String color, String registerNamber, int year, int price) {
		super();
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registerNamber = registerNamber;
		this.year = year;
		this.price = price;
	}
	
	
@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", color=" + color + ", registerNamber="
				+ registerNamber + ", year=" + year + ", price=" + price + "]";
	}
//		public long getId() {
//		return id;
//	}
//after create this Entity class with cons_ and getter Setter now we add some info into application.properties to enabling the logging tables SQL to console
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getRegisterNamber() {
		return registerNamber;
	}
	public void setRegisterNamber(String registerNamber) {
		this.registerNamber = registerNamber;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
