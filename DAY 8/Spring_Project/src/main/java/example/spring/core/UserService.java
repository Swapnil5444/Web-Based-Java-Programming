package example.spring.core;

public class UserService implements GreetingService{

	private String name;
	private int age;
	
	public UserService() {

	}
	
	public UserService(String name, int age) {
		System.out.println("Inside UserService(String,int)");
		this.name = name;
		this.age = age;
	}
	
	
	public UserService(int age, String name) {
		System.out.println("Inside UserService(int,String)");
		this.age = age;
		this.name = name;
	}

	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}



    @Override
	public String sayGreeting() {
		String greeting = "Hi " + name  + ".your age is " + age;
		return  greeting;
	}

	
	
	
}
