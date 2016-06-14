package servleti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KorisnikDAO;


/**
 * Servlet implementation class UpdateKomponenta
 */
public class Izmena extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Izmena() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String prezime = request.getParameter("prezime");
		String email = request.getParameter("email");
		String lozinka = request.getParameter("lozinka");
		int idKor= Integer.parseInt(request.getParameter("idKor"));
		
		KorisnikDAO korisnikDAO = new KorisnikDAO();
		korisnikDAO.IzmeniKorisnika(username, prezime, email, lozinka, idKor);
		response.sendRedirect("izmeni.jsp?email="+email+"&izmenjeno=1");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
