<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Ponudjac" %>
<%@page import="dao.PonudjacDAO" %>
<%@page import="java.sql.Statement" %>
<%@page import="util.ConnectionManager" %>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Ponudjac</title>
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
int id = Integer.parseInt(request.getParameter("id"));
PonudjacDAO ponDao = new PonudjacDAO();
Ponudjac ponudjac = null;
Ponudjac ponudjac1 = ponDao.getPonudjacById(id);
ponudjac = ponudjac1;
String ime= ponudjac.getIme();
String prezime= ponudjac.getPrezime();
String kompanija= ponudjac.getNazivKompanije();
String mejl= ponudjac.getEmail();
String password= ponudjac.getPassword();
String adresa= ponudjac.getAdresa();
String telefon= ponudjac.getBrojTelefona();
int idPonudjac = ponudjac.getId();
%>
<table class="tabela">
				<form action="UpdatePonudjac">
					<tr class="red">
						<td class="polje">Ime:</td> <td class="polje"> <input type="text" name="ime" value="<%=ime%>" class="unos" title="Polje za ime ne moze biti prazno. Ime moze da sadrzi samo slova." required pattern="[a-zA-Z]+"></td>
					</tr>
					<tr class="red">
						<td class="polje">Prezime:</td> <td class="polje">  <input type="text" name="prezime" value="<%=prezime%>" class="unos" title="Polje za prezime ne moze biti prazno i moze da sadrzi samo slova." required pattern="[a-zA-Z]+"></td>
					</tr>
					<tr class="red">
						<td class="polje">Kompanija:</td> <td class="polje">  <input type="text" name="kompanija" value="<%=kompanija%>" title="Polje za naziv kompanije ne moze biti prazno. Ime moze da sadrzi samo slova."class="unos" required pattern="[a-zA-Z\s]+"></td>
					</tr>
					<tr class="red">
						<td class="polje">Email:</td> <td class="polje">  <input type="text" name="mejl" value="<%=mejl%>" class="unos" title="Primer: characters@characters.domain" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"></td>
					</tr>
					<tr class="red">
						<td class="polje">Stari password:</td> <td class="polje">  <input type="text" name="lozinka" value="<%=password%>" class="unos"></td>
					</tr>
					<tr class="red">
						<td class="polje">Novi password:</td> <td class="polje">  <input type="password" name="password" class="unos" title="Lozinka mora da sadrzi najmanje 6 karaktera ukljucujucii VELIKO/malo slovo i broj." required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" onchange="form.password2.pattern = this.value;"></td>
					</tr>
					<tr class="red">
						<td class="polje">Repeat password:</td> <td class="polje"> <input type="password" name="password2" class="unos" title="Molimo vas unesite istu lozinku." type="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"></td>
					</tr>
					<tr class="red">
						<td class="polje">Adresa:</td> <td class="polje">  <input type="text" name="adresa" value="<%=adresa%>" title="Polje za ime ne moze biti prazno."class="unos" required></td>
					</tr>
					<tr class="red">
						<td class="polje">Broj Telefona:</td> <td class="polje">  <input type="text" name="telefon" value="<%=telefon%>" title="Polje za broj telefona ne moze biti prazno."class="unos" required></td>
					</tr>
					<input type="hidden" name="idPonudjac" value="<%=id%>">
					<input type="hidden" name="email" value="<%=email%>">
					<tr class="red">
					 <td><input type="submit" value="Update" class="dugmic"></td>
					  </tr>
					  </form>
				</table>
				
</div>
</body>
</html>