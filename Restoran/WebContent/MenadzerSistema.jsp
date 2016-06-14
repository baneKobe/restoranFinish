<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.MenadzerSistema" %>
<%@page import="dao.MenadzerSistemaDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menadzer Sistema</title>
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
MenadzerSistemaDao menSisDao = new MenadzerSistemaDao();
MenadzerSistema menSis = null;
MenadzerSistema menSistema = menSisDao.GetMenadzerSistemaByEmail(email);
menSis = menSistema;

String ime = menSis.getImeMenSis();
String prezime = menSis.getPrezimeMenSis();
String jmbg = menSis.getJmbgMenSis();
String ema = menSis.getEmailMenSis();
int id = menSis.getIdMenSis();
%>

<div class="menSis">
		<img alt="slika" src="logo.jpg" class="profilna">
		</div>
		
		<div class="data">
			<div>
				<table>
					<tr >
						<td class="podaci">Ime:     <%=ime%></td>
					</tr>
					<tr >
						<td class="podaci">Prezime:     <%=prezime%></td>
					</tr>
					<tr>
						<td class="podaci">Email:     <%=ema%></td>
					</tr>
					<tr>
						<td class="podaci">JMBG:     <%=jmbg%></td>
					</tr>
					<input type="hidden" name="idMenSis" value="<%=id%>">
				</table>
			</div>
			
		</div>

</div>
</body>
</html>