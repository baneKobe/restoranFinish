<%@page import="java.util.Date"%>
<%@page import="daoDejan.RestoranDAO"%>
<%@page import="daoDejan.KorisnikDAO"%>
<%@page import="klaseDejan.Restoran"%>
<%@page import="klaseDejan.Korisnik"%>
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
	RestoranDAO restoranDAO = new RestoranDAO();
	List<Restoran> restoran = restoranDAO.SortiranjeRestoranaPoNazivuASC();
	String email = request.getParameter("email");
	KorisnikDAO korDAO = new KorisnikDAO();
	Korisnik korisnik=null;
	if(email != null){
		Korisnik korisnik1 = korDAO.KorisnikEmail(email);
		korisnik = korisnik1;
	}
	int id1 = korisnik.getIdKor();
%>

<ul class=prvo>
  <li><a class="active" href="restoran.jsp?email=<%=email %>">Restorani</a></li>
  <li><a href="prijatelji.jsp?email=<%=email %>&ja=<%=id1%>">Prijatelji</a></li>
  <li><input type="hidden" name="email" value="<%=email%>">
  <li><a href="nalogKorisnika.jsp?email=<%=email %>">Moj nalog</a></li>
  <li><a href="posete.jsp?email=<%=email%>&ja=<%=id1%>">Moje posete</a></li>
  <li style="float:right"><a href="Logout">Odjavi se</a></li>
</ul>


<div class="cetvrto">
			<div>
			<form action="pretragaRestorana.jsp?email=<%=email %>">
			<li><input type="hidden" name="email" value="<%=email%>"></li>
				<tr>
				<td class="tabela">Naziv:</td><td><input type="search"
				title="Maziv restorana moze da sadrzi samo slova."
				name="nazivRest"  pattern="[a-zA-Z]+" placeholder="Unesite naziv restorana"></td>

				<td class="tabela">Vrsta:</td><td><input type="search"
				title="Vrsta moze da sadrzi samo slova."
				name="vrstaRest"  pattern="[a-zA-Z]+" placeholder="Unesite vrstu restorana"></td>
				<td><input type="submit" value="Pretrazi" class="dugmad"></td>
				</tr>
			</form>
			</div>
		</div>

<h3>Restorani:</h3>
		<table class=tabela2>
			<tr>
				<th class=aha>Naziv</th>
				<th class=aha>Vrsta</th>
				<th class=aha>Jelovnik</th>
				<th class=aha>Karta pica</th>
				<th class=aha></th>
				</tr>
				<tr><td>
					<form action="restoranSortiranoPoNazivuDESC.jsp?email=<%=email %>">
					  <input type="hidden" name="email" value="<%=email%>">
						<input type="submit" value="Sortiraj" class="dugme">
					</form>
				</td>
				
				<td>
					<form action="restoranSortiranoPoVrstiASC.jsp?email=<%=email %>">
					  <input type="hidden" name="email" value="<%=email%>">
						<input type="submit" value="Sortiraj" class="dugme">
					</form>
				</td></tr>

				<%
				for (Restoran r : restoran) {
			%>
			<tr>
				<td><%=r.getNazivRest()%></td>
				<td><%=r.getVrstaRest()%></td>
				
				<form action=jelovnikD.jsp>
				<input type="hidden" name="idJelovnik" value="<%=r.getJelovnik()%>">
				<input type="hidden" name="idRestoran" value="<%=r.getIdRestorana() %>">
				<input type="hidden" name="email" value="<%=email%>">
				<td><input class="dugme" type="submit" value="Jelovnik"></td>
				</form>
				
				<form action=kartaPicaD.jsp>
				<input type="hidden" name="idKarte" value="<%=r.getKartaPica() %>">
				<input type="hidden" name="idRestoran" value="<%=r.getIdRestorana() %>">
				<input type="hidden" name="email" value="<%=email%>">
				<td><input class="dugme" type="submit" value="Karta pica"></td>
				</form>
				
				
				<form action="rezervacijaRestorana.jsp?id=<%=r.getIdRestorana()%>">
				<td>
				<input type="hidden" name="naziv" value="<%=r.getNazivRest() %>">
				<input type="hidden" name="email" value="<%=email%>">
				<input type="hidden" name="idJelovnik" value="<%=r.getJelovnik()%>">
				<input type="hidden" name="idKarte" value="<%=r.getKartaPica() %>">
				<input type="hidden" name="idRestoran" value="<%=r.getIdRestorana() %>">
				<input type="submit" class="dugme" value="Rezervisi"></td>
				</form>
			<%
				}
			%>
			</tr>
			</table>
</body>
</html>