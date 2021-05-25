package com.dunzo.application.coffeemachine;

import com.dunzo.application.coffeemachine.beverages.impl.GingerTea;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args){
		System.out.println("This is Dunzo's Coffee Machine.");
	}

}
