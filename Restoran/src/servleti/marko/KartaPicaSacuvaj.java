package servleti.marko;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.marko.KartaPicaDAO;

/**
 * Servlet implementation class PonudjacSacuvajServlet
 */
public class KartaPicaSacuvaj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KartaPicaSacuvaj() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String naziv = request.getParameter("naziv");
		String opis = request.getParameter("opis");
		String cena = request.getParameter("cena");
		
		KartaPicaDAO kartaDAO = new KartaPicaDAO();
		kartaDAO.getUpdatePica(id, naziv, opis, cena);
		
		
		
		response.sendRedirect("KartaPica.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
