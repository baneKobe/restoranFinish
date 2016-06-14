<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.marko.Ponudjac" %>
<%@page import="dao.marko.PonudjacDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="cssfajlPurke.css">
<link rel="stylesheet" href="cssNavigationPurke.css">
</head>
<body style=background-color:white;>
<%
String email = request.getParameter("email");
PonudjacDAO ponudjacDAO = new PonudjacDAO();
Ponudjac ponudjac = null;
Ponudjac ponudjac1 = ponudjacDAO.getPonudjacByEmail(email);
ponudjac=ponudjac1;
String ime = ponudjac.getIme();
String prezime = ponudjac.getPrezime();
String nazivKompanije = ponudjac.getNazivKompanije();
String email1= ponudjac.getEmail();
String password = ponudjac.getPassword();
String adresa = ponudjac.getAdresa();
String brojTelefona = ponudjac.getBrojTelefona();
int id= ponudjac.getId();
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
<div class="menResPon">
		<img alt="slika" src="ponudjac.png" class="profilPon">
		
		</div>
		
		<div class="marko">
			<div>
				<table>
					<tr>
						<td class="profil">Ime:<%=ime%></td>
						</br>
						</br>
					</tr>
					<tr>
						<td class="profil">Prezime: <%=prezime%></td>
						</br>
						</br>
					</tr>
					<tr>
						<td class="profil">Naziv kompanije: <%=nazivKompanije%></td>
						</br>
						</br>
					</tr>
					<tr>
						<td class="profil">email: <%=email1%></td>
						</br>
						</br>
					</tr>
						<input type="hidden" value="<%=password%>">	
						<br>
						<br>
					<tr>
						<td class="profil">adresa: <%=adresa%></td>
						</br>
						</br>
					</tr>
					<tr>
						<td class="profil">broj telefona: <%=brojTelefona%></td>
						</br>
						</br>
					</tr>
						
				</table>
			</div>
			
		</div>
		<a class="mojeDugme" style="margin: 350px 0 0 -270px;" href="PonudjacIzmena.jsp?id=<%=id %>">Azuriraj licne podatke</a>
</body>
</html>