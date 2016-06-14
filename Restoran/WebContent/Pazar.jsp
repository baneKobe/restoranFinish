<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.marko.Pazar" %>
<%@page import="dao.marko.PazarDao" %>
<%@page import="dao.marko.MenadzerRestoranaDao" %>
<%@page import="model.marko.MenadzerRestorana" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="cssNavigationPurke.css">
<link rel="stylesheet" href="cssfajlPurke.css">
</head>
<body>
<%
String email = request.getParameter("email");

System.out.println(email);
MenadzerRestoranaDao menDao = new MenadzerRestoranaDao();
MenadzerRestorana menadzer = menDao.getMenadzerRestByEmail(email);
int idRestoran = menadzer.getRestoran().getIdRest();
System.out.println(idRestoran);
PazarDao pazarDao = new PazarDao();
double pazarRestoran = pazarDao.getSumaPazar(idRestoran);
%>
<input type="hidden" value=<%=email%> name="email">
<nav class="navigation1">
	<ul class="navlista1">
		<li class="navitem1"><a href="ManagerPage.jsp?email=<%=email%>" class="navtekst1">Profil</a></li>
		<li class="navitem1">
            <a href="#" class="navtekst1">Registracija:</a>
            <br>
            <ul class="dropdown1">
                <li><a href="registracijaKonobara.jsp?email=<%=email%>" class="navtekst1">Konobar</a></li>
                <li><a href="registracijaKuvara.jsp?email=<%=email%>" class="navtekst1">Kuvar</a></li>
                <li><a href="registracijaSankera.jsp?email=<%=email%>" class="navtekst1">Sanker</a></li>
                <li><a href="registracijaPonudjaca.jsp?email=<%=email%>" class="navtekst1">Ponudjac</a></li>
            </ul>
        </li>
		<li class="navitem1">
            <a href="#" class="navtekst1">Definisanje:</a>
            <br>
            <ul class="dropdown1">
                <li><a href="KartaPicaUnos.jsp?email=<%=email%>" class="navtekst1">Karta pica</a></li>
                <li><a href="JelovnikUnos.jsp?email=<%=email%>" class="navtekst1">Jelovnik</a></li>
                <li><a href="#" class="navtekst1">Raspored i reon rada</a></li>
            </ul>
        </li>
        <li class="navitem1">
            <a href="#" class="navtekst1">Izmena:</a>
            <br>
            <ul class="dropdown1">
                <li><a href="Jelovnik.jsp?email=<%=email%>" class="navtekst1">Jelovnik</a></li>
                <li><a href="KartaPica.jsp?email=<%=email%>" class="navtekst1">Karta pica</a></li>
                <li><a href="RestoranNaziv.jsp?email=<%=email%>" class="navtekst1">Naziv i vrsta restorana</a></li>
            </ul>
        </li>
        <li class="navitem1">
            <a href="#" class="navtekst1">Ponuda:</a>
            <br>
            <ul class="dropdown1">
            	<li><a href="UnosPonudeRestorana.jsp?email=<%=email%>" class= "navtekst1">Unos namirnica i pica</a></li>
            	<li><a href="PrikazNamirnica.jsp?email=<%=email%>" class= "navtekst1">Prikaz potrebstina</a></li>
                <li><a href="OdabirPonude.jsp?email=<%=email%>" class="navtekst1">Odabir ponude</a></li>
            </ul>
        </li>
        <li class="navitem1">
            <a href="#" class="navtekst1">Prikaz:</a>
            <br>
            <ul class="dropdown1">
            	<li><a href="Pazar.jsp?email=<%=email%>" class= "navtekst1">Prihod restorana</a></li>
                <li><a href="OcenaRestorana.jsp?email=<%=email%>"  class="navtekst1">Ocena</a></li>
                <li><a href="#"  class="navtekst1">Grafik posecenosti(dnevno i nedeljno)</a></li>
                <li><a href="Konobari.jsp?email=<%=email%>"  class="navtekst1">Prikaz konobara</a></li>                
            </ul>
        </li>
        <li style=float:right; class="navitem1"><a href="login.html" class="navtekst1">Odjavi se</a></li>
	</ul>
</nav>
<div class="menResPon">
		
		
		</div>
		
		<div class="marko">
			<img style=margin-left:475px; alt="slika" src="restoran.jpg">
			<div>
			
				<table bordercolor="black  "  border="1" style=margin-left:550px;margin-top:30px;font-size:25px;background:#c2d6d6  >
					<tr>
						<td colspan="4" style="text-align: center;" class="tabelastil">Pazar</td>
					</tr>
					<tr >
						<td class="tabelastil">Restoran</td>
					</tr>
					<tr>
						<td><%=pazarRestoran%>        din.</td>
						
					</tr>
					
				</table>
			</div>
		</div>
</body>
</html>