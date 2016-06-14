package servletiDejan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoDejan.KorisnikDAO;
import klaseDejan.Korisnik;

/**
 * Servlet implementation class LoginServlet
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String lozinka = request.getParameter("lozinka");
		KorisnikDAO korisnikDAO = new KorisnikDAO();
		Korisnik korisnik = korisnikDAO.LoginKorisnik(email, lozinka);
		Korisnik l = korisnikDAO.KorisnikEmail(email);
		if (korisnik == null) {
			if(l==null){
				response.sendRedirect("login.jsp?odgovor=1");
				return;	
			}
			else if(!lozinka.equals(l.getLozinka())){
				response.sendRedirect("login.jsp?odgovor=2");
				return;	
			}
		} else {
			request.getSession(true).setAttribute("email", email);
			response.sendRedirect("nalogKorisnika.jsp?email=" +email);
			return;	
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}