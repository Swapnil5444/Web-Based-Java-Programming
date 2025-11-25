<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import = "java.time.*"%>
<!DOCTYPE html>
<html>
	<body>
	   <h1>Welcome to the demo of JSP tags.</h1>
	   
	   <%-----Including the resource:background.html --%>
	   <%@ include file = "background.html" %>
	   
	   <%----Declaring some variables and defining some method --%>
	   <%!
	       int num =25;
	   public String sayWelcome(String name){
		   return "Welcome" + name;
	   }
	   %>
	   
	   <%----Accessing the variable and method --%>
	   <h2>Square of <%= num %> is <%=(num * num) %></h2>
	   <h2>Reply from method is <%=sayWelcome(" Swapnil") %></h2>
	   
	   <%---Displaying Hello Message 5 times using H2 heading --%>
	   <% 
	    for(int i=1;i<=5;i++){
       %>
          <h2>HELLO</h2>
       <%
	      }
       %>
	   
       <%----Displaying system date and time --%>
       <%
          LocalDate today = LocalDate.now();
          LocalTime now = LocalTime.now();
       %>
	   <h2>Today's date is <%=today %></h2>
	   <h2>Current time is <%=now %></h2>
	</body>
</html>