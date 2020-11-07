<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 style="text-align: center;" >Search an employee to delete!!</h2>
	<spr:form action="search.htm" method="post" commandName="emp" >
	<table align="center" >
		<tr>
			<td>
				Employee ID:
			</td>
			<td>
				<spr:input path="employeeID"/>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit"  value="Delete" >
			</td>
		</tr>
	</table>
	</spr:form>
	
</body>
</html>