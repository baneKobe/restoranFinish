<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Sanker"%>
    <%@page import="model.Restoran"%>
    <%@page import="dao.SankerDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
         <li><a href='PorudzbineSankerPrikaz.jsp?email=<%=email %>'><span>Primljene</span></a>
         </li>
         <li><a href='PrihvaceneSanler.jsp?email=<%=email %>'><span>Prihvacene</span></a>
         </li>
      </ul>
   </li>
   <li><a href='UpdateSanker.jsp?email=<%=email %>'><span>Update profile</span></a></li>
   <li><a href='#'><span>Raspored rada</span></a></li>
   <li class='last'><a href='Logout'><span>Logout</span></a></li>
</ul>
</div>
</div>
<div class="template">
<%int idPorudzbine = Integer.parseInt(request.getParameter("id")); %>
<table class="tabela">
				<form action="SankerGotovo">
				<tr class="red"><th colspan="2">Da li zelite da potvrdite zavrsenost porudzbine.</th>
				</tr>
				<tr class="red">
				<input type="hidden" name="porudzbina" value="<%=idPorudzbine %>">
				<input type="hidden" name="email" value="<%=email %>">
					 <td><input type="submit" value="Accept" class="myButton"></td></form>
					 <td><a href="PorudzbineSankerPrikaz.jsp?email=<%=email %>" class="myButton">Cancel</a></td>
				</tr>
				</table>
</div>
</body>
</html>