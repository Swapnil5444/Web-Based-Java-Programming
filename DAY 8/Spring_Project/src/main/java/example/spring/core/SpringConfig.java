package example.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //Marks this class as a configuration unit.
public class SpringConfig {
		//This class is meant for declaring beans or configuring beans
	
	    //Defining a bean of type WelcomeService
	@Bean //Marks this method as a bean declaration method.
	public GreetingService doWelcome() {
		GreetingService ws = new WelcomeService();
		return ws;
	}
	
	@Bean("helloBean")//Marks this method as a bean declaration method.
	public GreetingService dohello() {
		GreetingService ws = new WelcomeService();
		return ws;
	}
	
	
}
