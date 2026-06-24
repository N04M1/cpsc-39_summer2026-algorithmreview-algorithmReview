/*
======================================================
Group Members:
Naomi Rodriguez
Francisco Gil Mendoza
Mia Aguilera
======================================================
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantSystem {

    public static void main(String[] args) {

        ArrayList<Restaurant> restaurants =
                new ArrayList<Restaurant>();

        try {

            File file = new File("restaurants.csv");

            Scanner input = new Scanner(file);

            // Skip header row
            input.nextLine();

            while (input.hasNextLine()) {

                String line = input.nextLine();

                // Split CSV row
                String[] parts = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                String restaurantName = parts[0];

                double rating =
                        Double.parseDouble(parts[1]);

                String menuItemName = parts[2];

                String description = parts[3];

                double price =
                        Double.parseDouble(parts[4]);

                String ingredientsText = parts[5];

                // Remove quotation marks
                ingredientsText =
                        ingredientsText.replace("\"", "");

                /*
                ==============================================
                Find or create Restaurant object
                ==============================================
                */

                Restaurant restaurant =
                        findRestaurant(restaurants,
                                restaurantName);

                if (restaurant == null) {

                    restaurant =
                            new Restaurant(
                                    restaurantName,
                                    rating);

                    restaurants.add(restaurant);
                }

                /*
                ==============================================
                Create MenuItem object
                ==============================================
                */

                MenuItem menuItem =
                        new MenuItem(
                                menuItemName,
                                description,
                                price);

                /*
                ==============================================
                Create Ingredient objects
                ==============================================
                */

                String[] ingredientParts =
                        ingredientsText.split(";");

                for (int i = 0;
                     i < ingredientParts.length;
                     i++) {

                    String ingredientData =
                            ingredientParts[i];

                    String[] ingredientInfo =
                            ingredientData.split(":");

                    String ingredientName =
                            ingredientInfo[0];

                    int calories =
                            Integer.parseInt(
                                    ingredientInfo[1]);

                    boolean allergen =
                            Boolean.parseBoolean(
                                    ingredientInfo[2]);

                    Ingredients ingredient =
                            new Ingredients(
                                    ingredientName,
                                    calories,
                                    allergen);

                    menuItem.addIngredient(
                            ingredient);
                }

                /*
                ==============================================
                Add MenuItem to Restaurant
                ==============================================
                */

                restaurant.addMenuItem(menuItem);
            }

            input.close();

        } catch (FileNotFoundException e) {

            System.out.println(
                    "File not found.");
        }

        /*
        ======================================================
        TEST OUTPUT
        ======================================================
        */

        for (int i = 0;
             i < restaurants.size();
             i++) {

            Restaurant restaurant =
                    restaurants.get(i);

            System.out.println(
                    "================================");

            System.out.println(
                    restaurant);

            ArrayList<MenuItem> menuItems =
                    restaurant.getMenuItems();

            for (int j = 0;
                 j < menuItems.size();
                 j++) {

                MenuItem item =
                        menuItems.get(j);

                System.out.println(item);

                ArrayList<Ingredients> ingredients =
                        item.getIngredients();

                for (int k = 0;
                     k < ingredients.size();
                     k++) {

                    System.out.println(
                            "   " +
                            ingredients.get(k));
                }
            }
        }
    //group work
		//Mia Aguilera 
        for (int i = 0; i < restaurants.size(); i++) {

            Restaurant r = restaurants.get(i);

            System.out.println("--- " + r.getName() + " ---");
            System.out.printf("Average Price: $%.2f%n", getAveragePrice(r));
            System.out.println("Highest-Priced: " + highestPricedItem(r).getName());
            System.out.println("Lowest-Priced: " + getLowestPricedItem(r).getName());
            System.out.printf("Average Calories: %.1f%n", averageCalories(r));
        }
            
    }

    public static double getAveragePrice(Restaurant restaurant) {
            ArrayList<MenuItem> items = restaurant.getMenuItems();
            double total = 0; 
            for (int i = 0; i < items.size(); i++) {
                total += items.get(i).getPrice();
            }
             return total / items.size();
    }
    
    public static MenuItem highestPricedItem(Restaurant restaurant) {
            ArrayList<MenuItem> items = restaurant.getMenuItems();
            MenuItem highest = items.get(0);
            for (int i = 1; i < items.size(); i++) {
                if (items.get(i).getPrice() > highest.getPrice()) {
                    highest = items.get(i);
                }
            }
             return highest;
    }

    //Created by Francisco
    public static MenuItem getLowestPricedItem(Restaurant restaurant) {

    ArrayList<MenuItem> items = restaurant.getMenuItems();

    if (items.size() == 0) {
        return null; // no menu items
    }

    MenuItem lowest = items.get(0);

    for (int i = 1; i < items.size(); i++) {
        if (items.get(i).getPrice() < lowest.getPrice()) {
            lowest = items.get(i);
        }
    }

    return lowest;
}

//METHOD AVERAGE CALORIES
    public static double averageCalories(Restaurant restaurant) {

	ArrayList<MenuItem> menuItems =
		restaurant.getMenuItems();

	if (menuItems.size() == 0) {
		return 0;
	}

	int totalCalories = 0;

	for (MenuItem item : menuItems) {
		totalCalories += item.getTotalCalories();
	}

	return (double) totalCalories / menuItems.size();
      }

  
    /*
    ======================================================
    Find Restaurant Method
    ======================================================
    */

    public static Restaurant findRestaurant(
            ArrayList<Restaurant> restaurants,
            String name) {

        for (int i = 0;
             i < restaurants.size();
             i++) {

            if (restaurants.get(i)
                    .getName()
                    .equals(name)) {

                return restaurants.get(i);
            }
        }

        return null;
    }
}

