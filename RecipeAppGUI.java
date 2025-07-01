package com.mycompany.recipeappgui;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;
public class RecipeAppGUI extends JFrame {
    private RecipeManager manager = new RecipeManager();
    public RecipeAppGUI() {
        setTitle("Recipe Suggestion App");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));
        // Create buttons
        JButton addBtn = new JButton("Add Recipe");
        JButton viewBtn = new JButton("View All Recipes");
        JButton searchBtn = new JButton("Search Recipe");
        JButton suggestBtn = new JButton("Suggest Recipes");
        JButton exitBtn = new JButton("Exit");
        // Add actions
        addBtn.addActionListener(e -> addRecipe());
        viewBtn.addActionListener(e -> displayAllRecipes());
        searchBtn.addActionListener(e -> searchRecipe());
        suggestBtn.addActionListener(e -> suggestRecipes());
        exitBtn.addActionListener(e -> System.exit(0));
        // Add buttons to the GUI
        add(addBtn);
        add(viewBtn);
        add(searchBtn);
        add(suggestBtn);
        add(exitBtn);
    }
    // Add a new recipe
    private void addRecipe() {
        String name = JOptionPane.showInputDialog("Enter recipe name:");
        if (name == null || name.trim().isEmpty()) return;
        Recipe recipe = new Recipe(name.trim());
        try {
            int numIngredients = Integer.parseInt(JOptionPane.showInputDialog("How many ingredients?"));
            for (int i = 0; i < numIngredients; i++) {
                String iname = JOptionPane.showInputDialog("Ingredient " + (i + 1) + " name:");
                int qty = Integer.parseInt(JOptionPane.showInputDialog("Quantity:"));
                String unit = JOptionPane.showInputDialog("Unit:");
                recipe.addIngredient(new Ingredient(iname, qty, unit));
            }
            manager.addRecipe(recipe);
            JOptionPane.showMessageDialog(this, "Recipe added!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
        }
    }
    // Display all recipes
    private void displayAllRecipes() {
        ArrayList<Recipe> recipes = manager.getAllRecipes();
        if (recipes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No recipes available.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Recipe r : recipes) {
            sb.append(r.displayRecipe());
            sb.append("\n-------------------\n");
        }
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        JOptionPane.showMessageDialog(this, scrollPane, "All Recipes", JOptionPane.INFORMATION_MESSAGE);
    }
    // Search for a recipe by name
    private void searchRecipe() {
        String name = JOptionPane.showInputDialog("Enter recipe name to search:");
        if (name == null || name.trim().isEmpty()) return;
        Recipe r = manager.searchByName(name.trim());
        if (r != null) {
            JOptionPane.showMessageDialog(this, r.displayRecipe());
        } else {
            JOptionPane.showMessageDialog(this, "Recipe not found.");
        }
    }
    // Suggest recipes based on available ingredients
    private void suggestRecipes() {
        try {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Number of available ingredients:"));
            ArrayList<String> available = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String ingredient = JOptionPane.showInputDialog("Ingredient " + (i + 1) + ":");
                if (ingredient != null && !ingredient.trim().isEmpty()) {
                    available.add(ingredient.toLowerCase(Locale.ROOT).trim());
                }}
            ArrayList<Recipe> suggestions = manager.suggestRecipes(available);
            if (suggestions.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No recipe suggestions found.");
            } else {
                StringBuilder sb = new StringBuilder("Recipes you can make:\n\n");
                for (Recipe r : suggestions) {
                    sb.append(r.displayRecipe());
                    sb.append("\n-------------------\n");
                }
                JTextArea textArea = new JTextArea(sb.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 300));
                JOptionPane.showMessageDialog(this, scrollPane, "Suggested Recipes", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        } }
    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RecipeAppGUI gui = new RecipeAppGUI();
            gui.setVisible(true);
        });
  }}
