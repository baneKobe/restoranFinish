<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet"  href="css.css" />
<link rel="stylesheet"  href="cssfajlDejan.css" />
</head>	

<%String greska=request.getParameter("error"); %>
<%String uspesno=request.getParameter("uspesno"); %>

<body>

<br>
<br>
<br>
<br>
<div class="field">
<h1>Registracija korisnika</h1>
<br>
<br>
<form action="Registracija">

  			<%
			if(uspesno!=null){
				if(uspesno.equals("1")){ 
					%><blink style="color: green; padding-top:-100px;">Aktivacioni mejl je poslat na vasu adresu</blink><%
				}
			}
			%>

  <input type="text" name="username" title="Polje za ime ne moze biti prazno. Ime moze da sadrzi samo slova."
   placeholder="Ime" required pattern="[a-zA-Z]+" class="centar"><br>
  <br>
  <input type="text" name="prezime" title="Polje za prezime ne moze biti prazno i moze da sadrzi samo slova."
   placeholder="Prezime" required pattern="[a-zA-Z]+" class="centar"><br>
  <br>
  <input type="email" name="email" title="Primer: characters@characters.domain"
   placeholder="Email adresa" required pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" class="centar">
  			<%
			if(greska!=null){
				if(greska.equals("1")){ 
					%><blink style="color: red; padding-top:-100px;">Email zauzet!</blink><%
				}
			}
			%> 
  <br>
  <br>
  <input title="Lozinka mora da sadrzi najmanje 6 karaktera ukljucujucii VELIKO/malo slovo i broj." type="password"
   required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" onchange="form.lozinka2.pattern = this.value;"
   name="lozinka" placeholder="lozinka" class="centar"><br>
  <br>
  <input title="Molimo vas unesite istu lozinku." type="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
   name="lozinka2" placeholder="lozinka" class="centar">
  <br>
  <br>
  <input type="submit" value="Registruj se" class="dugmad">
  <input type="reset" value="Resetuj" class="dugmad">
  
  

<br><br><br>

    <input type=button value="Nazad" onclick="location.href='login.jsp';" class="dugmad">


</form>
</div>
</body>
</html>