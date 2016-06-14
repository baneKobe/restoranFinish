<%@page import="dao.KuvarDao"%>
<%@page import="model.Kuvar"%>
<!DOCTYPE html>
<html>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Kuvar</title>
<meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="styles.css">
   <link rel="stylesheet" href="cssfajl.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="script.js"></script>
	</head>
	<body>
<%String email = request.getParameter("email"); %>
<div class="meni">
<div id='cssmenu'>
<ul>
   <li><a href='KuvarProfile.jsp?email=<%=email %>'><span>Home</span></a></li>
   <li class='active has-sub'><a href='#'><span>Porudzbine</span></a>
      <ul>
         <li><a href='#'><span>Gotove</span></a>
         </li>
         <li><a href='#'><span>Primljene</span></a>
         </li>
         <li><a href='#'><span>Prihvacene</span></a>
         </li>
      </ul>
   </li>
   <li><a href='UpdateKuvar.jsp?email=<%=email %>'><span>Update profile</span></a></li>
   <li><a href='#'><span>Raspored rada</span></a></li>
   <li class='last'><a href='logout'><span>Logout</span></a></li>
</ul>
</div>
</div>
<div class="template">
<%
KuvarDao kuvDao = new KuvarDao();
Kuvar kuvar = null;
if(email != null){
	Kuvar kuvar1 = kuvDao.GetKuvarByEmail(email);
	kuvar = kuvar1;
}
String ime = kuvar.getImeKuvar();
String prezime = kuvar.getPrezimeKuvar();
int konBr = kuvar.getKonfekcijskiBr();
String datum = kuvar.getDatumRodjenja();
String velicina = kuvar.getVelicinaObuce();
String mejl = kuvar.getEmail();
String password = kuvar.getPassword();
int id = kuvar.getIdKuvar();
System.out.println(id);
%>
				<table class="tabela">
				<form action="UpdateKuvar">
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
					<input type="hidden" name="idKuvar" value="<%=id%>">
					<tr class="red">
					 <td><input type="submit" value="Update" class="dugmic"></td>
					  </tr>
				</table>
				</form>
				</div>
	</body>
</html>