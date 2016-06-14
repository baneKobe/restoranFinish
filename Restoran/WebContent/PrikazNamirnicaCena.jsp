<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.marko.MenadzerRestoranaDao" %>
<%@page import="model.marko.MenadzerRestorana" %>
<%@page import="dao.marko.PonudaDAO" %>
<%@page import="model.marko.Namirnice" %>
<%@page import="java.util.List" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"  href="cssPurke.css" />
<link rel="stylesheet" href="cssNavigationPurke.css">
<link rel="stylesheet" href="cssfajlPurke.css">
</head>
<body style="background:white">
<%
PonudaDAO ponudaDAO = new PonudaDAO();
List<Namirnice> namirnice = ponudaDAO.prikazSvihNamirnica();
String id = request.getParameter("id");
%>
<%String email=request.getParameter("email");%>
<nav class="navigation1">
	<ul class="navlista1">
		<li class="navitem1"><a href="PonudjacProfil.jsp?email=<%=email%>" class="navtekst1">Profil</a></li>
		<li class="navitem1">
            <a href="#" class="navtekst1">Spisak:</a>
            <br>
            <ul class="dropdown1">
                <li><a href="PrikazNamirnicaCena.jsp?email=<%=email%>" class="navtekst1">Spisak ponuda</a></li>
            </ul>
        </li>
		<li class="navitem1">
            <a href="#" class="navtekst1">Izmeni:</a>
            <br>
            <ul class="dropdown1">
                <li><a href="PrikazNamirnicaIzmena.jsp?email=<%=email%>" class="navtekst1">Izmeni ponudu</a></li>
            </ul>
        </li>
		
        <li class="navitem1">
            <a href="#" class="navtekst1">Obavestenja:</a>
            <br>
            <ul class="dropdown1">
                <li><a href="OdabranePonudePonudjac.jsp?email=<%=email%>" class="navtekst1">Prihvacene ponude</a></li>
                <li><a href="OdabranePonudePonudjac.jsp?email=<%=email%>" class="navtekst1">Neprihvacene ponude</a></li>
            </ul>
        </li>
        <li style=float:right; class="navitem1"><a href="login.html" class="navtekst1">Odjavi se</a></li>
	</ul>
</nav>
<div>
<h1 style="margin-left:370px">Spisak trazenih namirnica restorana:</h1>
<br>
<br>
<br>
<br>
		<table border="3" style="margin-left:550px">
		<tr><td>Naziv:</td><td>Kolicina:</td></tr>
		<form action="SacuvajCenuServlet">
		<%for (Namirnice n:namirnice) {%>
			<tr>
			<td>
				<%=n.getNaziv()%>
				</td>
				<td>
				<%=n.getKolicina()%>
				komada
				</td>
			</tr>
				<input type="hidden" name="id" value="<%=n.getIdNamirnicaPica()%>">
				<input type="hidden" name="email" value="<%=email%>">
			</tr>
			<%} %>
			</form>
		</table>
		<br>
		<input type="hidden" value="<%=id%>" name="id">
		<a class="mojeDugme" style=margin-left:570px; type="submit" href="PrikazNamirnicaIzmena.jsp?email=<%=email%>">Izmeni</a>
		</div>
		<br>
</body>
</html>