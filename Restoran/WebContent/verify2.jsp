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
	String sto = request.getParameter("sto");
	String naziv = request.getParameter("naziv");
	String email = request.getParameter("email");
	String datum = request.getParameter("datum");
	String vreme = request.getParameter("vreme");
	String sati = request.getParameter("sati");
	String idJelovnik = request.getParameter("idJelovnik");
	String idKarte = request.getParameter("idKarte");
	String idRestorana = request.getParameter("idRestorana");
%>
	<input type=button value="Potvrdi dolazak" 
	onclick="location.href='rezervacijaRestorana4.jsp?sto=<%=sto%>&naziv=<%=naziv%>&email=<%=email%>&datum=<%=datum%>&vreme=<%=vreme%>&sati=<%=sati%>&idJelovnik=<%=idJelovnik%>&idKarte=<%=idKarte%>&idRestorana=<%=idRestorana%>';"class="dugmad">

	<input type=button value="Otkazi" onclick="location.href='login.jsp';" class="dugmad">

</body>
</html>