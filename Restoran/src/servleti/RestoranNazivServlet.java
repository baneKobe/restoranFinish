package servleti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestoranNazivDAO;
import model.RestoranNaziv;

/**
 * Servlet implementation class PrikazJedneKomponente
 */
public class RestoranNazivServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestoranNazivServlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		RestoranNazivDAO resDAO = new RestoranNazivDAO();
		RestoranNaziv restoranNaziv = resDAO.getRestoranNazivByID(id);
		String nazivRest = restoranNaziv.getNazivRest();
		String vrstaRest = restoranNaziv.getVrstaRest();
		String jelovnik = restoranNaziv.getJelovnik();
		String kartaPica = restoranNaziv.getKartaPica();
		if(restoranNaziv != null){
			request.getSession(true).setAttribute("idPon",id);
			request.getSession(true).setAttribute("nazivRest",nazivRest);
			request.getSession(true).setAttribute("vrstaRest",vrstaRest);
			request.getSession(true).setAttribute("jelovnik",jelovnik);
			request.getSession(true).setAttribute("kartaPica",kartaPica);
			response.sendRedirect("RestoranIzmena.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
