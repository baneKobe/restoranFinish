<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Kuvar"%>
    <%@page import="model.Restoran"%>
    <%@page import="dao.KuvarDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kuvar</title>
<meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="styles.css">
   <link rel="stylesheet" href="cssfajl.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="script.js"></script>
</head>
<body>
<%String email = request.getParameter("email"); %>
<div class="meni">
<div id='cssmenu'>
<ul>
   <li><a href='KuvarProfile.jsp?email=<%=email %>'><span>Home</span></a></li>
   <li class='active has-sub'><a href='#'><span>Porudzbine</span></a>
      <ul>
         <li><a href='GotoveKuvar.jsp?email=<%=email %>'><span>Gotove</span></a>
         </li>
         <li><a href='PorudzbineKuvarPrikaz.jsp?email=<%=email %>'><span>Primljene</span></a>
         </li>
         <li><a href='PrihvaceneKuvar.jsp?email=<%=email %>'><span>Prihvacene</span></a>
         </li>
      </ul>
   </li>
   <li><a href='UpdateKuvar.jsp?email=<%=email %>'><span>Update profile</span></a></li>
   <li><a href='RasporedRadaKuvar.jsp?email=<%=email %>'><span>Raspored rada</span></a></li>
   <li class='last'><a href='Logout'><span>Logout</span></a></li>
</ul>
</div>
</div>
<div class="template">
<%
KuvarDao konDao = new KuvarDao();
Kuvar kuvar = null;
Kuvar kuv = konDao.GetKuvarByEmail(email);
kuvar = kuv;

String ime = kuvar.getImeKuvar();
String prezime = kuvar.getPrezimeKuvar();
int konfekcijskiBr = kuvar.getKonfekcijskiBr() ;
String datumRodjenja = kuvar.getDatumRodjenja();
String velicinaObuce = kuvar.getVelicinaObuce();
String mejl = kuvar.getEmail();
String restoran = kuvar.getIdRestoran().getNazivRest();
%>

<div class="menSis">
		<img alt="slika" src="cook.jpg" class="profilna">
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