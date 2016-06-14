package servleti.marko;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.marko.RestoranDao;
import dao.marko.SankerDAO;
import model.marko.Restoran;
import model.marko.Sanker;



/**
 * Servlet implementation class RegistarKorisnikaServlet
 */
public class RegistracijaSankeraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistracijaSankeraServlet() {
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
		Sanker sanker = new Sanker(ime, prezime,konfekcijskiBroj,datumRodjenja,velicinaObuce,email,password,restoran);
		SankerDAO sankerDAO = new SankerDAO();
		sankerDAO.insertSanker(sanker);
		response.sendRedirect("ManagerPage.jsp");
		
		return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
