// Created by Mia
public class Ingredient {

    private String name;
    private int calories;
    private boolean allergen;

    public Ingredient(String name, int calories, boolean allergen) {
        this.name = name;
        this.calories = calories;
        this.allergen = allergen;
    }

    public String get Name() { return name; }
    public int getCalories() { reture calories; }
    public boolean getAllergen() { return allergen; }

    public void setName(String name) {this.name = name:}
    public void setCalories (int csalories) {this.caloeies = calories;}
    public void setallergen(boolean allergen) {this.allergen = allergen;}

    @Override
    public String toString() {
        return nam + " | Calories: " + calories + " | Allergen: " + allergen;
    }
}
  
