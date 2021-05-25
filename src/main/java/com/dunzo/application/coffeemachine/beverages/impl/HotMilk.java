package com.dunzo.application.coffeemachine.beverages.impl;

import com.dunzo.application.coffeemachine.beverages.Beverage;
import com.dunzo.application.coffeemachine.utility.Constants;

import java.util.Map;

public class HotMilk implements Beverage {
    final String name = "Hot Milk";
    private final Map<String,Integer> composition = Map.of(
            Constants.MILK,50);

    public HotMilk() {
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Integer> getIngredientRequirement() {
        return composition;
    }
}
