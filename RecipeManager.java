package com.mycompany.recipeappgui;
import java.util.ArrayList;
// This class manages a list of recipes: adding, searching, and suggesting them
public class RecipeManager {
    // A list to store all recipes
    private ArrayList<Recipe> recipes = new ArrayList<>();
    // Method to add a new recipe to the list
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
    // Method to get all the recipes
    public ArrayList<Recipe> getAllRecipes() {
        return recipes;
    }
    // Method to search for a recipe by name (case insensitive)
    public Recipe searchByName(String name) {
        for (Recipe r : recipes) {
            if (r.getName().equalsIgnoreCase(name)) {
                return r;
            }
        }
        return null; // return null if recipe not found
    }
    // Method to suggest recipes based on the available ingredients
    public ArrayList<Recipe> suggestRecipes(ArrayList<String> availableIngredients) {
        ArrayList<Recipe> suggestions = new ArrayList<>();
        // Check each recipe to see if it can be made with available ingredients
        for (Recipe recipe : recipes) {
            boolean canMake = true;
            // Check each ingredient in the recipe
            for (Ingredient i : recipe.getIngredients()) {
                // If any required ingredient is not in the list, can't make it
                if (!availableIngredients.contains(i.getName())) {
                    canMake = false;
                    break;
                }
            }
            // If all ingredients are available, suggest the recipe
            if (canMake) {
                suggestions.add(recipe);
            }
        }
        return suggestions;
    }
}
