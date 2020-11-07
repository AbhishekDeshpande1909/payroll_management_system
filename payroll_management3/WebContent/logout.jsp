<%
	session.removeAttribute("hr");
	session.invalidate();
	response.sendRedirect("index.jsp");
%>