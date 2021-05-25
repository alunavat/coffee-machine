package com.dunzo.application.coffeemachine.beverages.impl;

import com.dunzo.application.coffeemachine.beverages.Beverage;
import com.dunzo.application.coffeemachine.utility.AppConstants;

import java.util.Map;

public class Coffee implements Beverage {
    final String name = "Coffee";
    private final Map<String,Integer> composition = Map.of(
            AppConstants.WATER,50, AppConstants.MILK,10,
            AppConstants.COFFEE_SYRUP,10, AppConstants.SUGAR_SYRUP,10);

    public Coffee() {
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Integer> getIngredientRequirement() {
        return composition;
    }
}
