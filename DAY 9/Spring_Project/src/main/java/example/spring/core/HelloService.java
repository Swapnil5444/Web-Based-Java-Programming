package example.spring.core;

public class HelloService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello from Spring!!";
	}

	
}
