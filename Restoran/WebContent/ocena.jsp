<%@page import="java.util.Date"%>
<%@page import="daoDejan.KorisnikDAO"%>
<%@page import="daoDejan.RestoranDAO"%>
<%@page import="klaseDejan.Korisnik"%>
<%@page import="klaseDejan.Restoran"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
	<head>
		<meta content="text/html" charset="UTF-8">
		<link rel="stylesheet" href="css1Dejan.css">
		<title></title>
	</head>
	<body>

<%
String email = request.getParameter("email");
String idRestorana = request.getParameter("idRestorana");
String ja = request.getParameter("ja");
KorisnikDAO korisnikDAO = new KorisnikDAO();
Korisnik korisnik = null;

if(email != null){
	Korisnik korisnik1 = korisnikDAO.KorisnikEmail(email);
	korisnik = korisnik1;
}
RestoranDAO rDAO=new RestoranDAO();
Restoran r=rDAO.RestoranIDZaOcenu(idRestorana);
int ocenjeno;
if(r==null){
	ocenjeno=0;	
}else{
	ocenjeno=1;
}
int id1 = korisnik.getIdKor();
int broj= 1;
%>
<body>

<ul class=prvo>
  <li><a href="restoran.jsp?email=<%=email %>">Restorani</a></li>
  <li><a href="prijatelji.jsp?email=<%=email %>&ja=<%=id1%>">Prijatelji</a></li>
  <li><a href="nalogKorisnika.jsp?email=<%=email %>">Moj nalog</a></li>
  <li><a class="active" href="posete.jsp?email=<%=email%>&ja=<%=id1%>">Moje posete</a></li>
  <li style="float:right"><a href="Logout">Odjavi se</a></li>
</ul>





<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
//  Check Radio-box
    $(".rating input:radio").attr("checked", false);
    $('.rating input').click(function () {
        $(".rating span").removeClass('checked');
        $(this).parent().addClass('checked');
    });

    $('input:radio').change(
    function(){
        var userRating = this.value;
    }); 
});
</script>

<form action="Oceni">

<br>
<p>Utisak: <input type="text" name="utisak" class="proba"><br></p>
<br>
<div><p>Ocena jela:</p>
    <div class="stars">
   
        <input type="radio" name="star_a" class="star-1" id="star_a-1" value="1"/>
        <label class="star-1" for="star_a-1">1</label>
        <input type="radio" name="star_a" class="star-2" id="star_a-2" value="2"/>
        <label class="star-2" for="star_a-2">2</label>
        <input type="radio" name="star_a" class="star-3" id="star_a-3" value="3"/>
        <label class="star-3" for="star_a-3">3</label>
        <input type="radio" name="star_a" class="star-4" id="star_a-4" value="4"/>
        <label class="star-4" for="star_a-4">4</label>
        <input type="radio" name="star_a" class="star-5" id="star_a-5" value="5" />
        <label class="star-5" for="star_a-5">5</label>
        <span></span>
    </div></div>
    <br>
    
<div><p>Ocena pica:</p>
    <div class="stars">
        <input type="radio" name="star_b" class="star-1" id="star_b-1" value="1"/>
        <label class="star-1" for="star_b-1">1</label>
        <input type="radio" name="star_b" class="star-2" id="star_b-2" value="2"/>
        <label class="star-2" for="star_b-2">2</label>
        <input type="radio" name="star_b" class="star-3" id="star_b-3" value="3"/>
        <label class="star-3" for="star_b-3">3</label>
        <input type="radio" name="star_b" class="star-4" id="star_b-4" value="4"/>
        <label class="star-4" for="star_b-4">4</label>
        <input type="radio" name="star_b" class="star-5" id="star_b-5" value="5"/>
        <label class="star-5" for="star_b-5">5</label>
        <span></span></div></div>
        <br>
    
<div><p>Ocena restorana:</p>
    <div class="stars">
        <input type="radio" name="star_c" class="star-1" id="star_c-1" value="1"/>
        <label class="star-1" for="star_c-1">1</label>
        <input type="radio" name="star_c" class="star-2" id="star_c-2" value="2"/>
        <label class="star-2" for="star_c-2">2</label>
        <input type="radio" name="star_c" class="star-3" id="star_c-3" value="3"/>
        <label class="star-3" for="star_c-3">3</label>
        <input type="radio" name="star_c" class="star-4" id="star_c-4" value="4"/>
        <label class="star-4" for="star_c-4">4</label>
        <input type="radio" name="star_c" class="star-5" id="star_c-5" value="5"/>
        <label class="star-5" for="star_c-5">5</label>
        <span></span></div>
    </div>
    	<input type="hidden" name="email" value="<%=email%>">
		<input type="hidden" name="idRestorana" value="<%=idRestorana%>">
		<input type="hidden" name="ja" value="<%=id1%>">
	<br>
	<br>
    <input type="submit" value="Oceni" class="dugmad">
    <input type=button value="Nazad" onclick="location.href='posete.jsp?email=<%=email%>&ja=<%=ja%>';" class="nesto">
</form>

</body>
</html>