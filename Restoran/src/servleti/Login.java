package servleti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KonobarDao;
import dao.KorisnikDAO;
import dao.KuvarDao;
import model.Konobar;
import model.Korisnik;
import model.Kuvar;
import dao.MenadzerSistemaDao;
import dao.SankerDao;
import model.MenadzerSistema;
import model.Sanker;
import dao.PonudjacDAO;
import model.Ponudjac;
import model.MenadzerRestorana;
import dao.MenadzerRestoranaDao;

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
		
		KonobarDao konDao = new KonobarDao();
		Konobar konobar = konDao.GetKonobarByEmailAndPassword(email, lozinka);
		
		KuvarDao kuvDao = new KuvarDao();
		Kuvar kuvar = kuvDao.GetKuvarByEmailAndPassword(email, lozinka);
		
		SankerDao sankDao = new SankerDao();
		Sanker sanker = sankDao.GetSankerByEmailAndPassword(email, lozinka);
		
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
		
		else if(konobar!= null){
			request.getSession(true).setAttribute("email", email);
			konobar = konDao.GetKonobarByEmail(email);
			if (konobar.getBrPristupa()==0) {
				response.sendRedirect("KonobarFirstLogIn.jsp?email="+email);
			}
			else {
				response.sendRedirect("KonobarProfile.jsp?email=" +email);
			}
			return;
		}
		
		else if(kuvar!= null){
			request.getSession(true).setAttribute("email", email);
			kuvar = kuvDao.GetKuvarByEmail(email);
			if(kuvar.getPristup()==0){
				response.sendRedirect("KuvarFirstLogin.jsp?email="+email);
			}
			else{
			response.sendRedirect("KuvarProfile.jsp?email=" +email);
			}
			return;
		}
		
		else if(sanker!= null){
			request.getSession(true).setAttribute("email", email);
			sanker = sankDao.GetSankerByEmail(email);
			if(sanker.getPristup()==0){
				response.sendRedirect("SankerFirstLogin.jsp?email="+email);
			}
			else{
			response.sendRedirect("SankerProfile.jsp?email=" +email);
			}
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