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
String odg = request.getParameter("odg");
String email = request.getParameter("email");
String idRestorana = request.getParameter("idRestorana");
KorisnikDAO korisnikDAO = new KorisnikDAO();
Korisnik korisnik = null;

if(email != null){
	Korisnik korisnik1 = korisnikDAO.KorisnikEmail(email);
	korisnik = korisnik1;
}
String username = korisnik.getUsername();
String prezime = korisnik.getPrezime();
String up = username+" "+prezime;
String ea = korisnik.getEmail();
int id1 = korisnik.getIdKor();
int broj= 1;

String bilokako =request.getParameter("ja");
int ja=Integer.parseInt(bilokako);
RestoranDAO resDAO = new RestoranDAO();
List<Restoran> restoran = resDAO.Posete(ja);

RestoranDAO rDAO=new RestoranDAO();
Restoran r1=null;
int ocenjeno=0;

for (Restoran r : restoran) {
	String aaa=r.getIdRestorana()+"";
	Restoran r2=rDAO.RestoranIDZaOcenu(aaa);
	if(r2!=null){
	
	if(r.getIdRestorana()==r2.getIdRestorana()){
		ocenjeno=1;
	}}else{
		ocenjeno=0;
	}
}
%>
<body>

<ul class=prvo>
  <li><a href="restoran.jsp?email=<%=email %>">Restorani</a></li>
  <li><a href="prijatelji.jsp?email=<%=email %>&ja=<%=id1%>">Prijatelji</a></li>
  <li><a href="nalogKorisnika.jsp?email=<%=email %>">Moj nalog</a></li>
  <li><a class="active" href="posete.jsp?email=<%=email%>&ja=<%=id1%>">Moje posete</a></li>
  <li style="float:right"><a href="Logout">Odjavi se</a></li>
</ul>

<%
	if (odg != null) {
		if (odg.equals("1")) {%>
			<blink style="color: green; padding-top: -100px;">Hvala vam na unetim ocenama.</blink>
		<%}
	}%>
<h3>Moje posete:</h3>
		<table class=tabela2>
			<tr>
				<th class=aha>Naziv restorana</th>
				<th class=aha>Datum posete</th>
				<th class=aha>Vreme rezervacije</th>
				<th class=aha>Duzina rezervacije</th>
				<th class=aha2></th>
				</tr>
		<%
				for (Restoran r : restoran) {
			%>
			<tr>
				<td><%=r.getNazivRest()%></td>
				<td class="dodatak"><%=r.getDatum()%></td>
				<td class="dodatak"><%=r.getSati() %>
				<td class="dodatak"><%=r.getDuzinaRezervacije() %>
				
				<form action=ocena.jsp>
					<input type="hidden" name="email" value="<%=email%>">
					<input type="hidden" name="idRestorana" value="<%=r.getIdRestorana()%>">
					<input type="hidden" name="ja" value="<%=id1%>">
					<%
						String aaa=r.getIdRestorana()+"";
						Restoran r2=rDAO.RestoranIDZaOcenu(aaa);
						if(r2!=null){
						
						if(r.getIdRestorana()==r2.getIdRestorana()){
							ocenjeno=1;
							%><td>Ocenjeno</td><%
						}}else{
							ocenjeno=0;
							%><td><input class="dugme" type="submit" value="Oceni"></td><%
						}
					%>
				</form>
			<%
				}
			%>
			</tr>
			</table>

	


</body>
</html>