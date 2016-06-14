<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Statement" %>
<%@page import="util.ConnectionManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="dao.marko.PonudjacDAO" %>
<%@page import="model.marko.Ponudjac" %>
<%@page import="dao.marko.PonudaDAO" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet"  href="cssPurke.css" />
<link rel="stylesheet" href="cssNavigationPurke.css">
<link rel="stylesheet" href="cssfajlPurke.css">
</head>	
<body style="background:white">
<%String email=request.getParameter("email");
System.out.println(email);
PonudjacDAO ponudjacDAO = new PonudjacDAO();
Ponudjac ponudjac = null;
Ponudjac ponudjac1 = ponudjacDAO.getPonudjacByEmail(email);
ponudjac = ponudjac1;
String idPonudjac = ponudjac.getBrojTelefona();
System.out.println(idPonudjac);
%>
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
<div class="field">
<h1>Unos ponude</h1>
<form action="AddPonudaServlet">
  <input type="text" name="naziv" placeholder="naziv"><br>
  <br>
  <input type="text" name="kolicina" placeholder="kolicina"><br>
  <br>
  <input type="hidden" name="ponudjac" value=<%=idPonudjac%>>
<br>
<br>
<input type="submit" value="Unesi" class="centar">
</form>
</div>
</body>
</html>