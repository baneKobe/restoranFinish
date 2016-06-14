<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Konobar"%>
    <%@page import="model.Restoran"%>
    <%@page import="dao.KonobarDao"%>
    <%@page import="dao.PorudzbinaDao"%>
    <%@page import="dao.SegmentDao"%>
    <%@page import="model.Porudzbina"%>
    <%@page import="model.Segment"%>
    <%@page import="java.util.List" %>
    <%@page import="java.sql.Statement" %>
<%@page import="util.ConnectionManager" %>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update porudzbina</title>
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
<% String email = request.getParameter("email");%>
<div class="meni">
<div id='cssmenu'>
<ul>
   <li><a href='KonobarProfile.jsp?email=<%=email %>'><span>Home</span></a></li>
   <li class='active has-sub'><a href='#'><span>Porudzbine</span></a>
      <ul>
         <li><a href='#'><span>Gotove</span></a>
         </li>
         <li><a href='#'><span>Primljene</span></a>
         </li>
         <li><a href='PorudzbineKonobarPrikaz.jsp?email=<%=email %>'><span>Prikaz svih</span></a>
         </li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Racun</span></a>
      <ul>
         <li><a href='#'><span>Formiranje</span></a>
         </li>
         <li><a href='#'><span>Prikaz svih</span></a>
         </li>
		 <li><a href='#'><span>Prihod</span></a>
         </li>
      </ul>
   </li>
   <li><a href='UpdateKonobar.jsp?email=<%=email %>'><span>Update profile</span></a></li>
   <li><a href='#'><span>Raspored rada</span></a></li>
   <li class='last'><a href='logout'><span>Logout</span></a></li>
</ul>
</div>
</div>
<div class="template">
<%
KonobarDao konDao = new KonobarDao();
Konobar konobar = konDao.GetKonobarByEmail(email);
int idRestoran = konobar.getIdRestoran().getIdRest();
int id = Integer.parseInt(request.getParameter("id"));
PorudzbinaDao porDao = new PorudzbinaDao();
Porudzbina porudzbina = null;
Porudzbina por = porDao.getPorudzbinaById(id);
porudzbina = por;
int idPorudzbina = porudzbina.getIdPorudzbina();
int kolicinaJela = porudzbina.getKolicinaJela();
int kolicinaPica = porudzbina.getKolicinaPica();
double cijena = porudzbina.getJelo().getCijena()*porudzbina.getKolicinaJela()+porudzbina.getPice().getCijena()*porudzbina.getKolicinaPica();
String izmenjeno=request.getParameter("izmenjeno");
%>

<table class="tabela">
				<form action="UpdatePorudzbinaKonobar">
				<%
				if(izmenjeno!=null){
					if(izmenjeno.equals("1")){ 
						%><div class="alert alert-success">
    <strong>Uspjesno!</strong> Uspjesno ste izmijenili podatke o porudzbini.</div><%
					}
				}
			%>
				<tr class="red">
					<td class="polje">Odaberite pice:</td>
					<td class="polje">
					<%try{
						Statement stmt;
						String query = "select distinct naziv from pice";
						stmt = ConnectionManager.getConnection().createStatement();
						ResultSet rset = stmt.executeQuery(query);
					%>
					<select name="pice" class="selekt">
					<option disabled selected value> -- izaberite pice -- </option>
        			<%  while(rset.next()){ %>
            			<option><%= rset.getString(1)%></option>
       				 <% } %>
        			</select>
      	  <%
      	rset.close();
        	}
        	catch(Exception e)
        	{
             out.println("wrong entry"+e);
        	}
			%>
			</td>
			</tr>
					<tr class="red">
						<td class="polje">Kolicina Pica:</td> <td class="polje"> <input type="text" name="kolicinaPica" value="<%=kolicinaPica%>" class="unos" title="Polje za kolicinu pica ne moze biti prazno. Moze da sadrzi samo brojeve." required pattern="[0-9]+"></td>
					</tr>
					<tr class="red">
					<td class="polje">Odaberite Jelo:</td>
					<td class="polje">
					<%try{
						Statement stmt;
						String query = "select distinct naziv from jelo";
						stmt = ConnectionManager.getConnection().createStatement();
						ResultSet rset = stmt.executeQuery(query);
					%>
					<select name="jelo" class="selekt">
					<option disabled selected value> -- izaberite jelo -- </option>
        			<%  while(rset.next()){ %>
            			<option><%= rset.getString(1)%></option>
       				 <% } %>
        			</select>
      	  <%
      	rset.close();
        	}
        	catch(Exception e)
        	{
             out.println("wrong entry"+e);
        	}
			%>
			</td>
			</tr>
					<tr class="red">
						<td class="polje">Kolicina jela:</td> <td class="polje">  <input type="text" name="kolicinaJela" value="<%=kolicinaJela%>" class="unos" title="Polje za kolicinu jela ne moze biti prazno i moze da sadrzi samo brojeve." required pattern="[0-9]+"></td>
					</tr>
					
						<input type="hidden" name="cijena" value="<%=cijena%>" class="unos" title="Polje cijena moze sadrzati samo brojeve." required pattern="[0-9]+"></td>
					
					
					
								
			
					<input type="hidden" name="idPorudzbina" value="<%=id%>">
					<input type="hidden" name="email" value="<%=email%>">
					<tr class="red">
					 <td><input type="submit" value="Update" class="dugmic"></td>
					 <td><input type="reset" value="Reset" class="dugmic"></td>
					  </tr>
					  </form>
				</table>
</div>
</body>
</html>