This project mimics the basic functionalities of a coffee machine.

Following are the modules/classes and their role:

1. CoffeeMachine : This class handles the primary interaction with our machine. The class will allow us to get a beverage and also refill the machine based on need. It depends on the Inventory class to ensure a beverage can be served.
2. Inventory : The Inventory class mimics an actual inventory. It conatins information of available ingredients and their respective quantites. This allows us to check and update quantities in our machine.
3. Beverage : Beverage is an Interface and contains basic structure of beverages in our machine. Addition of a beverage in the machine can be done by impelementing this interface.

Key Features:

1. We have implemented Semaphores to ensure only a limited number of beverages can be served by the machine at a time.
2. The test cases can be executed to ensure all features are working as expected.

Note : A beverage will be served only if all the ingredients are available and in apt quantity.  

