<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Restoran" %>
<%@page import="dao.RestoranDao" %>
<%@page import="java.util.List" %>
<%@page import="java.sql.Statement" %>
<%@page import="util.ConnectionManager" %>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Restoran</title>
<meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="styles.css">
   <link rel="stylesheet" href="cssfajl.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="script.js"></script>
</head>
<body>
<% String email = request.getParameter("email");%>
<div class="meni">
<div id='cssmenu'>
<ul>
   <li><a href='MenadzerSistema.jsp?email=<%=email %>'><span>Home</span></a></li>
   <li class='active has-sub'><a href='#'><span>Restoran</span></a>
      <ul>
         <li><a href='RegisterRestoran.jsp?email=<%=email %>'><span>Dodavanje</span></a>
         </li>
         <li><a href='RestoraniPrikaz.jsp?email=<%=email %>'><span>Prikaz svih</span></a>
         </li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Menadzer Restorana</span></a>
      <ul>
         <li><a href='MenadzerRestoranaReg.jsp?email=<%=email %>'><span>Dodavanje</span></a>
         </li>
         <li><a href='MenadzeriRestoranaPrikaz.jsp?email=<%=email %>'><span>Prikaz svih</span></a>
         </li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Ponudjac</span></a>
      <ul>
         <li><a href='PonudjacReg.jsp?email=<%=email %>'><span>Dodavanje</span></a>
         </li>
         <li><a href='PonudjaciPrikaz.jsp?email=<%=email %>'><span>Prikaz svih</span></a>
         </li>
      </ul>
   </li>
   <li><a href='#'><span>Update profile</span></a></li>
   <li class='last'><a href='logout'><span>Logout</span></a></li>
</ul>
</div>
</div>
<div class="template">
<%
int idRest = Integer.parseInt(request.getParameter("idRest"));
RestoranDao resDao = new RestoranDao();
Restoran restoran = null;
Restoran restoran1 = resDao.GetRestoranById(idRest);
restoran = restoran1;
String naziv= restoran.getNazivRest();
String vrsta= restoran.getVrstaRest();
String jelovnik= restoran.getJelovnik().getNazivJelovnika();
String kartaPica= restoran.getKartapica().getNaziv();

%>
<table class="tabela">
				<form action="UpdateRestoran">
					<tr class="red">
						<td class="polje">Naziv:</td> <td class="polje"> <input type="text" name="naziv" value="<%=naziv%>" class="unos" title="Polje za naziv ne moze biti prazno. Ime moze da sadrzi samo slova." required pattern="[a-zA-Z\s]+"></td>
					</tr>
					<tr class="red">
						<td class="polje">Vrsta:</td> <td class="polje">  <input type="text" name="vrsta" value="<%=vrsta%>" class="unos" title="Polje za prezime ne moze biti prazno i moze da sadrzi samo slova." required pattern="[a-zA-Z\s]+"></td>
					</tr>
					<tr class="red">
						<td class="polje">Jelovnik:</td> <td class="polje">  <%
	try{
Statement stmt;
String query = "select distinct idJelovnik, naziv from jelovnik";
stmt = ConnectionManager.getConnection().createStatement();
ResultSet rset = stmt.executeQuery(query);
%>
	<select name="idJelovnik" class="selekt">
	<option disabled selected value> -- izaberite jelovnik -- </option>
        <%  while(rset.next()){ %>
            <option><%= rset.getString(2)%></option>
        <% } %>
        </select>
        <%
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%></td>
					</tr>
					<tr class="red">
						<td class="polje">Karta Pica:</td> <td class="polje">  <%
	try{
Statement stmt;
String query = "select distinct idKarta, naziv from kartapica";
stmt = ConnectionManager.getConnection().createStatement();
ResultSet rset = stmt.executeQuery(query);
%>
	<select name="idKarta" class="selekt">
	<option disabled selected value> -- izaberite kartu pica -- </option>
        <%  while(rset.next()){ %>
            <option><%= rset.getString(2)%></option>
        <% } %>
        </select>
        <%
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
</td>
					</tr>
					<tr>
					<input type="hidden" name="idRestoran" value="<%=idRest%>">
					<input type="hidden" name="email" value="<%=email%>">
					</tr>
					<tr class="red">
					 <td><input type="submit" value="Update" class="dugmic"></td>
					  </tr>
					  </form>
				</table>
				
</div>
</body>
</html>