package example.spring.aop;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect //Marks this class as an Aspect specific class
public class AudienceWithAround {
	//Defining a PointCut Method
	@Pointcut("execution(* example.spring.aop.*.perform(..))")
	private void myPointCut() {
		
	}
	
	private void takeSeats() {
		System.out.println("Please take Seats.[Around]");
	}
	
	
	private void turnOffMobile() {
		System.out.println("Please turn off Mobile.[Around]");
	}
	

	private void clap() {
		System.out.println("Clap Clap Clap.[Around]");
	}
	
	
	private void demandForRefund() {
		System.out.println("Please give my money back.[Around]");
	}

	
	private void leave() {
		System.out.println("Bye, leaving now.[Around]");
	}
	
	@Around("myPointCut()")
	public void monitorPerformance(ProceedingJoinPoint joinPoint) {
		try {
			takeSeats();
			turnOffMobile();
			joinPoint.proceed();
			clap();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			demandForRefund();
		}
		leave();
	}
}
