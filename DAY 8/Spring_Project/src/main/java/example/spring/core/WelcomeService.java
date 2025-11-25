package example.spring.core;

public class WelcomeService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Welcome to  Spring!!";
	}

	
}
