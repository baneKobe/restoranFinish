<%@page import="java.util.Date"%>
<%@page import="daoDejan.KorisnikDAO"%>
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
		String odg = request.getParameter("odg");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String prezime = request.getParameter("prezime");
		KorisnikDAO korDAO = new KorisnikDAO();
		List<Korisnik> kor = korDAO.PretragaKorisnika(username, prezime);
		Korisnik k1 = korDAO.KorisnikEmail(email);
		int id1 = k1.getIdKor();
	%>
	<ul class=prvo>
		<li><a href="restoran.jsp?email=<%=email%>">Restorani</a></li>
		<li><a href="prijatelji.jsp?email=<%=email%>&ja=<%=id1%>">Prijatelji</a></li>
		<li><input type="hidden" name="email" value="<%=email%>"></li>
		<li><a class="active" href="nalogKorisnika.jsp?email=<%=email%>">Moj nalog</a></li>
		<li><a href="posete.jsp?email=<%=email%>&ja=<%=id1%>">Moje posete</a></li>
		<li style="float: right"><a href="Logout">Odjavi se</a></li>
	</ul>

	<h3>Korisnici:</h3>

	<%
		if (odg != null) {
			if (odg.equals("1")) {
	%><blink style="color: red; padding-top: -100px;">Ne mozete dodati sami sebe.</blink>
	<%
			}
			else if(odg.equals("2")){
				%><input type="hidden" name="username" value="<%=username%>">
				<blink style="color: green; padding-top: -100px;">Dodali ste korisnika.</blink><%
			}
		}
				%>


	<table class=tabela2>
		<tr>
			<th class=aha>Ime</th>
			<th class=aha>Prezime</th>
			<th class=aha>email</th>
			<th class=aha></th>
		</tr>
		<%
			for (Korisnik k : kor) {
		%>
		<tr>
			<form action="DodajPrijatelja">
				<td><%=k.getUsername()%></td>
				<td><%=k.getPrezime()%></td>
				<td><%=k.getEmail()%></td>
				<td><input class="dugme" type="submit" value="Dodaj"></td>

				<td><input type="hidden" name="p" value="<%=k.getIdKor()%>">
					<input type="hidden" name="imePrijatelja"
					value="<%=k.getUsername()%>"> <input type="hidden"
					name="prezimePrijatelja" value="<%=k.getPrezime()%>"> <input
					type="hidden" name="email" value="<%=k.getEmail()%>"> <input
					type="hidden" name="j" value="<%=id1%>"> <input
					type="hidden" name="email2" value="<%=email%>"> <input
					type="hidden" name="username" value="<%=username%>"> <input
					type="hidden" name="prezime" value="<%=prezime%>"></td>
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
				onclick="location.href='nalogKorisnika.jsp?email=<%=email %>';" class="dugme">
		</tr>

</body>
</html>