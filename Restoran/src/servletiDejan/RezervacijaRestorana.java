package servletiDejan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RezervacijaRestorana
 */
public class RezervacijaRestorana extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RezervacijaRestorana() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String naziv = request.getParameter("naziv");
		String email = request.getParameter("email");
		String datum = request.getParameter("datum");
		String danasnjidatum = request.getParameter("danasnjidatum");
		String vreme = request.getParameter("vreme");
		String trenutnovreme = request.getParameter("trenutnovreme");
		String sati = request.getParameter("sati");
		
		String idRestoran = request.getParameter("idRestoran");
		String idJelovnik = request.getParameter("idJelovnik");
		String idKarte = request.getParameter("idKarte");
		
		String []d1=datum.split("-");
		String zamena=danasnjidatum.replace(".", "-");
		String []d2=zamena.split("-");
		
		String zamena2=vreme.replace(":", "-");
		String []s1=zamena2.split("-");
		String []s2=trenutnovreme.split("-");
		
		if(Integer.parseInt(d1[0])<Integer.parseInt(d2[0])) {
			response.sendRedirect("rezervacijaRestorana.jsp?naziv="+naziv+"&email="+email+"&idJelovnik="+idJelovnik+
					"&idKarte="+idKarte+"&idRestoran="+idRestoran+"&odg=1");
		}
		else if(Integer.parseInt(d1[1])<Integer.parseInt(d2[1])){
			response.sendRedirect("rezervacijaRestorana.jsp?naziv="+naziv+"&email="+email+"&idJelovnik="+idJelovnik+
					"&idKarte="+idKarte+"&idRestoran="+idRestoran+"&odg=1");
		}
		
		else if(Integer.parseInt(d1[2])<Integer.parseInt(d2[2]) && Integer.parseInt(d1[1])==Integer.parseInt(d2[1])){
			response.sendRedirect("rezervacijaRestorana.jsp?naziv="+naziv+"&email="+email+"&idJelovnik="+idJelovnik+
					"&idKarte="+idKarte+"&idRestoran="+idRestoran+"&odg=1");
		}
		
		else if(Integer.parseInt(s1[0])<8 || Integer.parseInt(s1[0])>=22){
			response.sendRedirect("rezervacijaRestorana.jsp?naziv="+naziv+"&email="+email+"&idJelovnik="+idJelovnik+
					"&idKarte="+idKarte+"&idRestoran="+idRestoran+"&odg=2");
		}
		else if(Integer.parseInt(d1[2])==Integer.parseInt(d2[2]) && Integer.parseInt(s1[0])<=Integer.parseInt(s2[0]) && Integer.parseInt(s1[1])<=Integer.parseInt(s2[1])){
			response.sendRedirect("rezervacijaRestorana.jsp?naziv="+naziv+"&email="+email+"&idJelovnik="+idJelovnik+
					"&idKarte="+idKarte+"&idRestoran="+idRestoran+"&odg=1");
		}
		else if(Integer.parseInt(s1[0])==20 && Integer.parseInt(sati)==2){
			response.sendRedirect("rezervacijaRestorana.jsp?naziv="+naziv+"&email="+email+"&idJelovnik="+idJelovnik+
					"&idKarte="+idKarte+"&idRestoran="+idRestoran+"&odg=2");
		}
		else if(Integer.parseInt(s1[0])==21 && Integer.parseInt(sati)>=1){
			response.sendRedirect("rezervacijaRestorana.jsp?naziv="+naziv+"&email="+email+"&idJelovnik="+idJelovnik+
					"&idKarte="+idKarte+"&idRestoran="+idRestoran+"&odg=2");
		}
		else {
			response.sendRedirect("rezervacijaRestorana2.jsp?naziv="+naziv+"&email="+email+
					"&datum="+datum+"&vreme="+vreme+"&sati="+sati+"&idRestoran="+idRestoran+
					"&idJelovnik="+idJelovnik+"&idKarte="+idKarte);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
