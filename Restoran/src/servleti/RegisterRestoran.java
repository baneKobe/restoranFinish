package servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JelovnikDAO;
import dao.KartaPicaDAO;
import dao.RestoranDao;
import model.Jelovnik;
import model.KartaPica;
import model.Restoran;

/**
 * Servlet implementation class RegisterRestoran
 */
public class RegisterRestoran extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterRestoran() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String naziv = request.getParameter("naziv");
		String vrsta = request.getParameter("vrsta");
		String idJelovnik = request.getParameter("idJelovnik");
		String delimiter ="" ;
		String[] tokens = idJelovnik.split(delimiter);
		for (int i = 0; i < tokens.length; i++)
		    System.out.println(tokens[i]);
		int idJelovnika=Integer.parseInt(tokens[0]);
		JelovnikDAO jelDao = new JelovnikDAO();
		Jelovnik jelovnik = jelDao.GetJelovnikById(idJelovnika);
		
		String idKarta = request.getParameter("idKarta");
		String delimit = "";
		String [] tokeni = idKarta.split(delimit);
		for (int i = 0; i<tokeni.length; i++)
			System.out.println(tokeni[i]);
		int idKartaPica = Integer.parseInt(tokeni[0]);
		KartaPicaDAO karDao = new KartaPicaDAO();
		KartaPica kartaPica = karDao.GetKartaPicaById(idKartaPica);
		
		Restoran restoran = new Restoran(naziv, vrsta, jelovnik, kartaPica);
		RestoranDao resDao = new RestoranDao();
		resDao.InsertRestoran(restoran);
		response.sendRedirect("RestoraniPrikaz.jsp?email="+email);
		System.out.println("insert");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
