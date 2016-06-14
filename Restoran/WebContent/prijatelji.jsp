<%@page import="java.util.Date"%>
<%@page import="daoDejan.KorisnikDAO"%>
<%@page import="daoDejan.PrijateljDAO"%>
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
	String msg = request.getParameter("msg");
	String username = request.getParameter("username");
	String prezime = request.getParameter("prezime");
	String email = request.getParameter("email");
	String bilokako =request.getParameter("ja");
	int ja=Integer.parseInt(bilokako);
	
	PrijateljDAO prijDAO = new PrijateljDAO();
	KorisnikDAO korDAO = new KorisnikDAO();
	List<Korisnik> kor = prijDAO.PrikazPrijatelja(ja);
	Korisnik korisnik = null;
	if(email != null){
		Korisnik korisnik1 = korDAO.KorisnikEmail(email);
		korisnik = korisnik1;
	}
	Korisnik k1=korDAO.KorisnikEmail(email);
	int id1=k1.getIdKor();
%>

	<ul class=prvo>
		<li><a href="restoran.jsp?email=<%=email %>">Restorani</a></li>
		<li><a class="active" href="">Prijatelji</a></li>
		<li><input type="hidden" name="email" value="<%=email%>">
		<li><a href="nalogKorisnika.jsp?email=<%=email %>">Moj nalog</a></li>
		<li><a href="posete.jsp?email=<%=email%>&ja=<%=id1%>">Moje posete</a></li>
		<li style="float: right"><a href="Logout">Odjavi se</a></li>
	</ul>


	<h3>Prijatelji:</h3>
	
	<%
		if (msg != null) {
			if (msg.equals("1")) {
	%><blink style="color: green; padding-top: -100px;">Prijatelj je izbrisan.</blink>
	<%
			}
		}
	%>
	
	<table class=tabela2>
		<tr>
			<th class=aha>Ime</th>
			<th class=aha>Prezime</th>
			<th class=aha>Email</th>
			<th class=aha></th>

		</tr>
		<td>
			<form action="prijateljSortiranoPoImenuASC.jsp?email=<%=email %>&j=<%=id1%>">
				<input type="hidden" name="email" value="<%=email%>">
				<input type="hidden" name="j" value="<%=id1 %>">
				<input type="submit" value="Sortiraj" class="dugme">
			</form>
		</td>

		<td>
			<form action="prijateljSortiranoPoPrezimenuASC.jsp?email=<%=email %>&j=<%=id1%>">
				<input type="hidden" name="email" value="<%=email%>">
				<input type="hidden" name="j" value="<%=id1 %>">
				<input type="submit" value="Sortiraj" class="dugme">
			</form>
		</td>
		
		<td>
			<form action="prijateljSortiranoPoEmailASC.jsp?email=<%=email %>&j=<%=id1%>">
				<input type="hidden" name="email" value="<%=email%>">
				<input type="hidden" name="j" value="<%=id1 %>">
				<input type="submit" value="Sortiraj" class="dugme">
			</form>
		</td>
		</tr>


		<%
				for (Korisnik k : kor) {
			%>
		<tr>
			<form action="IzbrisiPrijatelja">
			<td><%=k.getUsername()%></td>
			<td><%=k.getPrezime() %></td>
			<td><%=k.getEmail()%></td>
			<td><input class="dugme" type="submit" value="Izbrisi"></td>
			<td><input type="hidden" name="p" value="<%=k.getIdKor() %>">
			<input type ="hidden" name ="imePrijatelja" value="<%=k.getUsername() %>">
			<input type="hidden" name="prezimePrijatelja" value="<%=k.getPrezime() %>">
			<input type="hidden" name="email" value="<%=k.getEmail() %>">
			<input type="hidden" name="j" value="<%=id1 %>">
			<input type="hidden" name="email2" value="<%=email%>"></td>
			</form>
<%} %>

		</tr>
	</table>

</body>
</html>