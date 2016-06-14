<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Kuvar"%>
    <%@page import="model.RasporedRada"%>
    <%@page import="model.Restoran"%>
    <%@page import="dao.KuvarDao"%>
    <%@page import="dao.RasporedRadaDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kuvar Raspored Rada</title>
<meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="styles.css">
   <link rel="stylesheet" href="cssfajl.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="script.js"></script>
</head>
<body>
<%String email = request.getParameter("email");%>
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
KuvarDao kuvDao = new KuvarDao();
Kuvar kuvar = null;
Kuvar kuv = kuvDao.GetKuvarByEmail(email);
kuvar = kuv;
int idKuvar = kuvar.getIdKuvar();
RasporedRadaDao rasDao = new RasporedRadaDao();
RasporedRada raspored = rasDao.getRasporedRadaSanker(idKuvar);
String ponPoc = raspored.getPonPoc();
String ponKraj = raspored.getPonKraj();
String ponSmjena = raspored.getPonSmjena();
String utoPoc = raspored.getUtoPoc();
String utoKraj = raspored.getUtoKraj();
String utoSmjena = raspored.getUtoSmjena();
String srePoc = raspored.getSrePoc();
String sreKraj = raspored.getSreKraj();
String sreSmjena = raspored.getSreSmjena();
String cetPoc = raspored.getCetPoc();
String cetKraj = raspored.getCetKraj();
String cetSmjena = raspored.getCetSmjena();
String petPoc = raspored.getPetPoc();
String petKraj = raspored.getPetKraj();
String petSmjena = raspored.getPetSmjena();
String subPoc = raspored.getSubPoc();
String subKraj = raspored.getSubKraj();
String subSmjena = raspored.getSubSmjena();
String nedPoc = raspored.getNedPoc();
String nedKraj = raspored.getNedKraj();
String nedSmjena = raspored.getNedSmjena();

%>

<div class="menSis">
		<img alt="slika" src="sanker.jpg" class="profilna">
		</div>
		
		<div class="data">
			<div>
				<table>
					<tr >
						<td class="podaci">Ponedeljak: Pocetak rada:   <%=ponPoc%>   kraj rada:   <%=ponKraj %>   smjena:  <%=ponSmjena %></td>
					</tr>
					<tr >
						<td class="podaci">Utorak: Pocetak rada:   <%=utoPoc%>   kraj rada:   <%=utoKraj %>   smjena:  <%=utoSmjena %></td>
					</tr>
					<tr >
						<td class="podaci">Srijeda: Pocetak rada:   <%=srePoc%>   kraj rada:   <%=sreKraj %>   smjena:  <%=sreSmjena %></td>
					</tr>
					<tr >
						<td class="podaci">Cetvrtak: Pocetak rada:   <%=cetPoc%>   kraj rada:   <%=cetKraj %>   smjena:  <%=cetSmjena %></td>
					</tr>
					<tr >
						<td class="podaci">Petak: Pocetak rada:   <%=petPoc%>   kraj rada:   <%=petKraj %>   smjena:  <%=petSmjena %></td>
					</tr>
					<tr >
						<td class="podaci">Subota: Pocetak rada:   <%=subPoc%>   kraj rada:   <%=subKraj %>   smjena:  <%=subSmjena %></td>
					</tr>
					<tr >
						<td class="podaci">Nedjelja: Pocetak rada:   <%=nedPoc%>   kraj rada:   <%=nedKraj %>   smjena:  <%=nedSmjena %></td>
					</tr>
				</table>
			</div>
			
		</div>
		</div>
</body>
</html>