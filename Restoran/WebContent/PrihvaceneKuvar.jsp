<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Kuvar"%>
    <%@page import="model.Restoran"%>
    <%@page import="dao.KuvarDao"%>
    <%@page import="dao.PorudzbinaDao"%>
    <%@page import="model.Porudzbina"%>
    <%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Porudzbine</title>
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
         <li><a href='GotoveKuvar.jsp?email=<%=email%>'><span>Gotove</span></a>
         </li>
         <li><a href='PorudzbineKuvarPrikaz.jsp?email=<%=email%>'><span>Primljene</span></a>
         </li>
         <li><a href='PrihvaceneKuvar.jsp?email=<%=email %>'><span>Prihvacene</span></a>
         </li>
      </ul>
   </li>
   <li><a href='UpdateKuvar.jsp?email=<%=email%>'><span>Update profile</span></a></li>
   <li><a href='#'><span>Raspored rada</span></a></li>
   <li class='last'><a href='Logout'><span>Logout</span></a></li>
</ul>
</div>
</div>
<div class="template">
<%
KuvarDao kuvDao = new KuvarDao();
Kuvar kuvar = kuvDao.GetKuvarByEmail(email);
int idRestoran = kuvar.getIdRestoran().getIdRest();
PorudzbinaDao porDao = new PorudzbinaDao();
List<Porudzbina> por = porDao.getAllPorudzbina();
 
%>

<%for (Porudzbina porudzbina : por) {%>
<%int rest = porudzbina.getRestoran().getIdRest(); %>
<%int prihvacenoKuvar = porudzbina.getPrihvacenoKuvar(); %>
<%int gotovoKuvar = porudzbina.getGotovoKuvar(); %>
<%if (gotovoKuvar==0) {%>
<%if (prihvacenoKuvar==1) {%>
<%if (idRestoran==rest){ %>
<table class='artikal'>
					<tr>
						<th>Naruceno Jelo: </th>
						<td><%= porudzbina.getJelo().getNaziv() %></td>
						<th>Kolicina:</th>
						<td><%= porudzbina.getKolicinaJela() %></td>
						<input type="hidden" name="jelo" value="<%=porudzbina.getJelo().getIdJelo() %>">
					</tr>
					<tr>
						<th>Cijena: </th>
						<td><%= porudzbina.getJelo().getCijena()*porudzbina.getKolicinaJela()+porudzbina.getPice().getCijena()*porudzbina.getKolicinaPica() %></td>
						<input type="hidden" name="cijena" value="<%=porudzbina.getCijena() %>">
					</tr>
					<tr>
						<th>Korisnik: </th>
						<td><%= porudzbina.getKorisnik().getUsername()%></td>
						<input type="hidden" name="korisnik" value="<%=porudzbina.getKorisnik().getIdKor() %>">
					</tr>
					<tr>
						<th>Rezervisani Termin: </th>
						<td><%= porudzbina.getTermin().getDatum()%></td>
						<td><%= porudzbina.getTermin().getVrijeme()%></td>
						<input type="hidden" name="termin" value="<%=porudzbina.getTermin().getIdTermin() %>">
					</tr>
					<tr>
						<th>Segment: </th>
						<td><%= porudzbina.getSegment().getNazivSegment()%></td>
						<input type="hidden" name="segment" value="<%=porudzbina.getSegment().getIdSegment()%>">
					</tr>
					<tr>
						<th>Sto: </th>
						<td><%= porudzbina.getSto().getIdSto()%></td>
						<input type="hidden" name="sto" value="<%=porudzbina.getSto().getIdSto() %>">
					</tr>
					<tr>
						<th>Restoran: </th>
						<td><%=porudzbina.getRestoran().getNazivRest()%></td>
						<input type="hidden" name="restoran" value="<%=porudzbina.getRestoran().getIdRest() %>">
					</tr>
					<input type="hidden" name="email" value="<%=email %>">
					<tr>
						<td><a href="KuvarGotovo.jsp?email=<%=email %>&id=<%=porudzbina.getIdPorudzbina() %>" class="myButton">Gotova porudzbina</a></td>
					</tr>
			<% }%>
			<% }%>
			<% }%>
			<% }%>
			</table>
		
</div>
</body>
</html>