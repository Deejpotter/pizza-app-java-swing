package com.test;

public class Pizza {

	private String size = "", wholePizza = ""; // small, medium, large
	public Boolean hasHam, hasSalami, hasChocolate, hasPrawns, hasPineapple, hasOlives, hasCapsicum, hasMushroom;
	public double cost = 0, smallPrice = 4, mediumPrice = 6, largePrice = 8, hamPrice = 1.5, salamiPrice = 1.5,
			chocolatePrice = 1.5, prawnsPrice = 1.5, pineapplePrice = .5, olivesPrice = .5, capsicumPrice = .5,
			mushroomPrice = .5;

	public Pizza(String size) {
		this.setSize(size);
		this.hasHam = false;
		this.hasSalami = false;
		this.hasChocolate = false;
		this.hasPrawns = false;
		this.hasPineapple = false;
		this.hasOlives = false;
		this.hasCapsicum = false;
		this.hasMushroom = false;
	}

	public Pizza(String size, Boolean hasHam, Boolean hasSalami, Boolean hasChocolate, Boolean hasPrawns,
			Boolean hasPineapple, Boolean hasOlives, Boolean hasCapsicum, Boolean hasMushroom) {
		this.setSize(size);
		this.hasHam = hasHam;
		this.hasSalami = hasSalami;
		this.hasChocolate = hasChocolate;
		this.hasPrawns = hasPrawns;
		this.hasPineapple = hasPineapple;
		this.hasOlives = hasOlives;
		this.hasCapsicum = hasCapsicum;
		this.hasMushroom = hasMushroom;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void addCost(double cost) {
		this.cost += cost;
	}

	// Once the variables are set this will return the whole pizza as a string
	public String calculatePizza() {

		// Start with a blank string
		wholePizza = "";

		// Check the size
		if (size == "small") {
			addCost(smallPrice);
			wholePizza = wholePizza.concat("Small cheese pizza \n");
		} else if (size == "medium") {
			addCost(mediumPrice);
			wholePizza = wholePizza.concat("Meduim cheese pizza \n");
		} else if (size == "large") {
			addCost(largePrice);
			wholePizza = wholePizza.concat("Large cheese pizza \n");
		} else {
			return "PROBLEM";
		}

		// Check the toppings
		if (hasHam) {
			addCost(hamPrice);
			wholePizza = wholePizza.concat("+ Ham \n");
		}
		if (hasSalami) {
			addCost(salamiPrice);
			wholePizza = wholePizza.concat("+ Salami \n");
		}
		if (hasChocolate) {
			addCost(chocolatePrice);
			wholePizza = wholePizza.concat("+ Chocolate \n");
		}
		if (hasPrawns) {
			addCost(prawnsPrice);
			wholePizza = wholePizza.concat("+ Prawns \n");
		}
		if (hasPineapple) {
			addCost(pineapplePrice);
			wholePizza = wholePizza.concat("+ Pineapple \n");
		}
		if (hasOlives) {
			addCost(olivesPrice);
			wholePizza = wholePizza.concat("+ Olives \n");
		}
		if (hasCapsicum) {
			addCost(capsicumPrice);
			wholePizza = wholePizza.concat("+ Capsicum \n");
		}
		if (hasMushroom) {
			addCost(mushroomPrice);
			wholePizza = wholePizza.concat("+ Mushroom \n");
		}

		// Calculate final cost and return the string
		wholePizza = wholePizza.concat("+ $" + String.format("%.2f", getCost()) + "\n\n");
		return wholePizza;
	}

}
