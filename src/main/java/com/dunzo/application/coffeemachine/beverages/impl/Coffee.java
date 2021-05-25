package com.dunzo.application.coffeemachine.beverages.impl;

import com.dunzo.application.coffeemachine.beverages.Beverage;
import com.dunzo.application.coffeemachine.utility.Constants;

import java.util.Map;

public class Coffee implements Beverage {
    final String name = "Coffee";
    private final Map<String,Integer> composition = Map.of(
            Constants.WATER,50,Constants.MILK,10,
            Constants.COFFEE_SYRUP,10, Constants.SUGAR_SYRUP,10);

    public Coffee() {
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Integer> getIngredientRequirement() {
        return composition;
    }
}
