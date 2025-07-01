package com.mycompany.recipeappgui;
public class Ingredient {
    // Fields (also called instance variables)
    private String name;
    private int quantity;
    private String unit;
    // Constructor to initialize the ingredient
    public Ingredient(String name, int quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }
    // Getter method for the name
    public String getName() {
        return name; // Return name as it is (not converted to lowercase)
    }
    // Getter method for the quantity
    public int getQuantity() {
        return quantity;
    }
    // Getter method for the unit
    public String getUnit() {
        return unit;
    }
    // A method to return a readable string representation of the ingredient
    @Override
    public String toString() {
        return name + " - " + quantity + " " + unit;
    }}
