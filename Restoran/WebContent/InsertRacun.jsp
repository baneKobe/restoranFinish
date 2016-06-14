<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Konobar"%>
    <%@page import="model.Restoran"%>
    <%@page import="dao.KonobarDao"%>
    <%@page import="dao.PorudzbinaDao"%>
    <%@page import="model.Porudzbina"%>
    <%@page import="dao.RacunDao"%>
    <%@page import="model.Racun"%>
    <%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formiranje racuna</title>
<meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="styles.css">
   <link rel="stylesheet" href="cssfajl.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="script.js"></script>
   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<% String email = request.getParameter("email");%>
<div class="meni">
<div id='cssmenu'>
<ul>
   <li><a href='KonobarProfile.jsp?email=<%=email %>'><span>Home</span></a></li>
   <li class='active has-sub'><a href='#'><span>Porudzbine</span></a>
      <ul>
         <li><a href='#'><span>Gotove</span></a>
         </li>
         <li><a href='#'><span>Primljene</span></a>
         </li>
         <li><a href='PorudzbineKonobarPrikaz.jsp?email=<%=email %>'><span>Prikaz svih</span></a>
         </li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Racun</span></a>
      <ul>
         <li><a href='#'><span>Formiranje</span></a>
         </li>
         <li><a href='#'><span>Prikaz svih</span></a>
         </li>
		 <li><a href='#'><span>Prihod</span></a>
         </li>
      </ul>
   </li>
   <li><a href='UpdateKonobar.jsp?email=<%=email %>'><span>Update profile</span></a></li>
   <li><a href='#'><span>Raspored rada</span></a></li>
   <li class='last'><a href='logout'><span>Logout</span></a></li>
</ul>
</div>
</div>
<div class="template">
<%
KonobarDao konDao = new KonobarDao();
Konobar konobar = konDao.GetKonobarByEmail(email);
int idKonobar = konobar.getIdKonobar();
String ime = konobar.getImeKonobar();
String prezime = konobar.getPrezimeKonobar();
String kon = ime + " " + prezime;
String rest = konobar.getIdRestoran().getNazivRest();
int restoran = konobar.getIdRestoran().getIdRest();
int id = Integer.parseInt(request.getParameter("id"));
PorudzbinaDao porDao = new PorudzbinaDao();
Porudzbina porudzbina = null;
Porudzbina por = porDao.getPorudzbinaById(id);
porudzbina = por;
int idPorudzbina = porudzbina.getIdPorudzbina();
String jelo = porudzbina.getJelo().getNaziv();
double cijenaJelo = porudzbina.getJelo().getCijena(); 
int idJelo = porudzbina.getJelo().getIdJelo();
String pice = porudzbina.getPice().getNaziv();
double cijenaPice = porudzbina.getPice().getCijena();
int idPice = porudzbina.getPice().getIdPice();
int kolicinaJela = porudzbina.getKolicinaJela();
int kolicinaPica = porudzbina.getKolicinaPica();
String datum = porudzbina.getTermin().getDatum();
double cijena = porudzbina.getJelo().getCijena()*porudzbina.getKolicinaJela()+porudzbina.getPice().getCijena()*porudzbina.getKolicinaPica();

%>
<table class="tabela">
				<form action="InsertRacun">
				
					<tr class="red">
						<td class="polje">Naziv Jela:</td> <td class="polje"> <%=jelo %></td><td class="polje"><%=cijenaJelo %></td>
					</tr>
					<tr>
					<td class="polje">Kolicina Jela:</td><td class="polje"> <%=kolicinaJela %></td>
					<input type="hidden" name="jelo" value="<%=idJelo %>">
					</tr>
					<tr class="red">
						<td class="polje">Naziv Pica:</td> <td class="polje"> <%=pice %></td><td class="polje"><%=cijenaPice %></td>
					</tr>
					<tr>
					<td class="polje">Kolicina Pica:</td><td class="polje"> <%=kolicinaPica %></td>
					<input type="hidden" name="pice" value="<%=idPice %>">
					</tr>
					<tr class="red">
						<td class="polje">Konobar:</td> <td class="polje"><%=kon %>  </td>
					</tr>
					<input type="hidden" name="konobar" value="<%=idKonobar%>">
					<tr class="red">
						<td class="polje">Restoran:</td> <td class="polje"><%=rest %>  </td>
					</tr>
					<input type="hidden" name="restoran" value="<%=restoran%>">
					<input type="hidden" name="idPorudzbina" value="<%=id%>">
					<tr class="red">
						<td class="polje">Ukupna cijena:</td> <td class="polje"><%=cijena %>  </td>
					</tr>
					<input type="hidden" name="cijena" value="<%=cijena%>">
					<tr class="red">
						<td class="polje">Datum:</td> <td class="polje"><%=datum %>  </td>
					</tr>
					<input type="hidden" name="email" value="<%=email%>">
					<tr class="red">
					 <td><input type="submit" value="Formiraj Racun" class="dugmic"></td>
					  </tr>
					  </form>
				</table>
</div>
</body>
</html>