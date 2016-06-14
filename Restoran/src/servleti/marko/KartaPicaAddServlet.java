package servleti.marko;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.marko.KartaPicaDAO;
import model.marko.KartaPica;

/**
 * Servlet implementation class KartaPicaAddServlet
 */
public class KartaPicaAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KartaPicaAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String naziv = request.getParameter("naziv");
		String email = request.getParameter("email");
		request.setAttribute("labela", naziv);
		KartaPica karta = new KartaPica(naziv);
		KartaPicaDAO kartaDAO = new KartaPicaDAO();
		kartaDAO.insertKartaPica(karta);
		request.getRequestDispatcher("UnosPica.jsp?email="+email).forward(request, response);
		
		
		return;
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
