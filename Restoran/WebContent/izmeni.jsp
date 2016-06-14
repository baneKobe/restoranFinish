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
String lozinka = korisnik.getLozinka();
String up = username+" "+prezime;
String ea = korisnik.getEmail();
int id1 = korisnik.getIdKor();
int broj= 1;
String izmenjeno=request.getParameter("izmenjeno");
%>


<ul class=prvo>
  <li><a href="restoran.jsp?email=<%=email %>">Restorani</a></li>
  <li><a href="prijatelji.jsp?email=<%=email %>&ja=<%=id1%>">Prijatelji</a></li>
  <li><a class="active"  href="nalogKorisnika.jsp?email=<%=email %>">Moj nalog</a></li>
  <li><a href="posete.jsp?email=<%=email%>&ja=<%=id1%>">Moje posete</a></li>
  <li style="float:right"><a href="Logout">Odjavi se</a></li>
</ul>


		<div>
			<img alt="slika" src="profile-img.jpg">
		</div>
		
		<div class="drugo">
			<div>
			<form action="Izmena">
			
			<%
				if(izmenjeno!=null){
					if(izmenjeno.equals("1")){ 
						%><blink style="color: green;">Uspesno ste izmenili podatke</blink><%
					}
				}
			%>
			
				<table>
					<tr>
						<td class="tabela">Ime i prezime:</td><td><input type="text"
						title="Polje za ime ne može biti prazno. Ime može da sadrži samo slova."
						name="username" required pattern="[a-zA-Z]+" value="<%=username%>"></td>
						<td><input type="text" title="Polje za prezime ne može biti prazno. Ime može da sadrži samo slova."
						name="prezime" required pattern="[a-zA-Z]+" value="<%=prezime%>"></td>
					</tr>
					
					<tr>
						<td class="tabela">Email adresa:</td><td><input type="text"
						title="Primer: characters@characters.domain"
						name="email" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" value="<%=ea%>"></td>
					</tr>
					
					<tr>
						<td class="tabela">Lozinka:</td><td><input type="password"
						title="Lozinka mora da sadrži najmanje 6 karaktera uključujući VELIKO/malo slovo i broj."
						required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" name="lozinka" value="<%=lozinka%>"></td>
					</tr>
					<tr>
						<td class="tabela">Lozinka:</td><td><input type="password"
						title="Molimo vas unesite istu lozinku."
						name="lozinka2" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" value="<%=lozinka%>"></td>
					</tr>
					<tr><td><input type="hidden" name="idKor" value="<%=id1%>"></td></tr>
					<tr>
					 <td><input type="submit" value="Izmeni" class="dugmad">
					 <td><input type=button value="Odustani" onclick="location.href='nalogKorisnika.jsp?email=<%=email %>&ja=<%=id1%>';"
					 class="dugmad"></td>
					  </tr>
				</table>
				</form>
			</div>
			
		</div>
	</body>
</html>