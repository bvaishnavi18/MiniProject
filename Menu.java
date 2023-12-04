package com.miniproject;


public class Menu {

    private int id;
    private String name;
    private double price;

    
    Menu(int id, String name, double price ){
    	super();
    	this.id= id;
    	this.name= name;
    	this.price= price;
    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
    
    // Constructors, getters, setters, and toString method

}