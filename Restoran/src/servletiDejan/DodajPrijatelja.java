package servletiDejan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoDejan.PrijateljDAO;

/**
 * Servlet implementation class DodajPrijatelja
 */
public class DodajPrijatelja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DodajPrijatelja() {
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
		int id = Integer.parseInt(idPrijatelja);
		String email2 = request.getParameter("email2");
		String korisnik1 = request.getParameter("j");
		int ja = Integer.parseInt(korisnik1);
		String username = request.getParameter("username");
		String prezime = request.getParameter("prezime");

		if (ja == id) {
			response.sendRedirect("pretraga.jsp?email=" + email2 + "&username=" + username + "&prezime=" + prezime + "&odg=1");
		} else {
			PrijateljDAO prijateljDAO = new PrijateljDAO();
			prijateljDAO.DodajPrijatelja(idPrijatelja, ja);
			response.sendRedirect("pretraga.jsp?email=" + email2+"&username="+username+"&prezime="+prezime+"&odg=2");
			return;


				}
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
