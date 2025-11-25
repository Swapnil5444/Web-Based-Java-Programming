package example.spring.core;

import java.text.Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationSimpleExampleMain {
		
	public static void main(String[] args) {
		//This class loads the bean configured using annotation
		Class<SpringConfig> configClass = SpringConfig.class;
		ApplicationContext context = new AnnotationConfigApplicationContext(configClass);
		Object obj = context.getBean("doWelcome");
		GreetingService gs = (GreetingService)obj;
		String reply = gs.sayGreeting();
		System.out.println(reply);
		
		System.out.println("==================");
		
		obj = context.getBean("helloBean");
		gs = (GreetingService)obj;
		reply = gs.sayGreeting();
		System.out.println(reply);
		
	}
}
