<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Ponudjac" %>
<%@page import="dao.PonudjacDAO" %>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ponudjaci</title>
<meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="styles.css">
   <link rel="stylesheet" href="cssfajl.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="script.js"></script>
</head>
<body>
<% String email = request.getParameter("email");%>
<div class="meni">
<div id='cssmenu'>
<ul>
   <li><a href='MenadzerSistema.jsp?email=<%=email %>'><span>Home</span></a></li>
   <li class='active has-sub'><a href='#'><span>Restoran</span></a>
      <ul>
         <li><a href='RegisterRestoran.jsp?email=<%=email %>'><span>Dodavanje</span></a>
         </li>
         <li><a href='RestoraniPrikaz.jsp?email=<%=email %>'><span>Prikaz svih</span></a>
         </li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Menadzer Restorana</span></a>
      <ul>
         <li><a href='MenadzerRestoranaReg.jsp?email=<%=email %>'><span>Dodavanje</span></a>
         </li>
         <li><a href='MenadzeriRestoranaPrikaz.jsp?email=<%=email %>'><span>Prikaz svih</span></a>
         </li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Ponudjac</span></a>
      <ul>
         <li><a href='PonudjacReg.jsp?email=<%=email %>'><span>Dodavanje</span></a>
         </li>
         <li><a href='PonudjaciPrikaz.jsp?email=<%=email %>'><span>Prikaz svih</span></a>
         </li>
      </ul>
   </li>
   <li><a href='UpdateMenadzerSistema.jsp?email=<%=email %>'><span>Update profile</span></a></li>
   <li class='last'><a href='logout'><span>Logout</span></a></li>
</ul>
</div>
</div>
<div class="template">
<%
PonudjacDAO ponDao = new PonudjacDAO();
List<Ponudjac> ponudjaci = ponDao.getAllPonudjac();
%>
<%for (Ponudjac ponudjac : ponudjaci) {%>
<table class='artikal'>
					<tr>
						<th rowspan='6' width='150px'><img alt="slika" src="profil.png" class="slika"></th>
						<td></td>
					</tr>
					<tr>
					<input type="hidden" name="id" value="<%=ponudjac.getId() %>">
						<th>Ime: </th>
						<td><%=ponudjac.getIme() %></td>
						<input type="hidden" name="ime" value="<%=ponudjac.getIme() %>">
					</tr>
					<tr>
						<th>Prezime: </th>
						<td><%= ponudjac.getPrezime() %></td>
						<input type="hidden" name="prezime" value="<%=ponudjac.getPrezime() %>">
					</tr>
					<tr>
						<th>Kompanija: </th>
						<td><%= ponudjac.getNazivKompanije() %></td>
						<input type="hidden" name="kompanija" value="<%=ponudjac.getNazivKompanije() %>">
					</tr>
					<tr>
						<th>Email: </th>
						<td><%= ponudjac.getEmail() %></td>
						<input type="hidden" name="mejl" value="<%=ponudjac.getEmail() %>">
					</tr>
					<tr>
						<th>Adresa: </th>
						<td><%= ponudjac.getAdresa()%></td>
						<input type="hidden" name="adresa" value="<%=ponudjac.getAdresa() %>">
					</tr>
					<tr>
						<th>Telefon: </th>
						<td><%=ponudjac.getBrojTelefona()%></td>
						<input type="hidden" name="telefon" value="<%=ponudjac.getBrojTelefona() %>">
					</tr>
					<tr>
						<td><a href="UpdatePonudjac.jsp?email=<%=email %>&id=<%=ponudjac.getId() %>" class="myButton">Update</a></td>
						<td><a href="DeletePonudjac?email=<%=email %>&id=<%=ponudjac.getId() %>&email=<%=email %>" class="myButton">Delete</a></td>
					</tr>
				<% }%>
				</table>
				</div>
</body>
</html>