//Created by Naomi Rodriguez

public class ingredients {
    
    private String name;
    private int calories;
    private boolean allergen;

    //Default Constructor
    public ingredients(){
        name = "Unknown";
        calories = 0;
        allergen = false;
    }

    //Parameterized Constructor
    public ingredients(String name, int calories, boolean allergen)
        this.name = name;
        this.calories = 0;
        this.allergen = allergen;
    }   
    

    //Getters and setters

    //NAME
    public String getName(){
        return name;
    }

    public Void setName(String name){
        this.name = name;
    }


    //CALORIES
    public int getCalories(){
        return calories;
    }

    public Void setCalories(int calories){
        this.calorie = calorie;
    }


    //ALLERGENS
    public boolean getAllergen(){
        return allergen;
    }

    public Void setAllergen(boolean allergen){
        if(!allergen){
            this.allergen = name;
        }
        
    }

     public String toString() {
        return "ingredient{name = '" + name + "', allergen = " + allergen + ", calories = '" + caorie + "'}";
    }
}