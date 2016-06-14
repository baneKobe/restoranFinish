<%@page import="daoDejan.KorisnikDAO"%>
<%@page import="klaseDejan.Korisnik"%>
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

%>
<body>


<ul class=prvo>
  <li><a href="restoran.jsp?email=<%=email %>">Restorani</a></li>
  <li><a href="prijatelji.jsp?email=<%=email %>&ja=<%=id1%>">Prijatelji</a></li>
  <li><a class="active" href="">Moj nalog</a></li>
  <li><a href="posete.jsp?email=<%=email%>&ja=<%=id1%>">Moje posete</a></li>
  <li style="float:right"><a href="Logout">Odjavi se</a></li>
</ul>


		<div>
			<img alt="slika" src="profile-img.jpg">
		</div>
		<div class="drugo">
			<div>
				<table>
					<tr >
						<td class="tabela">Ime i prezime: <%=up%></td>
					</tr>
					<tr>
						<td class="tabela">Email adresa: <%=ea%></td>
					</tr>
					<tr>
					<input type="hidden" name="email" value="<%=email%>">
						<td class="tabela"><input type=button value="Izmeni podatke" 
						onclick="location.href='izmeni.jsp?email=<%=email %>';" class="dugmad">
					</tr>
				</table>
			</div>
			
		</div>
		<div class="trece">
			<div>
			<form action="pretraga.jsp?email=<%=email %>">
			<li><input type="hidden" name="email" value="<%=email%>"></li>
				<tr>
				<td class="tabela">Ime:</td><td><input type="search"
				title="Ime moze da sadrzi samo slova."
				name="username"  pattern="[a-zA-Z]+" placeholder="Unesite ime"></td>

				<td class="tabela">Prezime:</td><td><input type="search"
				title="Prezime moze da sadrzi samo slova."
				name="prezime"  pattern="[a-zA-Z]+" placeholder="Unesite prezime"></td>
				<td><input type="submit" value="Pretrazi" class="dugmad"></td>
				</tr>
			</form>
			</div>
		</div>
	</body>
</html>