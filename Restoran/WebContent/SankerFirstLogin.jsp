<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Sanker"%>
<%@page import="dao.SankerDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="cssfajl.css">
<title>Sanker first login</title>
</head>
<body>
<h1>Promjena Lozinke:</h1>
<% 
String email = request.getParameter("email");
SankerDao sankDao = new SankerDao();
Sanker sanker = null;
if(email != null){
	Sanker sanker1 = sankDao.GetSankerByEmail(email);
	sanker = sanker1;
}
else{
	System.out.println("Nije preuzet email");
}
%>
<div class="fild">
<form action="SankerFirstLogin">
<label class="centar">Stara lozinka je: <%= sanker.getPassword()%></label>
<br>
<br>
<br>
<br>
<label>Unesite novu lozinku</label>
<br>
<br>
<input type="text" name="password" value="<%= sanker.getPassword()%>" class="centar">
<br>
<input type="hidden" name="idSanker" value="<%= sanker.getIdKSanker()%>">
<input type="hidden" name="brPristupa" value="<%= sanker.getPristup()%>">
<br>
<input type="submit" value="Update" class="dugme">
</form>
</div>
</body>
</html>