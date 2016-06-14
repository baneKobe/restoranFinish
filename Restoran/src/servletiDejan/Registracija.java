package servletiDejan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoDejan.KorisnikDAO;
import klaseDejan.Korisnik;

/**
 * Servlet implementation class InsertUserServlet
 */
public class Registracija extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registracija() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String lozinka = request.getParameter("lozinka");
		String prezime = request.getParameter("prezime");
		String email = request.getParameter("email");
		KorisnikDAO korisnikDAO = new KorisnikDAO();
		Korisnik k = korisnikDAO.KorisnikEmail(email);
		if (k==null){
			Korisnik korisnik = new Korisnik(username, lozinka, prezime, email);
			korisnikDAO.dodajKorisnika(korisnik);
			response.sendRedirect("Mail?email="+email);
			
		} else {
			response.sendRedirect("registracija.jsp?error=1");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}



