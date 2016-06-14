<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Konobar"%>
    <%@page import="model.Restoran"%>
    <%@page import="dao.KonobarDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Konobar</title>
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
   <li><a href='KonobarProfile.jsp?email=<%=email %>'><span>Home</span></a></li>
   <li class='active has-sub'><a href='#'><span>Porudzbine</span></a>
      <ul>
         <li><a href='#'><span>Gotove</span></a>
         </li>
         <li><a href='PrihvaceneKonobar.jsp?email=<%=email %>'><span>Prihvacene</span></a>
         </li>
         <li><a href='PorudzbineKonobarPrikaz.jsp?email=<%=email %>'><span>Prikaz svih</span></a>
         </li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Racun</span></a>
      <ul>
         <li><a href='FormiranjeRacuna.jsp?email=<%=email %>'><span>Formiranje</span></a>
         </li>
         <li><a href='#'><span>Prikaz svih</span></a>
         </li>
		 <li><a href='#'><span>Prihod</span></a>
         </li>
      </ul>
   </li>
   <li><a href='UpdateKonobar.jsp?email=<%=email %>'><span>Update profile</span></a></li>
   <li><a href='RasporedRadaKonobar.jsp?email=<%=email %>'><span>Raspored rada</span></a></li>
   <li><a href='ReonRadaKonobar.jsp?email=<%=email %>'><span>Reon rada</span></a></li>
   <li class='last'><a href='Logout'><span>Logout</span></a></li>
</ul>
</div>
</div>
<div class="template">
<%
KonobarDao konDao = new KonobarDao();
Konobar konobar = null;
Konobar kon = konDao.GetKonobarByEmail(email);
konobar = kon;

String ime = konobar.getImeKonobar();
String prezime = konobar.getPrezimeKonobar();
int konfekcijskiBr = konobar.getKonfekcijskiBr() ;
String datumRodjenja = konobar.getDatumRodjenja();
String velicinaObuce = konobar.getVelicinaObuce();
double prihod = konobar.getPrihod();
String mejl = konobar.getEmail();
String restoran = konobar.getIdRestoran().getNazivRest();
int brPristupa = konobar.getBrPristupa();
%>

<div class="menSis">
		<img alt="slika" src="Waiter_Logo.jpeg" class="profilna">
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
					<tr >
						<td class="podaci">Konfekcijski Broj:     <%=konfekcijskiBr%></td>
					</tr>
					<tr >
						<td class="podaci">Datum rodjenja:     <%=datumRodjenja%></td>
					</tr>
					<tr >
						<td class="podaci">Velicina obuce:     <%=velicinaObuce%></td>
					</tr>
					<tr >
						<td class="podaci">Prihod:     <%=prihod%></td>
					</tr>
					<tr>
						<td class="podaci">Email:     <%=mejl%></td>
					</tr>
					<tr>
						<td class="podaci">Restoran:     <%=restoran%></td>
					</tr>
				</table>
			</div>
			
		</div>
</div>
</body>
</html>