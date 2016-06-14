<%@page import="java.util.Date"%>
<%@page import="daoDejan.KorisnikDAO"%>
<%@page import="daoDejan.RestoranDAO"%>
<%@page import="daoDejan.PrijateljDAO"%>
<%@page import="daoDejan.JelovnikDAO"%>
<%@page import="daoDejan.KartaPicaDAO"%>
<%@page import="klaseDejan.Korisnik"%>
<%@page import="klaseDejan.Restoran"%>
<%@page import="klaseDejan.Jelo"%>
<%@page import="klaseDejan.Pice"%>
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
int id1 = korisnik.getIdKor();
String naziv= request.getParameter("naziv");
String datum= request.getParameter("datum");
String vreme= request.getParameter("vreme");
String sati= request.getParameter("sati");
String sto= request.getParameter("sto");

String idRestoran = request.getParameter("idRestoran");
String idJelovnik = request.getParameter("idJelovnik");
String idKarte = request.getParameter("idKarte");


RestoranDAO rDAO = new RestoranDAO();
Restoran restoran =rDAO.RestoranID(idRestoran);
JelovnikDAO jDAO= new JelovnikDAO();
List<Jelo> jela= jDAO.GetJelovnikByID(idJelovnik);
KartaPicaDAO kpDAO= new KartaPicaDAO();
List<Pice> pice= kpDAO.GetKartaPicaByID(idKarte);
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
				<form action="MojaPoseta">
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
					<input type="hidden" name="ja" value="<%=id1%>">
					
					
					<td class="tabela3"><input type="submit" value="Potvrdi" class="dugme" ></td>
					</tr>
					</form>
					
				</table>
			</div>
		</div>
		
										<br><br>
			
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
			<td class="tabela"><input type=button value="Nazad" 
				onclick="location.href='rezervacijaRestorana3.jsp?sto=<%=sto%>&naziv=<%=naziv %>&email=<%=email %>&datum=<%=datum %>&vreme=<%=vreme %>&sati=<%=sati %>&idJelovnik=<%=idJelovnik %>&idKarte=<%=idKarte %>&idRestoran=<%=idRestoran %>';" class="dugme">
		</tr>
		
		
<div >
<h3 class=sesto>Jelovnik restorana <%=naziv%></h3>

<p class=sedmo>
				<%
				if (odgovor != null) {
					if (odgovor.equals("1")) {%>
					<blink style="color: green; padding-top: -100px;">Porucili ste jelo.</blink>
					<%}
					}%></p>
		<table class=tabela5>
			<tr>
				<th class=aha>Naziv</th>
				<th class=aha>Opis</th>
				<th class=aha>Cena</th>
				<th class=aha></th>
				</tr>

				<%
				for (Jelo j : jela) {
			%>
			<tr>
				<td><%=j.getNaziv()%></td>
				<td class="dodatak"><%=j.getOpis() %></td>
				<td class="dodatak"><%=j.getCijena() %></td>
				
				<form action=PoruciJelo>
				<input type="hidden" name="email" value="<%=email%>">
				<input type="hidden" name="nazivJela1" value="<%=j.getNaziv()%>">
				
				<input type="hidden" name="naziv" value="<%=naziv %>">
				<input type="hidden" name="datum" value="<%=datum %>">
				<input type="hidden" name="vreme" value="<%=vreme%>">
				<input type="hidden" name="sati" value="<%=sati%>">
				<input type="hidden" name="sto" value="<%=sto%>">
				<input type="hidden" name="ja" value="<%=id1%>">
				<input type="hidden" name="idJelovnik" value="<%=idJelovnik%>">
				<input type="hidden" name="idKarte" value="<%=idKarte %>">
				<input type="hidden" name="idRestoran" value="<%=idRestoran%>">
				<td><input class="dugme" type="submit" value="Poruci"></td>
				</form>
				
			<%
				}
			%>
			</tr>
			</table>
		</div>
		
<div>		
		<h3 class=sedmo>Karta pica restorana <%=naziv%></h3>
		
		<p class=sedmo>
<%
				if (odgovor != null) {
					if (odgovor.equals("2")) {%>
					<blink style="color: green; padding-top: -100px;">Porucili ste pice.</blink>
					<%}
				}%></p>
				
		<table class=tabela5>
			<tr>
				<th class=aha>Naziv</th>
				<th class=aha>Opis</th>
				<th class=aha>Cena</th>
			</tr>

				<%
				for (Pice p : pice) {
			%>
			<tr>
				<td><%=p.getNaziv()%></td>
				<td class="dodatak"><%=p.getOpis() %></td>
				<td class="dodatak"><%=p.getCijena() %></td>
				
				<form action=PoruciPice>
				<input type="hidden" name="email" value="<%=email%>">
				<input type="hidden" name="nazivPica1" value="<%=p.getNaziv()%>">
				
				<input type="hidden" name="naziv" value="<%=naziv %>">
				<input type="hidden" name="datum" value="<%=datum %>">
				<input type="hidden" name="vreme" value="<%=vreme%>">
				<input type="hidden" name="sati" value="<%=sati%>">
				<input type="hidden" name="sto" value="<%=sto%>">
				<input type="hidden" name="ja" value="<%=id1%>">
				<input type="hidden" name="idJelovnik" value="<%=idJelovnik%>">
				<input type="hidden" name="idKarte" value="<%=idKarte %>">
				<input type="hidden" name="idRestoran" value="<%=idRestoran%>">
				<td><input class="dugme" type="submit" value="Poruci"></td>
				</form>
				</form>
			<%
				}
			%>
			</tr>
			</table>
			</div>

</body>
</html>