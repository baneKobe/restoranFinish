<%@page import="java.util.Date"%>
<%@page import="daoDejan.KorisnikDAO"%>
<%@page import="daoDejan.RestoranDAO"%>
<%@page import="daoDejan.PrijateljDAO"%>
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
String odgovor=request.getParameter("odgovor");

String email = request.getParameter("email");
KorisnikDAO korDAO = new KorisnikDAO();
Korisnik korisnik=null;
if(email != null){
	Korisnik korisnik1 = korDAO.KorisnikEmail(email);
	korisnik = korisnik1;
}

String sifra = korisnik.getLozinka();

PrijateljDAO prijDAO = new PrijateljDAO();
int id1 = korisnik.getIdKor();
List<Korisnik> kor = prijDAO.PrikazPrijatelja(id1);
String naziv= request.getParameter("naziv");
String datum= request.getParameter("datum");
String vreme= request.getParameter("vreme");
String sati= request.getParameter("sati");
String sto= request.getParameter("sto");

String idRestoran = request.getParameter("idRestoran");
String idJelovnik = request.getParameter("idJelovnik");
String idKarte = request.getParameter("idKarte");
%>

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
				<form action="rezervacijaRestorana4.jsp?naziv=<%=naziv %>&email=<%=email %>&datum=<%=datum %>
					&vreme=<%=vreme %>&sati=<%=sati %>&ja=<%=id1%>">
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
						<td class="tabela3">Sto:<%=sto %></td>
					</tr>
					
					<tr>
					<input type="hidden" name="naziv" value="<%=naziv %>">
					<input type="hidden" name="email" value="<%=email%>">
					<input type="hidden" name="datum" value="<%=datum %>">
					<input type="hidden" name="vreme" value="<%=vreme%>">
					<input type="hidden" name="sati" value="<%=sati%>">
					<input type="hidden" name="sto" value="<%=sto%>">
					<input type="hidden" name="ja" value="<%=id1%>">
					<input type="hidden" name="idJelovnik" value="<%=idJelovnik%>">
					<input type="hidden" name="idKarte" value="<%=idKarte %>">
					<input type="hidden" name="idRestoran" value="<%=idRestoran%>">
					<td class="tabela3"><input type="submit" value="Dalje >>" class="dugme" ></td>
					</tr>
					</form>
					
				</table>
			</div>
		</div>
		
										<br><br>
			
		<tr>
			<input type="hidden" name="email" value="<%=email%>">
			<td class="tabela"><input type=button value="Nazad" 
				onclick="location.href='rezervacijaRestorana2.jsp?naziv=<%=naziv %>&email=<%=email %>&datum=<%=datum %>&vreme=<%=vreme %>&sati=<%=sati %>&idJelovnik=<%=idJelovnik %>&idKarte=<%=idKarte %>&idRestoran=<%=idRestoran %>';" class="dugme">
		</tr>
		
	
	<div >
	<h3 class=sesto>Prijatelji:</h3>
			<%
			if(odgovor!=null){
				if(odgovor.equals("1")){ 
					%><blink style="color: green; margin-left:500px; padding-top:-100px;">Pozvali ste prijatelja</blink><%
				}
			}
			%>
	<table  class=tabela5>
		<tr>
			<th class=aha>Ime</th>
			<th class=aha>Prezime</th>
			<th class=aha>Email</th>
			<th class=aha></th>

		<%
				for (Korisnik k : kor) {
			%>
		<tr>
			<form action="Pozovi">
			<td><%=k.getUsername()%></td>
			<td><%=k.getPrezime() %></td>
			<td><%=k.getEmail()%></td>
			<td><input class="dugme" type="submit" value="Pozovi"></td>
			<input type="hidden" name="email" value="<%=k.getEmail() %>">
			<input type="hidden" name="email2" value="<%=email%>"></td>
			<input type="hidden" name="sifra" value="<%=sifra %>">
			<input type="hidden" name="naziv" value="<%=naziv %>">
			<input type="hidden" name="datum" value="<%=datum %>">
			<input type="hidden" name="vreme" value="<%=vreme%>">
			<input type="hidden" name="sati" value="<%=sati%>">
			<input type="hidden" name="sto" value="<%=sto%>">
			<input type="hidden" name="idJelovnik" value="<%=idJelovnik%>">
					<input type="hidden" name="idKarte" value="<%=idKarte %>">
					<input type="hidden" name="idRestoran" value="<%=idRestoran%>">
			</form>
<%} %>

		</tr>
	</table>
	</div>
		


</body>
</html>