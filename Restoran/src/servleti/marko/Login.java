package servleti.marko;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.marko.KorisnikDAO;
import dao.marko.MenadzerRestoranaDao;
import dao.marko.MenadzerSistemaDao;
import dao.marko.PonudjacDAO;
import model.marko.Korisnik;
import model.marko.MenadzerRestorana;
import model.marko.MenadzerSistema;
import model.marko.Ponudjac;

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
		
		MenadzerSistemaDao menDao = new MenadzerSistemaDao();
		MenadzerSistema menSis = menDao.GetMenadzerSistemaByEmailAndPassword(email, lozinka);
		
		PonudjacDAO ponudjacDAO = new PonudjacDAO();
		Ponudjac ponudjac = ponudjacDAO.getPonudjacByEmailAndPassword(email,lozinka);
		
		MenadzerRestoranaDao menadzerRestoranaDAO = new MenadzerRestoranaDao();
		MenadzerRestorana menadzerRestorana =menadzerRestoranaDAO.getManagerByEmailAndPassword(email,lozinka);
		
		if (korisnik != null) {
			request.getSession(true).setAttribute("email", email);
			response.sendRedirect("nalogKorisnika.jsp?email=" +email);
			return;

		}
		
		else if(menSis!= null){
			request.getSession(true).setAttribute("email", email);
			response.sendRedirect("MenadzerSistema.jsp?email=" +email);
			return;
		}
		else if(ponudjac!=null){
			request.getSession(true).setAttribute("email", email);
			response.sendRedirect("PonudjacProfil.jsp?email=" +email);
			return;
		}
		else if(menadzerRestorana!=null){
			request.getSession(true).setAttribute("email", email);
			response.sendRedirect("ManagerPage.jsp?email=" +email);
			return;
			
		}
		
		else {
			response.sendRedirect("login.html");
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