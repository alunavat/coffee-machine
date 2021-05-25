package com.dunzo.application.coffeemachine;

import com.dunzo.application.coffeemachine.utility.Constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory{
    // Inventory keeps track of available Ingredient quantities
    private static Map<String, Integer> inventoryMap = new HashMap<>();

    final List<String> ingredientsList = Arrays.asList(
            Constants.MILK,Constants.WATER,Constants.GINGER_SYRUP,
            Constants.TEA_LEAVES_SYRUP,Constants.COFFEE_SYRUP,
            Constants.ELAICHI_SYRUP,Constants.SUGAR_SYRUP
    );

    // This is invoked when the machine is first started and fills the inventory to default settings.
    public Inventory() {
        for(String item : ingredientsList){
            if(item.equals(Constants.WATER)){
                this.inventoryMap.put(item,Constants.REFILL_AMOUNT_WATER);
            }
            else {
                this.inventoryMap.put(item, Constants.REFILL_AMOUNT);
            }
        }
    }

    // This method will allow for the inventory to be refilled.
    public void refillIngredient(String refillIngredient){
        int refillAmount = Constants.REFILL_AMOUNT;
        if (refillIngredient.equals(Constants.WATER)){
            refillAmount = Constants.REFILL_AMOUNT_WATER;
        }
        inventoryMap.put(refillIngredient, inventoryMap.getOrDefault(refillIngredient,0) + refillAmount);
    }

    // checking the inventory to ensure a beverage can be served.
    public synchronized void checkInInventory(Map<String,Integer> ingredients) throws Exception {
        for (String ingredient : ingredients.keySet()) {
            if (!inventoryMap.containsKey(ingredient))
                throw new Exception(ingredient + Constants.INGREDIENT_UNAVAILABLE_EXCEPTION);
            else if (getIngredientQuantity(ingredient) < ingredients.get(ingredient))
                throw new Exception(ingredient + Constants.INGREDIENT_INSUFFICIENT_EXCEPTION);
        }
        updateInventoryOnDispense(ingredients);
    }

    // If the beverage has been dispensed, we can update ingredient quantities.
    // This method will also alert if an ingredient is running low.
    public void updateInventoryOnDispense(Map<String,Integer> ingredients){
        for (String ingredient : ingredients.keySet()){
            inventoryMap.put(ingredient, getIngredientQuantity(ingredient) - ingredients.get(ingredient));
            if(getIngredientQuantity(ingredient) <= Constants.ALERT_AMOUNT){
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
