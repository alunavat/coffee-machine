package com.dunzo.application.coffeemachine.beverages.impl;

import com.dunzo.application.coffeemachine.beverages.Beverage;
import com.dunzo.application.coffeemachine.utility.AppConstants;
import java.util.Map;

public class HotWater implements Beverage {
    final String name = "Hot Water";
    private final Map<String,Integer> composition = Map.of(
            AppConstants.WATER,50);

    public HotWater() {
    }
    public String getName() {
        return this.name;
    }

    public Map<String, Integer> getIngredientRequirement() {
        return composition;
    }
}
