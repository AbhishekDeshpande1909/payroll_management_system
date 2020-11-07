<%@page import="com.cdac.dto.Employee"%>
<%@page import="java.util.List"%>
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
		<% 
		
		
		Employee exp = (Employee)request.getAttribute("empSel");
		
		
		%>
		<tr>
			<td>
				<%=exp.getEmployeeID()
				%>
			</td>
			<td>
				<%=exp.getEmployeeName()%>
			</td>
			<td>
				<%=exp.getEmployeePass() %>
			</td>
			<td>
				<%=exp.getEmployeeSalary()%>
			</td>
			<td>
				<%=exp.getEmployeecontactno()%>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit"  value="Search" >
			</td>
		</tr>
	</table>
	</spr:form>
	
</body>
</html>