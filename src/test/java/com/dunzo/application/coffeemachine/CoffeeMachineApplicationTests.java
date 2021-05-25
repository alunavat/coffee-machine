package com.dunzo.application.coffeemachine;
import com.dunzo.application.coffeemachine.beverages.impl.*;
import com.dunzo.application.coffeemachine.utility.AppConstants;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class CoffeeMachineApplicationTests {

	Inventory inventory = new Inventory();
	CoffeeMachine coffeeMachine = new CoffeeMachine(inventory);

	// This test case covers the normal scenario. Here all the beverages are served without alerts.
	@Test
	public void testRegularFlow(){
		coffeeMachine.dispenseBeverage(new GingerTea());
		coffeeMachine.dispenseBeverage(new ElaichiTea());
		coffeeMachine.dispenseBeverage(new HotMilk());
		coffeeMachine.dispenseBeverage(new Coffee());

	}

	// This test case covers the scenario where we reach maximum available resources.
	// For the purpose of test we are requesting the same beverage multiple times.
	// The machine will run out of water after giving an alert for it's low quantity.
	@Test
	public void testInSufficientFlow(){
		GingerTea gingerTea = new GingerTea();
		for(int i = 0; i < 15; i++){
			coffeeMachine.dispenseBeverage(gingerTea);
		}
	}

	// This test covers the refill flow.
	@Test
	public void testRefillIngredient(){
		coffeeMachine.refillMachine(AppConstants.MILK);
		coffeeMachine.refillMachine(AppConstants.WATER);
	}
}
