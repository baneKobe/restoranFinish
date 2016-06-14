package servleti.marko;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.marko.PonudaDAO;
import model.marko.Ponuda;

/**
 * Servlet implementation class PrikazKonobara
 */
public class PrikazKonobara extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrikazKonobara() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String naziv = request.getParameter("naziv");
		String kolicina = request.getParameter("kolicina");

		Ponuda ponuda = new Ponuda(naziv,kolicina);
		PonudaDAO ponudaDAO = new PonudaDAO();
		ponudaDAO.insertPonuda(ponuda);
		request.getRequestDispatcher("PrikazNamirnica.jsp?email="+email).forward(request, response);
		
		
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
