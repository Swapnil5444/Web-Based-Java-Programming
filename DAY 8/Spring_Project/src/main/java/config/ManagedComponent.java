package config;

import org.springframework.stereotype.Component;

@Component //Marks this class as a component so that Spring can manage it.
public class ManagedComponent {

	public void doManage() {
		System.out.println("Managing the Component");
	}
	
}
