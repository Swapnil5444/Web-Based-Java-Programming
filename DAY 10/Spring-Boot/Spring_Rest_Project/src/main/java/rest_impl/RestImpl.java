package rest_impl;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

public class RestImpl {
	//this class is meant for exposing REST end points.

		@GetMapping("/doGreet")

		public String getGreeting() {

			return "Welcome to REST";

		}



		@GetMapping("/doGreetAgain")

		public Greeting getGreetingObject() {

			Greeting gr = new Greeting("Happy New Year" , LocalDate.of(2026, 01, 1));

			return gr ;

		}	



		@GetMapping("/doGreetsAgain")

		public Collection<Greeting> getGreetingObjects() {

			Greeting gr = new Greeting("Happy New Year" , LocalDate.of(2026, 1, 1));

			Greeting gr2 = new Greeting("Merry Christmas" , LocalDate.of(2025, 12, 25));

			Greeting gr3 = new Greeting("Bye Bye 2025!!!" , LocalDate.of(2025, 12, 31));

			

			List<Greeting> greetingList = List.of(gr,gr2,gr3);

			return greetingList;

			

		}	
}
