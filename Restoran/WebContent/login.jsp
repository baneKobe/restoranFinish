<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="cssfajlDejan.css">
</head>

<%
	String odgovor = request.getParameter("odgovor");
	String potvrdjeno = request.getParameter("potvrdjeno");
	String otkazano = request.getParameter("otkazano");
%>

<!--<script>
	if(<%=odgovor%>=="1"){
		alert("greska");
	}
</script>  -->

<body>
	<div class="znak">
		<img src="resto.png" alt="Slika nece da se ucita" class="slika">
	</div>
	<br>
	<br>
	<br>
	<div class="fild">
		<form action="Login">
			<%
				if (potvrdjeno != null) {
					if (potvrdjeno.equals("true")) {
			%><blink style="color: green; padding-top: -100px;">Uspesno ste verifikovali mejl. Mozete se ulogovati.</blink>
			<%
				}
				}
			%>
			
						<%
				if (otkazano != null) {
					if (otkazano.equals("true")) {
			%><blink style="color: red; padding-top: -100px;">Otkazana verifikacija.</blink>
			<%
				}
				}
			%>


			<input type="email" name=email placeholder="email adresa"
				class="centar" required>

			<%
				if (odgovor != null) {
					if (odgovor.equals("1")) {
			%><blink style="color: red; padding-top: -100px;">Pogresan
				email</blink>
			<%
				}
				}
			%>

			<br> <br> <br> <input type="password" name="lozinka"
				placeholder="Lozinka" class="centar" required>
			<%
				if (odgovor != null) {
					if (odgovor.equals("2")) {
			%><blink style="color: red; padding-top: -100px;">Pogresna
				lozinka</blink>
			<%
				}
				}
			%>

			<br> <br> <br> <input type="submit" value="Prijavi se"
				class="dugme">

		</form>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>



	<form action="registracija.jsp">
		<input type="submit" value="Registracija" class="dugmad">
	</form>
	<input type="submit" value="Prijavi se preko Google+"
		onclick="location.href='https://mail.google.com/';" class="dugmad">
	<input type="submit" value="Prijavi se preko Facebook"
		onclick="location.href='https://facebook.com/';" class="dugmad">


</body>
</html>