package servleti.marko;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.marko.JelovnikDAO;

/**
 * Servlet implementation class PonudjacSacuvajServlet
 */
public class JelovnikSacuvajServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JelovnikSacuvajServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idJelo = request.getParameter("id");
		String naziv = request.getParameter("naziv");
		String opis = request.getParameter("opis");
		String cena = request.getParameter("cena");
		
		JelovnikDAO jelDAO = new JelovnikDAO();
		jelDAO.getUpdateJelo(idJelo, naziv, opis, cena);
		
		
		
		response.sendRedirect("Jelovnik.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
