<%@page import="org.apache.catalina.util.DateTool"%>
<%@page import="java.util.Date"%>
<%@page import="daoDejan.KorisnikDAO"%>
<%@page import="daoDejan.RestoranDAO"%>
<%@page import="klaseDejan.Korisnik"%>
<%@page import="klaseDejan.Restoran"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*" %>
<%@page import="java.text.*" %>

<!DOCTYPE html>
<html>
	<head>
		<meta content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="css1Dejan.css">
		<title></title>
	</head>
	<body>

<%
String odg = request.getParameter("odg");
String email = request.getParameter("email");
RestoranDAO resDAO = new RestoranDAO();
List<Restoran> restoran = resDAO.prikazSvihRestorana();
KorisnikDAO korDAO = new KorisnikDAO();
Korisnik korisnik=null;
if(email != null){
	Korisnik korisnik1 = korDAO.KorisnikEmail(email);
	korisnik = korisnik1;
}
int id1 = korisnik.getIdKor();
String naziv= request.getParameter("naziv");
String idRestoran = request.getParameter("idRestoran");
String idJelovnik = request.getParameter("idJelovnik");
String idKarte = request.getParameter("idKarte");

%>
<body>

<ul class=prvo>
  <li><a class="active" href="restoran.jsp?email=<%=email %>">Restorani</a></li>
  <li><a href="prijatelji.jsp?email=<%=email %>&ja=<%=id1%>">Prijatelji</a></li>
  <li><a href="nalogKorisnika.jsp?email=<%=email %>">Moj nalog</a></li>
  <li><a href="posete.jsp?email=<%=email%>&ja=<%=id1%>">Moje posete</a></li>
  <li style="float:right"><a href="Logout">Odjavi se</a></li>
</ul>

<% 
Date dNow = new Date( );
SimpleDateFormat ft = 
new SimpleDateFormat ("yyyy.MM.dd");
String danasnjidatum=ft.format(dNow);

Date hNow = new Date( );
SimpleDateFormat v = 
new SimpleDateFormat ("HH-mm");
String trenutnovreme=v.format(hNow);
//System.out.println(trenutnovreme);
%>

			<div class="peto">
			<%
				if (odg != null) {
					if (odg.equals("1")) {%>
					<blink style="color: red; padding-top: -100px;">Nije moguce rezervisati u proslom vremenu.</blink>
					<%}
				}%>
				
			<%
				if (odg != null) {
					if (odg.equals("2")) {%>
					<blink style="color: red; padding-top: -100px;">Restoran radi od 8:00h do 22:00h.</blink>
					<%}
				}%>
				
				<div class="cetvrto">
				<table class="tabela4">
				<form action="RezervacijaRestorana">
				<input type="hidden" name="danasnjidatum" value="<%=danasnjidatum%>">
				<input type="hidden" name="trenutnovreme" value="<%=trenutnovreme%>">
					<tr>
						<td class="tabela3">Restoran: <%=naziv%></td>
					</tr>
					<tr>
						<td class="tabela3">Datum:<input class="desno" type="date" name="datum" required min="<%=ft%>"></td>
					</tr>
					<tr>
						<td class="tabela3">Sati:<input class="desno" type="time" name="vreme" required min="<%=v%>"></td>
					</tr>
					<tr>
						<td class="tabela3">Trajanje rezervacije:<input class="desno" type="number" name="sati" min="1" max="2" required>h. </td>
					</tr>
					<tr>
					<input type="hidden" name="naziv" value="<%=naziv %>">
					<input type="hidden" name="email" value="<%=email%>">
					<input type="hidden" name="idRestoran" value="<%=idRestoran%>">
					<input type="hidden" name="idKarte" value="<%=idKarte %>">
					<input type="hidden" name="idJelovnik" value="<%=idJelovnik%>">
					<td class="tabela3"><input type="submit" value="Dalje >>" class="dugme"></td>
					</tr>
					</form>
					
				</table>
				</div>
				</div>
				
						<br><br>
			
		<tr>
			<input type="hidden" name="email" value="<%=email%>">
			<td class="tabela"><input type=button value="Nazad" 
				onclick="location.href='restoran.jsp?email=<%=email %>';" class="dugme">
		</tr>
				

</body>
</html>