package com.dunzo.application.coffeemachine;
import com.dunzo.application.coffeemachine.beverages.impl.*;
import com.dunzo.application.coffeemachine.utility.Constants;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class CoffeeMachineApplicationTests {

	Inventory inventory = new Inventory();
	CoffeeMachine coffeeMachine = new CoffeeMachine(inventory);
	ExecutorService executorService = Executors.newFixedThreadPool(10);

	@Test
	public void testRegularFlow(){
		coffeeMachine.dispenseBeverage(new GingerTea());
		coffeeMachine.dispenseBeverage(new ElaichiTea());
		coffeeMachine.dispenseBeverage(new HotMilk());
		coffeeMachine.dispenseBeverage(new Coffee());

	}

	@Test
	public void testMultipleThreads(){
		for(int i = 0; i<10; i++){
			executorService.execute(coffeeMachine::run);
		}
	}

	@Test
	public void testRefillIngredient(){
		coffeeMachine.refillMachine(Constants.MILK);
		coffeeMachine.refillMachine(Constants.WATER);
	}
}
