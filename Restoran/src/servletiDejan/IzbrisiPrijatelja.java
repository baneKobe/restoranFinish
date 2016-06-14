package servletiDejan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoDejan.PrijateljDAO;

/**
 * Servlet implementation class IzbrisiPrijatelja
 */
public class IzbrisiPrijatelja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IzbrisiPrijatelja() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idPrijatelja = request.getParameter("p");
		String email2 = request.getParameter("email2");
		String korisnik1 = request.getParameter("j");
		int ja = Integer.parseInt(korisnik1);
		PrijateljDAO prijateljDAO = new PrijateljDAO();
		prijateljDAO.IzbrisiPrijatelja(idPrijatelja, ja);
		response.sendRedirect("prijatelji.jsp?email=" + email2+"&ja="+korisnik1+"&msg=1");
		return;
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
