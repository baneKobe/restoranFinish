<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.marko.Konobar" %>
<%@page import="dao.marko.KonobarDAO" %>
<%@page import="dao.marko.PazarDao" %>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="cssNavigationPurke.css">
<link rel="stylesheet" href="cssfajlPurke.css">
</head>
<body>
<%
int id = Integer.parseInt(request.getParameter("id"));
PazarDao pazarDao = new PazarDao();
double pazar = pazarDao.getPazarKonobar(id);
KonobarDAO konobarDAO = new KonobarDAO();
Konobar konobar = null;
Konobar konobar1 = konobarDAO.GetKonobarById(id);
konobar = konobar1;
String imeKonobar = konobar.getImeKonobar();
String prezime = konobar.getPrezimeKonobar();
int konfekcijskiBroj = konobar.getKonfekcijskiBr();
String datumRodjenja = konobar.getDatumRodjenja();
String velicinaObuce = konobar.getVelicinaObuce();
String password = konobar.getPassword();
String email = konobar.getEmail();
%>
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
                <li><a href="DefinisanjeReona.jsp?email=<%=email%>" class="navtekst1">Raspored i reon rada</a></li>
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
                <li><a href="Grafik.jsp?email=<%=email%>"  class="navtekst1">Grafik posecenosti(dnevno i nedeljno)</a></li>
                <li><a href="Konobari.jsp?email=<%=email%>"  class="navtekst1">Prikaz konobara</a></li>                
            </ul>
        </li>
        <li style=float:right; class="navitem1"><a href="login.html" class="navtekst1">Odjavi se</a></li>
	</ul>
</nav>
<div class="menResPon">
		<img alt="slika" src="konobar.jpg" class="profilKon">
		
		</div>
		
		<div class="markoPrikaz">
			<div>
				<table>
					<tr>
						<td class="profil">Ime:<%=imeKonobar%></td>
						</br>
						</br>
					</tr>
					<tr>
						<td class="profil">Prezime: <%=prezime%></td>
						</br>
						</br>
					</tr>
					<tr>
						<td class="profil">Konfekcijski broj: <%=konfekcijskiBroj%></td>
						</br>
						</br>
					</tr>
					<tr>
						<td class="profil">Datum rodjenja: <%=datumRodjenja%></td>
						</br>
						</br>
					</tr>
						<input type="hidden" value="<%=password%>">	
						<br>
						<br>
					<tr>
						<td class="profil">Velicina obuce: <%=velicinaObuce%></td>
						</br>
						</br>
					</tr>
					<tr>
						<td class="profil">Email: <%=email%></td>
						</br>
						</br>
					</tr>
					<tr>
						<td class="profil">Prihod: <%=pazar%> din.</td>
						</br>
						</br>
					</tr>
						
				</table>
			</div>
			
		</div>
			
</body>
</html>