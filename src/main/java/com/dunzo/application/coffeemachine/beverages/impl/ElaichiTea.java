package com.dunzo.application.coffeemachine.beverages.impl;

import com.dunzo.application.coffeemachine.beverages.Beverage;
import com.dunzo.application.coffeemachine.utility.Constants;

import java.util.Map;

public class ElaichiTea implements Beverage {

    final String name = "Elaichi Tea";
    private final Map<String,Integer> composition = Map.of(
            Constants.WATER,50,Constants.MILK,10,
            Constants.TEA_LEAVES_SYRUP,10,
            Constants.ELAICHI_SYRUP,5,Constants.SUGAR_SYRUP,10);

    public ElaichiTea() {
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Integer> getIngredientRequirement() {
        return composition;
    }
}
