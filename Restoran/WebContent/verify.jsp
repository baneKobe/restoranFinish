<%@page import="daoDejan.KorisnikDAO"%>
<%@page import="klaseDejan.Korisnik"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css1Dejan.css">
<title>Insert title here</title>
</head>
<body>
<%
	String email = request.getParameter("email");
%>
	<input type=button value="Potvrdi nalog" onclick="location.href='PotvrdaRegistracije?&email=<%=email%>'" class="dugmad">
	<input type=button value="Odustani" onclick="location.href='OtkazRegistracije?email=<%=email%>'" class="dugmad">

</body>
</html>