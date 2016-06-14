 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.marko.Jelovnik" %>
<%@page import="model.marko.Jelo" %>
<%@page import="dao.marko.JelovnikDAO" %>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="tabela.css">
<link rel="stylesheet" href="cssNavigationPurke.css">
<link rel="stylesheet" href="cssfajlPurke.css">
</head>
<body style=background-color:#c2d6d6>

<%String email=request.getParameter("email");%>
<%
JelovnikDAO jelaDAO = new JelovnikDAO();
List<Jelovnik> jelo = jelaDAO.prikazSvihJela();

for(Jelovnik j: jelo) {
	System.out.println(j.getNaziv());
}


//String naziv1 = kartaPica.getNaziv();
//int id= kartaPica.getIdKarte();
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
		<!-- <img alt="slika" src="ponudjac.png" class="profilPon"> -->
		
		</div>
		
		<div class="marko">
			<div>
			
				<table bordercolor=black  border="1" style=margin-left:150px;margin-top:400px;font-size:25px;background:#c2d6d6 >
				
					<tr >
						<td colspan="4" style="text-align: center;" class="tabelastil">Jela</td>
						
					</tr>
					<tr>
						<td class="tabelastil">Naziv</td>
						<td class="tabelastil">Opis</td>
						<td class="tabelastil">Cena(din.)</td>
						<td class="tabelastil">Izmeni/Obrisi</td>
					</tr>
					<% for(Jelovnik k: jelo) { %>
					<tr>
						<td><%=k.getNazivJela() %></td>
						<td><%=k.getOpisJela() %></td>
						<td><%=k.getCenaJela() %></td>
						<td><a href="JelovnikIzmena.jsp?id=<%=k.getIdjelo()%>&naziv=<%=k.getNazivJela()%>&opis=<%=k.getOpisJela() %>&cena=<%=k.getCenaJela() %>">Izmeni | </a><a href="JelovnikDeleteServlet?id=<%=k.getIdjelo() %>">Obrisi </a></td>
					</tr>
					<% } %>
					
					
					
				</table>
				
			</div>
			
		</div>

		
</body>
</html>