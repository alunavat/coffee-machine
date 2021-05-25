package com.dunzo.application.coffeemachine;

import com.dunzo.application.coffeemachine.utility.AppConstants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory{
    // Inventory keeps track of available Ingredient quantities
    private static Map<String, Integer> inventoryMap = new HashMap<>();
    final List<String> ingredientsList = Arrays.asList(
            AppConstants.MILK, AppConstants.WATER, AppConstants.GINGER_SYRUP,
            AppConstants.TEA_LEAVES_SYRUP, AppConstants.COFFEE_SYRUP,
            AppConstants.ELAICHI_SYRUP, AppConstants.SUGAR_SYRUP
    );

    // Constructor initialises the inventory to default settings.
    public Inventory() {
        for(String item : ingredientsList){
            if(item.equals(AppConstants.WATER)){
                inventoryMap.put(item, AppConstants.REFILL_AMOUNT_WATER);
            }
            else {
                inventoryMap.put(item, AppConstants.REFILL_AMOUNT);
            }
        }
    }

    // The method will be used to refill any ingredient in our inventory.
    public void refillIngredient(String refillIngredient){
        int refillAmount = AppConstants.REFILL_AMOUNT;
        if (refillIngredient.equals(AppConstants.WATER)){
            refillAmount = AppConstants.REFILL_AMOUNT_WATER;
        }
        inventoryMap.put(refillIngredient, inventoryMap.getOrDefault(refillIngredient,0) + refillAmount);
    }

    // Checking the inventory to ensure a beverage can be served.
    // Beverage is dispensed only if all ingredients are found and in required quantity.
    public synchronized void checkInInventory(Map<String,Integer> ingredients) throws Exception {
        for (String ingredient : ingredients.keySet()) {
            if (!inventoryMap.containsKey(ingredient))
                throw new Exception(ingredient + AppConstants.INGREDIENT_UNAVAILABLE_EXCEPTION);
            else if (getIngredientQuantity(ingredient) < ingredients.get(ingredient))
                throw new Exception(ingredient + AppConstants.INGREDIENT_INSUFFICIENT_EXCEPTION);
        }
        updateInventoryOnDispense(ingredients);
    }

    // If the beverage has been dispensed, we can update ingredient quantities.
    // This method will also alert if an ingredient is running low.
    public void updateInventoryOnDispense(Map<String,Integer> ingredients){
        for (String ingredient : ingredients.keySet()){
            inventoryMap.put(ingredient, getIngredientQuantity(ingredient) - ingredients.get(ingredient));
            if(getIngredientQuantity(ingredient) <= AppConstants.ALERT_AMOUNT){
                alertLowQuantity(ingredient);
            }
        }
    }

    public void alertLowQuantity(String ingredient){
        System.out.println("ALERT -- " + ingredient + " is running low. Please refill to avoid inconvenience");
    }

    public int getIngredientQuantity(String ingredient){
        return inventoryMap.getOrDefault(ingredient,0);
    }
}
