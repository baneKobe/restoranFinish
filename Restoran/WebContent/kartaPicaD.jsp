<%@page import="java.util.Date"%>
<%@page import="daoDejan.KorisnikDAO"%>
<%@page import="daoDejan.RestoranDAO"%>
<%@page import="daoDejan.KartaPicaDAO"%>
<%@page import="klaseDejan.Korisnik"%>
<%@page import="klaseDejan.Restoran"%>
<%@page import="klaseDejan.Jelovnik"%>
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
	String email= request.getParameter("email");
	String idRestoran = request.getParameter("idRestoran");
	String idKarte = request.getParameter("idKarte");
	KorisnikDAO korDAO = new KorisnikDAO();
	Korisnik korisnik=null;
	if(email != null){
		Korisnik korisnik1 = korDAO.KorisnikEmail(email);
		korisnik = korisnik1;
	}
	int id1 = korisnik.getIdKor();
	RestoranDAO rDAO = new RestoranDAO();
	Restoran restoran =rDAO.RestoranID(idRestoran);
	KartaPicaDAO kpDAO= new KartaPicaDAO();
	List<Pice> pice= kpDAO.GetKartaPicaByID(idKarte);
	String naziv = restoran.getNazivRest();

%>
<ul class=prvo>
  <li><a class="active" href="restoran.jsp?email=<%=email %>">Restorani</a></li>
  <li><a href="prijatelji.jsp?email=<%=email %>&ja=<%=id1%>">Prijatelji</a></li>
  <li><input type="hidden" name="email" value="<%=email%>">
  <li><a href="nalogKorisnika.jsp?email=<%=email %>">Moj nalog</a></li>
  <li><a href="posete.jsp?email=<%=email%>&ja=<%=id1%>">Moje posete</a></li>
  <li style="float:right"><a href="Logout">Odjavi se</a></li>
</ul>


<h3>Karta pica restorana <%=naziv%></h3>
		<table class=tabela2>
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

				</form>
			<%
				}
			%>
			</tr>
			</table>
			
		<br><br>
			
		<tr>
			<input type="hidden" name="email" value="<%=email%>">
			<td class="tabela"><input type=button value="Nazad" 
				onclick="location.href='restoran.jsp?email=<%=email %>';" class="dugme">
		</tr>


</body>
</html>