package com.dunzo.application.coffeemachine.beverages.impl;
import com.dunzo.application.coffeemachine.beverages.Beverage;
import com.dunzo.application.coffeemachine.utility.AppConstants;

import java.util.Map;

public class GingerTea implements Beverage {

    final String name = "Ginger Tea";
    private final Map<String,Integer> composition = Map.of(
            AppConstants.WATER,50, AppConstants.MILK,10,
            AppConstants.TEA_LEAVES_SYRUP,10,
            AppConstants.GINGER_SYRUP,5, AppConstants.SUGAR_SYRUP,10);

    public GingerTea() {
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Integer> getIngredientRequirement() {
        return composition;
    }

}
