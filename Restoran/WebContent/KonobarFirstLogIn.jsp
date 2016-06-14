<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Konobar"%>
<%@page import="dao.KonobarDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="cssfajl.css">
<title>Konobar first login</title>
</head>
<body>
<h1>Promjena Lozinke:</h1>
<% 
String email = request.getParameter("email");
KonobarDao konDao = new KonobarDao();
Konobar konobar = null;
if(email != null){
Konobar konobar1 = konDao.GetKonobarByEmail(email);
konobar = konobar1;
}
else{
	System.out.println("Nije preuzet email");
}
%>
<div class="fild">
<form action="KonobarFirstLogIn">
<label class="centar">Stara lozinka je: <%= konobar.getPassword()%></label>
<br>
<br>
<br>
<br>
<label>Unesite novu lozinku</label>
<br>
<br>
<input type="text" name="password" value="<%= konobar.getPassword()%>" class="centar">
<br>
<input type="hidden" name="idKonobar" value="<%= konobar.getIdKonobar()%>">
<input type="hidden" name="brPristupa" value="<%= konobar.getBrPristupa()%>">
<br>
<input type="submit" value="Update" class="dugme">
</form>
</div>
</body>
</html>