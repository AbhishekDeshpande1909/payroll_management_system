<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
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
        background-color: rgba(140, 243, 140,0);
        box-shadow: 0 4px 8px 0 rgba(150, 3, 3, 0.5), 0 6px 20px 0 rgba(3, 85, 133, 0.8);
        height: 400px;
        width: 60%;
        text-align: center;

    }
    td
    {
        font-size: calc(30% + 1vw + 1vh);
        color: rgb(241, 245, 4);
    }

</style>
</head>
<body style="background-image: url(img3.jpg);">
    <div class="container-fluid">
        <div class="row">
            <div class="col">
                <div class="row" style="height: 100px;">
                    <div class="col">
                        <h1 class="mt-5" style="text-align: center;font-size: calc(100% + 1vw + 1vh);color:wheat;">
                            PAYROLL MANGEMENT SYSTEM
                        </h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <h1 class="mt-4 mb-5" style="text-align: center;font-size: calc(100% + 1vw + 1vh);color:rgb(83, 30, 114);">
                            HR LOGIN
                        </h1>
                        <h4 style="text-align: right;margin-right: 100px;">
                        <a href="index.jsp" style="color:wheat;" >Home</a>
                        </h4>
                        <spr:form action="login.htm" method="post" commandName="hr" >
                            <table align="center">
		                        <tr>
                                    <td>
                                        User Name:
                                    </td>
			                        <td>
				                        <spr:input path="hrName"/>
			                        </td>
		                            </tr>
		                            <tr>
			                            <td>
			                            	Password:
			                            </td>
			                            <td>
			                            	<spr:password path="hrPass"/>
			                            </td>
		                            </tr>
		                            <tr>
		                            	<td>
		                            		<a href="hr_reg.htm" >Register first!!</a>
		                            	</td>
		                            	<td>
		                            		<input class="btn btn-success" type="submit"  value="Login" >
		                            	</td>
		                            </tr>
	                        </table>
	                    </spr:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-alpha2/js/bootstrap.min.js"></script>
</body>
</html>