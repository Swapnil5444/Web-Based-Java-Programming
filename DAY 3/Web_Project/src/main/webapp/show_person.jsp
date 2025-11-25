<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
	 
	    <%---Obtaining a bean of type: example.bean.Person 
	    with ID:currentPerson from SESSION scope --%>
	    <jsp:useBean id ="currentPerson" class="example.bean.Person" scope="session" />
	    
	    <%---Retrieving values of the properties of the bean and displaying them using H2 heading --%>
	    <h2>Name: <jsp:getProperty name = "currentPerson" property="name"/> </h2>
	    <h2>Age: <jsp:getProperty name = "currentPerson" property="age" /></h2>
	    <h2>Weight: <jsp:getProperty name = "currentPerson" property="weight"/> </h2>
	    
	    
	</body>
</html>