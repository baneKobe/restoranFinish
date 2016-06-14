package servleti.marko;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.marko.JelovnikDAO;
import model.marko.Jelovnik;

/**
 * Servlet implementation class KartaPicaAddServlet
 */
public class JelovnikAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JelovnikAddServlet() {
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
		Jelovnik jelovnik = new Jelovnik(naziv);
		JelovnikDAO jelDAO = new JelovnikDAO();
		jelDAO.insertJelovnik(jelovnik);
		request.getRequestDispatcher("UnosJelo.jsp?email="+email).forward(request, response);
		
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
