package servleti.marko;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.marko.PonudjacDAO;
import model.marko.Ponudjac;

/**
 * Servlet implementation class DodavanjeRadnika
 */
public class RegistracijaPonudjacaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistracijaPonudjacaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String imePonudjaca = request.getParameter("imePonudjaca");
		String prezimePonudjaca = request.getParameter("prezimePonudjaca");
		String nazivKompanije = request.getParameter("nazivKompanije");
		String email = request.getParameter("email");
		String loznika = request.getParameter("lozinka");
		String adresa = request.getParameter("adresa");
		String brojTelefona = request.getParameter("brojTelefona");
		
		
		
		PonudjacDAO ponudjacDAO = new PonudjacDAO();
		Ponudjac ponudjac = new Ponudjac(imePonudjaca, prezimePonudjaca, nazivKompanije, email, loznika, adresa, brojTelefona);
		ponudjacDAO.insertPonudjac(ponudjac);
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
