package example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet("/doCount")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//Obtaining a session of the current client (user)
		HttpSession session = request.getSession();
		//Checking whether the session is newly created or not
		int countValue = 0;
		if(session.isNew()) {
			countValue= 1;
		}
		else {
			//Obtaining the previous count value from the existing session
			Object obj = session.getAttribute("currentCount");
			Integer previousCount = (Integer)obj;
			//Incrementing the count by 1
			countValue = previousCount + 1; 
			
		}
		//Attaching the countValue to the session
		session.setAttribute("currentCount", countValue);
		//Displaying the countValue using the response
		out.println("Hit Count : "+ countValue);
		//Redirecting the Control to HTML Page:counter.html
		RequestDispatcher dispatcher = request.getRequestDispatcher("counter.html");
		dispatcher.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
