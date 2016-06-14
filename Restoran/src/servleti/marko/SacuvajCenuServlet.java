package servleti.marko;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.marko.PonudaDAO;


/**
 * Servlet implementation class SacuvajCenuServlet
 */
public class SacuvajCenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SacuvajCenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cena = request.getParameter("cena");
		String email= request.getParameter("email");
		int id= Integer.parseInt(request.getParameter("id"));
		PonudaDAO ponudaDAO = new PonudaDAO();
		ponudaDAO.insertCenaPonude(id,cena);
		request.getRequestDispatcher("PrikazNamirnicaCena.jsp?email="+email).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
