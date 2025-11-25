<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
	
	    <%--Instantiating a Java Bean: Person from package: example.bean
	    and putting it into SESSION scope --%>
	    <jsp:useBean id ="currentPerson" class="example.bean.Person" scope="session"/>
	    
	    <%--Assigning values to the properties of the bean --%>
	    <jsp:setProperty property="*" name="currentPerson"/>
	    
	    
	    <h2>Added a new person.Please 
	    <a href = "show_person.jsp">Click Here </a> to view the details.</h2>
	</body>
</html>