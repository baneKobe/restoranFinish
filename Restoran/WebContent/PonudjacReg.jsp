<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Statement" %>
<%@page import="util.ConnectionManager" %>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrovanje Ponudjaca</title>
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
         <li><a href='RestoraniPrikaz.jsp'><span>Prikaz svih</span></a>
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
<div class="fild">
<form action="PonudjacReg">
<input type="text" name="imePonudjac" placeholder="Ime" title="Polje za ime ne moze biti prazno. Ime moze da sadrzi samo slova." required pattern="[a-zA-Z]+" class="centar" required autofocus>
<br>
<br>
<br>
<input type="text" name="prezimePonudjac" placeholder="Prezime" title="Polje za prezime ne moze biti prazno i moze da sadrzi samo slova." required pattern="[a-zA-Z]+"class="centar" required>
<br>
<br>
<br>
<input type="text" name="kompanija" placeholder="Naziv Kompanije" title="Polje za naziv kompanije ne moze biti prazno i moze da sadrzi samo slova i razmake." required pattern="[a-zA-Z\s]+"class="centar" required>
<br>
<br>
<br>
<input type="text" name="mejl" placeholder="Email" title="Primer: characters@characters.domain" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" class="centar" required>
<input type="hidden" name="email" value=<%=email %>>
<br>
<br>
<br>
<input title="Lozinka mora da sadrzi najmanje 6 karaktera ukljucujucii VELIKO/malo slovo i broj." type="password"
   required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" onchange="form.lozinka2.pattern = this.value;"
   name="password" placeholder="password" class="centar" required>
<br>
<br>
<br>
<input title="Molimo vas unesite istu lozinku." type="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" name="lozinka2" placeholder="repeat password" class="centar" required>
<br>
<br>
<br>
<input type="text" name="adresa" placeholder="Adresa" title="Polje za adresu ne moze biti prazno." class="centar" required>
<br>
<br>
<br>
<input type="text" name="telefon" placeholder="Broj Telefona" title="Polje za naziv kompanije ne moze biti prazno." class="centar" required>
<br>
<br>
<br>   
<input type="submit" value="Register" class="dugmad">
<input type="reset" value="Reset" class="dugmad">
</form>
</div>
</body>
</html>