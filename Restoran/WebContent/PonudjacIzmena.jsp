<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.marko.Ponudjac" %>
<%@page import="dao.marko.PonudjacDAO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="cssfajlPurke.css">
<link rel="stylesheet" href="cssNavigationPurke.css">
</head>
<%
String id = request.getParameter("id");
String email = request.getParameter("email");
PonudjacDAO ponudjacDAO = new PonudjacDAO();
Ponudjac ponudjac1 = ponudjacDAO.getPonudjacByID(id);
String ime = ponudjac1.getIme();
String prezime = ponudjac1.getPrezime();
String nazivKompanije = ponudjac1.getNazivKompanije();
String email1 = ponudjac1.getEmail();
String adresa = ponudjac1.getAdresa();
String brojTelefona = ponudjac1.getBrojTelefona();
String password = ponudjac1.getPassword();
%>
<body style=background-color:white;>
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
<div class="IzmeniPon">
<img style="margin-left:-190px" alt="slika" src="ponudjac.png" class="profil">
	<form action="PonudjacSacuvajServlet">
		<table>
			<tr>
			
				<input value="<%=ime%>" name="ime" />
				</br>
				</br>
			</tr>
			<tr>
				<input value="<%=prezime%>" name="prezime" />
				</br>
				</br>
			</tr>
			<tr>
				<input value="<%=nazivKompanije%>" name="nazivKompanije" />
				</br>
				</br>
			</tr>
			<tr>
				<input value="<%=email1%>" name="email" />
				</br>
				</br>
			</tr>
			<tr>
				<input value="<%=password%>" name="password" type="password" onchange="form.lozinka2.pattern = this.value" title="Lozinka mora da sadrzi najmanje 6 karaktera ukljucujucii VELIKO/malo slovo i broj." required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"/>
				</br>
				
				<input title="Molimo vas unesite istu lozinku." required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" value="<%=password%>" name="lozinka2" type="password" />
				</br>
				<br>
			</tr>
			<tr>
				<input value="<%=adresa%>" name="adresa" />
				</br>
				</br>
			</tr>
			<tr>
				<input value="<%=brojTelefona%>" name="brojTelefona" />
				</br>
				</br>
			</tr>
			<tr>
			</tr>
			
		</table>
		<input type="hidden" value="<%=id %>" name="id">
		<input type="submit" value="Sacuvaj" name="sacuvaj" class="mojeDugme" style="margin: -10px 0 20px 20px;">
	</form>
		</div>
	<a href="PonudjacProfil.jsp?email=<%=email1%>" class="mojeDugme" style="margin: -10px 0 20px 570px;" >Odustani</a>
</body>
</head>