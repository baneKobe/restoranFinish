<%@page import="dao.SankerDao"%>
<%@page import="model.Sanker"%>
<!DOCTYPE html>
<html>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sanker</title>
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
<%String email = request.getParameter("email"); %>
	<div class="meni">
<div id='cssmenu'>
<ul>
   <li><a href='SankerProfile.jsp?email=<%=email %>'><span>Home</span></a></li>
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
   <li><a href='UpdateSanker.jsp?email=<%=email %>'><span>Update profile</span></a></li>
   <li><a href='#'><span>Raspored rada</span></a></li>
   <li class='last'><a href='logout'><span>Logout</span></a></li>
</ul>
</div>
</div>
<div class="template">
<%
SankerDao sankDao = new SankerDao();
Sanker sanker = null;
if(email != null){
	Sanker sanker1 = sankDao.GetSankerByEmail(email);
	sanker = sanker1;
}
String ime = sanker.getImeSanker();
String prezime = sanker.getPrezimeSanker();
int konBr = sanker.getKonfekcijskiBr();
String datum = sanker.getDatumRodjenja();
String velicina = sanker.getVelicinaObuce();
String mejl = sanker.getEmail();
String password = sanker.getPassword();
int id = sanker.getIdKSanker();
String izmenjeno=request.getParameter("izmenjeno");
%>
				<table class="tabela">
				<form action="UpdateSanker">
				<%
				if(izmenjeno!=null){
					if(izmenjeno.equals("1")){ 
						%><div class="alert alert-success">
    <strong>Uspjesno!</strong> Uspjesno ste izmijenili podatke o sankeru.</div><%
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
					<input type="hidden" name="idSanker" value="<%=id%>">
					<tr class="red">
					 <td><input type="submit" value="Update" class="dugmic"></td>
					  </tr>
				</table>
				</form>
				</div>
	</body>
</html>