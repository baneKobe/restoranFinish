<%@page import="java.util.List" %>
<%@page import="util.ConnectionManager" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.ResultSet" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrovanje restorana</title>
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
   <li><a href='UpdateMenadzerSistema.jsp?email=<%=email %>'><span>Update profile</span></a></li>
   <li class='last'><a href='logout'><span>Logout</span></a></li>
</ul>
</div>
</div>
<div class="template">
<div class="znak">
<img src="resto.png" alt="Slika nece da se ucita" class="slika">
</div>
<br>
<br>
<br>
<div class="fild">
<form action="RegisterRestoran">
<input type="text" name="naziv" placeholder="Naziv restorana" title="Polje za naziv ne moze biti prazno. Naziv moze da sadrzi samo slova." required pattern="[a-zA-Z\s]+" class="centar" required autofocus>
<br>
<br>
<br>
<input type="text" name="vrsta" placeholder="Vrsta restorana" title="Polje za vrstu restorana ne moze biti prazno. Vrsta moze da sadrzi samo slova." required pattern="[a-zA-Z\s]+" class="centar" required>
<br>
<br>
<br>
<div class="polje2">
	<%
	try{
Statement stmt;
String query = "select distinct idJelovnik, naziv from jelovnik";
stmt = ConnectionManager.getConnection().createStatement();
ResultSet rset = stmt.executeQuery(query);
%>
	<select name="idJelovnik" class="selekt">
	<option disabled selected value> -- izaberite jelovnik -- </option>
        <%  while(rset.next()){ %>
            <option><%= rset.getString(1)%><%= rset.getString(2)%></option>
        <% } %>
        </select>
        <%
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
	</div>

<div class="polje2">
	<%
	try{
Statement stmt;
String query = "select distinct idKarta, naziv from kartapica";
stmt = ConnectionManager.getConnection().createStatement();
ResultSet rset = stmt.executeQuery(query);
%>
	<select name="idKarta" class="selekt">
	<option disabled selected value> -- izaberite kartu pica -- </option>
        <%  while(rset.next()){ %>
            <option><%= rset.getString(1)%><%= rset.getString(2)%></option>
        <% } %>
        </select>
        <%
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
%>
	</div>
	<input type="hidden" name="email" value=<%=email %>>
<br>
<br>
<br>
<input type="submit" value="Register" class="dugmad">
<input type="reset" value="Reset" class="dugmad">
</form>
</div>
</div>
</body>
</html>