package example.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringSimpleExamplemain {

	public static void main(String[] args) {
		//This class loads a bean from Springs configuration unit and performs
		//operation using that bean.
		
		String configFilePath = "./src/main/resources/spring-config.xml";
		
		ApplicationContext context = new FileSystemXmlApplicationContext(configFilePath);
		
		Object obj = context.getBean("myBean");
		GreetingService gs = (GreetingService)obj;
		String reply = gs.sayGreeting();
		System.out.println(reply);
		
		
		System.out.println("==================");
		obj = context.getBean("userBean");
		gs = (GreetingService)obj;
		reply = gs.sayGreeting();
		System.out.println(reply);
		
		System.out.println("==================");
		obj = context.getBean("userBean2");
		gs = (GreetingService)obj;
		reply = gs.sayGreeting();
		System.out.println(reply);
	}

}
