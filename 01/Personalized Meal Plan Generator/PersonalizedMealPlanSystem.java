import java.util.*;

interface MealPlan{
    String getMealType();
    String getDescription();
}

class VegMeal implements MealPlan{
    public String getMealType(){
        return "Vegetarian";
    }
    @Override
    public String getDescription() {
        return "Includes vegetables, grains, dairy, and legumes.";
    }
}

class VeganMeal implements MealPlan{
    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public String getDescription() {
        return "Excludes all animal products.";
    }
}

class KetoMeal implements MealPlan{
    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public String getDescription() {
        return "Low carbs, high fat meals for ketosis.";
    }
}

class HighProteinMeal implements MealPlan{
    @Override
    public String getMealType() {
        return "High-Protein";
    }

    @Override
    public String getDescription() {
        return "Protein rich meals, ideal for muscle gain.";
    }
}

class Meal<T extends MealPlan>{
    private List<T> mealOptions = new ArrayList<>();
    public void addMeal(T meal){
        mealOptions.add(meal);
    }
    public List<T> getMeal(){
        return mealOptions;
    }
}

class MealPlanner{
    public static <T extends MealPlan> void generatePlan(Meal<T> meal) {
        for (T m : meal.getMeal()) {
            System.out.println(m.getMealType() + " - " + m.getDescription());
        }
    }
}

// Main class
public class PersonalizedMealPlanSystem{
    public static void main(String[] args) {
        Meal<VeganMeal> veganPlan = new Meal<>();
        veganPlan.addMeal(new VeganMeal());

        Meal<KetoMeal> ketoPlan = new Meal<>();
        ketoPlan.addMeal(new KetoMeal());

        Meal<VegMeal> vegPlan = new Meal<>();
        vegPlan.addMeal(new VegMeal());

        Meal<HighProteinMeal> proteinPlan = new Meal<>();
        proteinPlan.addMeal(new HighProteinMeal());

        System.out.println("Vegan Plan:");
        MealPlanner.generatePlan(veganPlan);

        System.out.println("\nKeto Plan:");
        MealPlanner.generatePlan(ketoPlan);

        System.out.println("\nVegetarian Plan:");
        MealPlanner.generatePlan(vegPlan);

        System.out.println("\nHigh Protein Plan:");
        MealPlanner.generatePlan(proteinPlan);
    }
}
