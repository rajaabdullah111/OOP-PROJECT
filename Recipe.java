package com.mycompany.recipeappgui;

public class Recipe extends AbstractRecipe {
    // Constructor that sets the name of the recipe
    public Recipe(String name) {
        super(name);  // Calls the constructor of AbstractRecipe
    }
    // Method to display the recipe details
   @Override
public String displayRecipe() {
    StringBuilder sb = new StringBuilder();
    sb.append("Recipe: ").append(getName()).append("\n");

    sb.append("Ingredients:\n");
    for (Ingredient i : getIngredients()) {
        sb.append(" ").append(i.toString()).append("\n");
    }

    sb.append("Preparation Time: ").append(getPrepTime()).append(" minutes\n");

    return sb.toString();
}
}
