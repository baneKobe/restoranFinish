<%@page import="java.util.Date"%>
<%@page import="daoDejan.KorisnikDAO"%>
<%@page import="daoDejan.RestoranDAO"%>
<%@page import="klaseDejan.Korisnik"%>
<%@page import="klaseDejan.Restoran"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
	<head>
		<meta content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="css1Dejan.css">
		<title></title>
	</head>
	<body>

<%
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
String datum= request.getParameter("datum");
String vreme= request.getParameter("vreme");
String sati= request.getParameter("sati");
String sto= request.getParameter("sto");

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
		
		<div class="peto">
			<div class="cetvrto">
				<table class="tabela4">
				<form action="rezervacijaRestorana3.jsp?naziv=<%=naziv %>&email=<%=email %>&datum=<%=datum %>
					&vreme=<%=vreme %>&sati=<%=sati %>">
					<tr>
						<td class="tabela3">Restoran: <%=naziv%></td>
					</tr>
					<tr>
						<td class="tabela3">Datume: <%=datum %></td>
					</tr>
					<tr>
						<td class="tabela3">Sati: <%=vreme %></td>
					</tr>
					<tr>
						<td class="tabela3">Trajanje rezervacije:<%=sati %> </td>
					</tr>
					<tr>
						<td class="tabela3">Sto:<input class="desno" type="number" name="sto" min="1" max="5" required></td>
					</tr>
					
					<tr>
					<input type="hidden" name="naziv" value="<%=naziv %>">
					<input type="hidden" name="email" value="<%=email%>">
					<input type="hidden" name="datum" value="<%=datum %>">
					<input type="hidden" name="vreme" value="<%=vreme%>">
					<input type="hidden" name="sati" value="<%=sati%>">

					<input type="hidden" name="idRestoran" value="<%=idRestoran%>">
					<input type="hidden" name="idKarte" value="<%=idKarte %>">
					<input type="hidden" name="idJelovnik" value="<%=idJelovnik%>">
					<td class="tabela3"><input type="submit" value="Dalje >>" class="dugme" ></td>
					</tr>
					</form>
					
				</table>
			</div>
		</div>
		
								<br><br>
			
		<tr>
			<input type="hidden" name="email" value="<%=email%>">
			<input type="hidden" name="naziv" value="<%=naziv %>">
								<input type="hidden" name="idRestoran" value="<%=idRestoran%>">
					<input type="hidden" name="idKarte" value="<%=idKarte %>">
					<input type="hidden" name="idJelovnik" value="<%=idJelovnik%>">
			
			<td class="tabela"><input type=button value="Nazad" 
				onclick="location.href='rezervacijaRestorana.jsp?naziv=<%=naziv %>&email=<%=email %>&idJelovnik=<%=idJelovnik %>&idKarte=<%=idKarte %>&idRestoran=<%=idRestoran %>';" class="dugme">
		</tr>


</body>
</html>