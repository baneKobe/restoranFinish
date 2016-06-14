<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Kuvar"%>
<%@page import="dao.KuvarDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="cssfajl.css">
<title>Kuvar first login</title>
</head>
<body>
<h1>Promjena Lozinke:</h1>
<% 
String email = request.getParameter("email");
KuvarDao kuvDao = new KuvarDao();
Kuvar kuvar = null;
if(email != null){
	Kuvar kuvar1 = kuvDao.GetKuvarByEmail(email);
kuvar = kuvar1;
}
else{
	System.out.println("Nije preuzet email");
}
%>
<div class="fild">
<form action="KuvarFirstLogin">
<label class="centar">Stara lozinka je: <%= kuvar.getPassword()%></label>
<br>
<br>
<br>
<br>
<label>Unesite novu lozinku</label>
<br>
<br>
<input type="text" name="password" value="<%= kuvar.getPassword()%>" class="centar">
<br>
<input type="hidden" name="idKuvar" value="<%= kuvar.getIdKuvar()%>">
<input type="hidden" name="brPristupa" value="<%= kuvar.getPristup()%>">
<br>
<input type="submit" value="Update" class="dugme">
</form>
</div>
</body>
</html>