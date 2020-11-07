<%
	session.removeAttribute("emp");
System.out.println("emp logged out");
	session.invalidate();
	response.sendRedirect("index.jsp");
%>