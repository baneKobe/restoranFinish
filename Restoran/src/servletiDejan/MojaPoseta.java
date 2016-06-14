package servletiDejan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoDejan.PosetaDAO;
import klaseDejan.Poseta;

/**
 * Servlet implementation class Poseta
 */
public class MojaPoseta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MojaPoseta() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String nazivRestorana = request.getParameter("naziv");
		String datum = request.getParameter("datum");
		String sati = request.getParameter("vreme");
		String duzinaRezervacije = request.getParameter("sati");
		
		String korisnik = request.getParameter("ja");
		
		PosetaDAO posetaDAO = new PosetaDAO();
		Poseta pos = new Poseta(nazivRestorana, datum, sati, duzinaRezervacije, korisnik);
		posetaDAO.posetaRestorana(pos);
		response.sendRedirect("nalogKorisnika.jsp?email="+email);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
