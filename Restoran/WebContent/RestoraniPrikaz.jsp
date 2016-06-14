<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Restoran" %>
<%@page import="dao.RestoranDao" %>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restorani</title>
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
RestoranDao resDao = new RestoranDao();
List<Restoran> rest = resDao.prikazSvihRestorana();
%>
<%for (Restoran restoran : rest) {%>
<table class='artikal'>
					<tr>
						<th rowspan='6' width='150px'><img alt="slika" src="restoran.jpg" class="slika"></th>
						<td></td>
					</tr>
					<tr>
					<input type="hidden" name="idRest" value="<%=restoran.getIdRest() %>">
						<th>Naziv: </th>
						<td><%= restoran.getNazivRest() %></td>
						<input type="hidden" name="naziv" value="<%=restoran.getNazivRest() %>">
					</tr>
					<tr>
						<th>Vrsta: </th>
						<td><%= restoran.getVrstaRest() %></td>
						<input type="hidden" name="vrsta" value="<%=restoran.getVrstaRest() %>">
					</tr>
					<tr>
						<th>Jelovnik: </th>
						<td><%= restoran.getJelovnik().getNazivJelovnika() %></td>
						<input type="hidden" name="jelovnik" value="<%=restoran.getJelovnik().getNazivJelovnika() %>">
					</tr>
					<tr>
						<th>Karta Pica: </th>
						<td><%=restoran.getKartapica().getNaziv()%></td>
						<input type="hidden" name="kartaPica" value="<%=restoran.getKartapica().getNaziv() %>">
					</tr>
					<tr>
						<td><a href="UpdateRestoran.jsp?id=<%=email %>&idRest=<%=restoran.getIdRest() %>" class="myButton">Update</a></td>
						<td><a href="DeleteRestoran?id=<%=restoran.getIdRest() %>&email=<%=email %>" class="myButton">Delete</a></td>
					</tr>
				<% }%>
				</table>
				</div>
</body>
</html>