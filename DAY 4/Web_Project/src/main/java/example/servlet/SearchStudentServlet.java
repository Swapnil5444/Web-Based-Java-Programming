package example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import example.jdbc.DaoInterface;
import example.jdbc.Student;
import example.jdbc.StudentDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchStudentServlet
 */
@WebServlet("/doSearch")
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Fetching Student ID as a Request Parameter
		String student_id = request.getParameter("studentId");
		int studentId = Integer.parseInt(student_id);
		
		//Searching for a student against the ID using DAO Layer
		DaoInterface<Student,Integer> daoRef = new StudentDao();
		Student foundStudent = daoRef.getOne(studentId);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher dispatcher = null;
		
		if(foundStudent != null) {
			//Send this Student to the next servlet: DisplayStudentServlet (doDisplay)
			//out.println("Student Found");
			
			//Obtaining RequestDispatcher for the next servlet: doDisplay
			dispatcher = request.getRequestDispatcher("doDisplay");
			//Attaching the found student: foundStudent to the existing request.
			request.setAttribute("currentStudent", foundStudent);
			//Forwarding the request
			dispatcher.forward(request, response);
			
		}
		else {
			out.println("Student with given ID does not exist,please try again!! ");
			//Redirect to control to search_student.html page and 
			//display some appropriate message
			
			//Obtaining RequestDispatcher for the next servlet: search_student.html
			dispatcher = request.getRequestDispatcher("search_student.html");
			dispatcher.include(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
