// Created by Francisco
import java.util.ArrayList;

public class Restaurant {

    private String name;
    private double rating;
    private ArrayList<MenuItem> menuItems;

    //Default constructor
    public Restaurant() {
        this.name = "Unknown";
        this.rating = 0.0;
        this.menuItems = new ArrayList<>();
        
    }

    //Paramterized constructor
    public Restaurant(String name, double rating){
        this.name = name;
        this.rating = rating;
        this.menuItems = new ArrayList<>();
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    //Add a menu item to the restaurant
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    //toString Method
    public String toString() {
        return name + " (Rating: " + rating + ")";
    }
    
}
