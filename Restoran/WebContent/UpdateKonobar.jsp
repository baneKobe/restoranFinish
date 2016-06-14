<%@page import="dao.KonobarDao"%>
<%@page import="model.Konobar"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Konobar</title>
<meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="styles.css">
   <link rel="stylesheet" href="cssfajl.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="script.js"></script>
   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</head>
	<body>
<% String email = request.getParameter("email");%>
<div class="meni">
<div id='cssmenu'>
<ul>
   <li><a href='KonobarProfile.jsp?email=<%=email %>'><span>Home</span></a></li>
   <li class='active has-sub'><a href='#'><span>Porudzbine</span></a>
      <ul>
         <li><a href='#'><span>Gotove</span></a>
         </li>
         <li><a href='#'><span>Primljene</span></a>
         </li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Racun</span></a>
      <ul>
         <li><a href='#'><span>Formiranje</span></a>
         </li>
         <li><a href='#'><span>Prikaz svih</span></a>
         </li>
		 <li><a href='#'><span>Prihod</span></a>
         </li>
      </ul>
   </li>
   <li><a href='UpdateKonobar.jsp?email=<%=email %>'><span>Update profile</span></a></li>
   <li><a href='#'><span>Raspored rada</span></a></li>
   <li class='last'><a href='logout'><span>Logout</span></a></li>
</ul>
</div>
</div>
<div class="template">
<%
KonobarDao konDao = new KonobarDao();
Konobar konobar = null;
if(email != null){
	Konobar konobar1 = konDao.GetKonobarByEmail(email);
	konobar = konobar1;
}
String ime = konobar.getImeKonobar();
String prezime = konobar.getPrezimeKonobar();
int konBr = konobar.getKonfekcijskiBr();
String datum = konobar.getDatumRodjenja();
String velicina = konobar.getVelicinaObuce();
String mejl = konobar.getEmail();
String password = konobar.getPassword();
int id = konobar.getIdKonobar();
String izmenjeno=request.getParameter("izmenjeno");
%>
				<table class="tabela">
				<form action="UpdateKonobar">
				<%
				if(izmenjeno!=null){
					if(izmenjeno.equals("1")){ 
						%><div class="alert alert-success">
    <strong>Uspjesno!</strong> Uspjesno ste izmijenili podatke o konobaru.</div><%
					}
				}
			%>
					<tr class="red">
						<td class="polje">Ime:</td> <td class="polje"> <input type="text" name="ime" value="<%=ime%>" class="unos"></td>
					</tr>
					<tr class="red">
						<td class="polje">Prezime:</td> <td class="polje">  <input type="text" name="prezime" value="<%=prezime%>" class="unos"></td>
					</tr>
					<tr class="red">
						<td class="polje">Konfekcijski broj:</td> <td class="polje">  <input type="text" name="konfekcijskiBr" value="<%=konBr%>" class="unos"></td>
					</tr>
					<tr class="red">
						<td class="polje">Datum Rodjenja:</td> <td class="polje">  <input type="text" name="datumRodjenja" value="<%=datum%>" class="unos"></td>
					</tr>
					<tr class="red">
						<td class="polje">Velicina obuce:</td> <td class="polje">  <input type="text" name="velicinaObuce" value="<%=velicina%>" class="unos"></td>
					</tr>
					<tr class="red">
						<td class="polje">Email:</td> <td class="polje">  <input type="text" name="email" value="<%=mejl%>" class="unos"></td>
					</tr>
					<tr class="red">
						<td class="polje">Password:</td> <td class="polje"> <input type="password" name="password" value="<%=password%>" class="unos"></td>
					</tr>
					<input type="hidden" name="idKonobar" value="<%=id%>">
					<tr class="red">
					 <td><input type="submit" value="Update" class="dugmic"></td>
					 <td><input type="reset" value="Reset" class="dugmic"></td>
					  </tr>
				</table>
				</form>
				</div>
	</body>
</html>