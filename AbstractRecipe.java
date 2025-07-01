package com.mycompany.recipeappgui;
import java.util.ArrayList;
public abstract class AbstractRecipe {
    // Fields
    protected String name;                      
    protected ArrayList<Ingredient> ingredients;
    protected int prepTime;       
    // Constructor to set the recipe name and initialize the ingredients list
    public AbstractRecipe(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
        this.prepTime = 0; // Default preparation time
    }
    // Getter for recipe name
    public String getName() {
        return name;
    }
    // Getter for preparation time
    public int getPrepTime() {
        return prepTime;
    }
    // Getter for list of ingredients
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
    // Method to add an ingredient to the list
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        // Update the preparation time: assume each ingredient adds 5 minutes
        prepTime = ingredients.size() * 5;
    }
    // Abstract method: child classes must provide their own implementation
    public abstract String displayRecipe();
}
