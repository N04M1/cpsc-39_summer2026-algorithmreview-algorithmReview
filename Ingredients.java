//Created by Naomi Rodriguez

public class Ingredients {
    
    private String name;
    private int Calories;
    private boolean allergen;

    //Default Constructor
    public Ingredients(){
        name = "Unknown";
        Calories = 0;
        allergen = false;
    }

    //Parameterized Constructor
    public Ingredients(String name, int Calories, boolean allergen){
        this.name = name;
        this.Calories = 0;
        this.allergen = allergen;
    }   
    

    //Getters and setters

    //NAME
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    //CALORIES
    public int getCalories(){
        return Calories;
    }

    public void setCalories(int Calories){
        this.Calories = Calories;
    }


    //ALLERGENS
    public boolean getAllergen(){
        return allergen;
    }

    public void setAllergen(boolean allergen){
        if(!allergen){
            this.allergen = allergen;
        }
        
    }

     public String toString() {
        return "ingredient{name = '" + name + "', allergen = " + allergen + ", calories = '" + Calories + "'}";
    }
}
