package servleti.marko;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.marko.KuvarDAO;
import dao.marko.RestoranDao;
import model.marko.Kuvar;
import model.marko.Restoran;



/**
 * Servlet implementation class RegistarKorisnikaServlet
 */
public class RegistracijaKuvaraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistracijaKuvaraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String konf = request.getParameter("konfekcijskiBroj");
		int konfekcijskiBroj = Integer.parseInt(konf);
		String datumRodjenja = request.getParameter("datumRodjenja");
		String velicinaObuce = request.getParameter("velicinaObuce");
		String nazivRest = request.getParameter("idRestoran");
		RestoranDao resDao = new RestoranDao();
		Restoran restoran = resDao.GetRestoranByNaziv(nazivRest);
		Kuvar kuvar = new Kuvar(ime, prezime,konfekcijskiBroj,datumRodjenja,velicinaObuce,email,password,restoran);
		KuvarDAO kuvarDAO = new KuvarDAO();
		kuvarDAO.insertKuvar(kuvar);
		response.sendRedirect("ManagerPage.jsp");
		
		return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
