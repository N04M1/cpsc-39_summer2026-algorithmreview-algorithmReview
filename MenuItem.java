// Created by Mia
import java.util.ArrayList;

public class MenuItem {
    private String name;
    private String description;
    private double price;
    private ArrayList<Ingredient> ingredients;

    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.ingredients = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public ArrayList<Ingredient> getIngredients() { return ingredients; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(double price) { this.price = price; }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public int getTotalCalories() {
        int total = 0;
        for (int i = 0; i < ingredients.size(); i++) {
            total += ingredients.get(i).getCalories();
        }
        return total;
    }


    @Override
    public String toString() {
        return name + " | " + description + " | $" + price;
    }
}
    
  
