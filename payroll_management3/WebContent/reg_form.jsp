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
	
	<spr:form action="emp_reg.htm" method="post" commandName="emp" >
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
				Employee Name:
			</td>
			<td>
				<spr:input path="employeeName"/>
			</td>
		</tr>
		<tr>
			<td>
				Employee Contact No.:
			</td>
			<td>
				<spr:input path="employeecontactno"/>
			</td>
		</tr>
		<tr>
		<tr>
			<td>
				Employee EmailId:
			</td>
			<td>
				<spr:input path="employeemail"/>
			</td>
		</tr>
		<tr>
			<td>
				Employee Password:
			</td>
			<td>
				<spr:password path="employeePass"/>
			</td>
		</tr>
		<tr>
			<td>
				<a href="index.jsp" >Back</a>
			</td>
			<td>
				<input type="submit"  value="Register" >
			</td>
		</tr>
	</table>
	</spr:form>
	
</body>
</html>