package servleti.marko;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.marko.KartaPicaDAO;

/**
 * Servlet implementation class DeleteKomponenta
 */
public class KartaPicaDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KartaPicaDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		if(session.getAttribute("menadzerrestorana")==null){
			response.sendRedirect("login.html");
			return;
		}*/
		int id = Integer.parseInt(request.getParameter("id"));
		KartaPicaDAO karDAO = new KartaPicaDAO();
		
		karDAO.deletePice(id);
		response.sendRedirect("KartaPica.jsp");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
