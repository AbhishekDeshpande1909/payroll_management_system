<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
 <%@ include file="cache_control.jsp" %>
 <%@page import="com.cdac.dto.Employee"%>

<jsp:useBean id="emp" class="com.cdac.dto.Employee" scope="session" ></jsp:useBean>
<% 
	if(emp !=null && emp.getEmployeeID()>0 && emp.getEmployeeID()<20000){
%>
   
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
        width: 90%;
        text-align: center;
        background-color: rgba(158, 241, 158, 0.4);
        box-shadow: 0 4px 8px 0 rgba(150, 3, 3, 0.5), 0 6px 20px 0 rgba(3, 85, 133, 0.8);

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
                <div class="row">
                    <div class="col-8">
           				<h2 class="mt-3 " style="text-align: right;font-size: calc(100% + 1vw + 1vh);color:wheat;">
                   			 WELOCME <%=(session.getAttribute("emp")!=null) ? ((Employee)session.getAttribute("emp")).getEmployeeName() : "!!!!!!!!" %>
                		</h2>

                    </div>
                    <div class="col-4">
                      <h6 class="mt-3" style="text-align: center;font-size: calc(40% + 1vw + 1vh);color:wheat;">
                    <a href="emp_logout.htm" >logout</a> 
                    </h6>
                    </div>
                
                </div>
                <div class="row">
                    <div class="col" style="height: 500px;">
                    <spr:form action="emp_update2.htm" method="post" commandName="emp" >
							<table >
								<tr>
									<%
									
									Employee emplpe = (Employee)request.getAttribute("emp");
									System.out.println(emplpe);
									%>

									<td>
										Employee Id:
									</td>
									<td>
										<spr:input path="employeeID" style="background:none"  />
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
										<spr:input path="employeeSalary" style="background:none" disabled="true" value="<%=emplpe.getEmployeeSalary() %>"/>
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
<%}else{
	response.sendRedirect("index.jsp");	
	}
	%>