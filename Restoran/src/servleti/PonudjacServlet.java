package servleti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PonudjacDAO;
import model.Ponudjac;

/**
 * Servlet implementation class PrikazJedneKomponente
 */
public class PonudjacServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PonudjacServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*/HttpSession session = request.getSession();
		if(session.getAttribute("korisnik")==null){
			response.sendRedirect("AdminIndeks.html");
			return;
		}*/
		String id = request.getParameter("id");
		PonudjacDAO ponDAO = new PonudjacDAO();
		Ponudjac ponudjac = ponDAO.getPonudjacByID(id);
		String ime = ponudjac.getIme();
		String prezime = ponudjac.getPrezime();
		String nazivKompanije = ponudjac.getNazivKompanije();
		String email = ponudjac.getEmail();
		String adresa = ponudjac.getAdresa();
		String brojTelefona = ponudjac.getBrojTelefona();
		String username = ponudjac.getUsername();
		String password = ponudjac.getPassword();
		if(ponudjac != null){
			request.getSession(true).setAttribute("id",id);
			request.getSession(true).setAttribute("ime",ime);
			request.getSession(true).setAttribute("prezime",prezime);
			request.getSession(true).setAttribute("nazivKompanije",nazivKompanije);
			request.getSession(true).setAttribute("email",email);
			request.getSession(true).setAttribute("adresa",adresa);
			request.getSession(true).setAttribute("brojTelefona",brojTelefona);
			request.getSession(true).setAttribute("username",username);
			request.getSession(true).setAttribute("password",password);
			response.sendRedirect("PonudjacIzmena.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
