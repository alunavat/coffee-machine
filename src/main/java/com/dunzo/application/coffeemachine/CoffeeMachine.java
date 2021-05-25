package com.dunzo.application.coffeemachine;
import com.dunzo.application.coffeemachine.beverages.Beverage;
import com.dunzo.application.coffeemachine.beverages.impl.GingerTea;
import com.dunzo.application.coffeemachine.utility.Constants;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class CoffeeMachine extends Thread{
    private Inventory inventory;
    Semaphore semaphore = new Semaphore(Constants.PARALLEL_DRINKS_LIMIT);

    public CoffeeMachine(Inventory inventory) {
        this.inventory = inventory;
    }

    // Method is called to dispense requested beverages. Checks inventory before proceeding.
    public void dispenseBeverage(Beverage beverage){
        if(semaphore.tryAcquire()) {
            try {
                Map<String, Integer> composition = beverage.getIngredientRequirement();
                inventory.checkInInventory(composition);
                System.out.println("Serving " + beverage.getName() + " Now!");
            } catch (Exception e) {
                System.out.println("We are unable to process your request right now because " + e.getMessage());
            } finally {
                semaphore.release();
            }
        }
    }

    public void run(){
        if (semaphore.tryAcquire()){
            dispenseBeverage(new GingerTea());
        }
        else{
            System.out.println("Waiting in queue.");
        }
        semaphore.release();
    }

    // Machine can be refilled with products which are running low.
    public void refillMachine(String refillIngrdient) {
            inventory.refillIngredient(refillIngrdient);
    }

}
