package com.dunzo.application.coffeemachine.beverages;
import java.util.HashMap;
import java.util.Map;

public interface Beverage {
    String name = "";
    Map<String,Integer> ingredientRequirement = new HashMap<>();

    Map<String, Integer> getIngredientRequirement();
    String getName();
    }
