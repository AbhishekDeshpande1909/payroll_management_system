<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
<%@page import="com.cdac.dto.Hr"%>
<%@page import="com.cdac.dto.Employee"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta name="Description" content="Enter your description here"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-alpha2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<title>Title</title>
<style>
    table
    {
        height: 500px;
        width: 100%;
        text-align: center;

    }
    td
    {
        font-size: calc(30% + 1vw + 1vh);
        color:rgb(248, 252, 247);
        
    }
    a{
        text-decoration: none;
        color:rgb(241, 245, 4);
    }
    a:hover{
        text-decoration: none;
        color:rgb(241, 245, 4);
    }

</style>
</head>
<body style="background-image: url(img3.jpg);">
    <div class="container-fluid">
        <div class="row">
            <div class="col">
                <div class="row">
                    <div class="col">
                        <h1 class="mt-5" style="text-align: center;font-size: calc(100% + 1vw + 1vh);color:wheat;">
                            PAYROLL MANGEMENT SYSTEM
                        </h1>
                    </div>
                </div>
                <h2 class="mt-3" style="text-align: center;font-size: calc(100% + 1vw + 1vh);color:wheat;">
                    WELOCME <%=(session.getAttribute("hr")!=null) ? ((Hr)session.getAttribute("hr")).getHrName() : "!!!!!!!!" %>
                </h2>
                <div class="row">
                    <div class="col-3" style="height: 500px;background-color: rgba(155, 121, 49, 0.2);">
                        <table align="center" >
                            <tr>
                                <td> <a href="add_emp.htm" >Add Employee</a> </td>
                            </tr>
                            <tr>
                                <td> <a href="employeelist.htm " >Manage Employee</a> </td>
                            </tr>
                        </table>

                        
                    </div>
                    <div class="col-9" style="border: 2px solid rgb(138, 82, 105);height: 500px;">
						<spr:form action="emp_update.htm" method="post" commandName="emp" >
							<table style="text-align: left">
								<tr>
									<%
									
									Employee emplpe = (Employee)request.getAttribute("emp");
									System.out.println(emplpe);
									%>
									<td>
										Employee Id:
									</td>
									<td>
										<spr:input  path="employeeID" style="background:none" />
									</td>
								</tr>
								<tr>
						
									<td>
										Employee Name:
									</td>
									<td>
										<spr:input path="employeeName" style="background:none"/>
									</td>
								</tr>
								<tr>
									<td>
										Employee Contact No.:
									</td>
									<td>
										<spr:input path="employeecontactno" style="background:none"/>
									</td>
								</tr>
								<tr>
									<td>
										Employee EmailId:
									</td>
									<td>
										<spr:input path="employeemail" style="background:none"/>
									</td>
								</tr>
								<tr>
									<td>
										Employee Salary:
									</td>
									<td>
										<spr:input path="employeeSalary" style="background:none"/>
									</td>
								<tr>
									<td style="text-align: right">
										<input class="btn btn-success" type="submit" value="Update" >
									</td>
								</tr>
							</table>
							</spr:form>
			 </div>
                </div>
            </div>
        </div>
    </div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-alpha2/js/bootstrap.min.js"></script>
</body>
</html>