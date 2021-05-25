package com.dunzo.application.coffeemachine;
import com.dunzo.application.coffeemachine.beverages.Beverage;
import com.dunzo.application.coffeemachine.beverages.impl.GingerTea;
import com.dunzo.application.coffeemachine.utility.AppConstants;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class CoffeeMachine {
    private Inventory inventory;

    // Use of semaphore will limit the number of beverages that can be served in parallel.
    Semaphore semaphore = new Semaphore(AppConstants.PARALLEL_DRINKS_LIMIT);

    public CoffeeMachine(Inventory inventory) {
        this.inventory = inventory;
    }

    // Method is called to dispense requested beverages. Checks inventory before proceeding.
    public void dispenseBeverage(Beverage beverage){
            try {
                semaphore.acquire();
                Map<String, Integer> composition = beverage.getIngredientRequirement();
                inventory.checkInInventory(composition);
                System.out.println("Serving " + beverage.getName() + " Now!");
            }catch (InterruptedException e) {
                // do nothing for now
            }
            catch (Exception e) {
                System.out.println("We are unable to process your request right now because " + e.getMessage());
            } finally {
                semaphore.release();
            }
        }

    // Machine can be refilled with products which are running low.
    public void refillMachine(String refillIngredient) {
            inventory.refillIngredient(refillIngredient);
    }

}
