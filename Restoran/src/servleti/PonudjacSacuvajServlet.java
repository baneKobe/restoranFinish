package servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PonudjacDAO;
import model.Ponudjac;

/**
 * Servlet implementation class PonudjacSacuvajServlet
 */
public class PonudjacSacuvajServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PonudjacSacuvajServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String nazivKompanije = request.getParameter("nazivKompanije");
		String email = request.getParameter("email");
		String adresa = request.getParameter("adresa");
		String brojTelefona = request.getParameter("brojTelefona");
		String password = request.getParameter("password");
		PonudjacDAO ponudjacDAO = new PonudjacDAO();
		ponudjacDAO.getUpdatePonudjac(id, ime, prezime, nazivKompanije, email, adresa, brojTelefona,password);
		Ponudjac ponudjac= ponudjacDAO.getPonudjacByEmail(email);
		String email1=ponudjac.getEmail();
		response.sendRedirect("PonudjacProfil.jsp?email="+email1);
		System.out.println("Servlet "+email1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
