package servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JelovnikDAO;
import dao.KartaPicaDAO;
import dao.MenadzerRestoranaDao;
import dao.RestoranDao;
import model.Jelovnik;
import model.KartaPica;
import model.Restoran;

/**
 * Servlet implementation class UpdateRestoran
 */
public class UpdateRestoran extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRestoran() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		int idRest= Integer.parseInt(request.getParameter("idRestoran"));
		String naziv = request.getParameter("naziv");
		String vrsta = request.getParameter("vrsta");
		String nazivJel = request.getParameter("idJelovnik");
		JelovnikDAO jelDao = new JelovnikDAO();
		Jelovnik jelovnik = jelDao.GetJelovnikIDbyNaziv(nazivJel);
		String nazivKarta = request.getParameter("idKarta");
		KartaPicaDAO karDao = new KartaPicaDAO();
		KartaPica kartaPica = karDao.GetKartaPicaIDbyNaziv(nazivKarta);
		RestoranDao resDao = new RestoranDao();
		resDao.UpdateRestoran(naziv, vrsta, jelovnik, kartaPica, idRest);
		response.sendRedirect("RestoraniPrikaz.jsp?email="+email);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
