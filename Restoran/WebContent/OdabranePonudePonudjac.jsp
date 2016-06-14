<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.marko.MenadzerRestoranaDao" %>
<%@page import="model.marko.MenadzerRestorana" %>
<%@page import="dao.marko.PonudaDAO" %>
<%@page import="model.marko.Ponuda" %>
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
<body style=background-color:white>
<%
PonudaDAO ponudaDAO = new PonudaDAO();
List<Namirnice>namirnice = ponudaDAO.prikazSvihNamirnica();
for(Namirnice n: namirnice) {
	System.out.println(n.getNaziv());
	System.out.println(n.getKolicina());
	System.out.println(n.getCena());
}
String email=request.getParameter("email");
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
		
		</div>
		
		<div class="markoPrikaz">
			
			<div>
				<div>
				<table bordercolor=black  border="1" style=margin-left:-300px;margin-top:300px;font-size:25px;background:white >
				
					<tr >
						<td colspan="4" style="text-align: center;" class="tabelastil">Odabrana ponuda</td>
						
					</tr>
					<tr>
						<td class="tabelastil">Naziv</td>
						<td class="tabelastil">Kolicina(komada)</td>
						<td class="tabelastil">Cena(din.)</td>
					</tr>
					
					<tr>
						<td><%=request.getParameter("naziv")%></td>
						<td><%=request.getParameter("kolicina")%></td>
						<td><%=request.getParameter("cena")%></td>
					</tr>
				</table>
			</div>
			</div>
			
		</div>
</body>
</html>