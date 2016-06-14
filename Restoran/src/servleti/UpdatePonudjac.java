package servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenadzerRestoranaDao;
import dao.PonudjacDAO;
import dao.RestoranDao;
import model.Restoran;

/**
 * Servlet implementation class UpdatePonudjac
 */
public class UpdatePonudjac extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePonudjac() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email= request.getParameter("email");
		int idPonudjac= Integer.parseInt(request.getParameter("idPonudjac"));
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String kompanija = request.getParameter("kompanija");
		String mejl = request.getParameter("mejl");
		String password = request.getParameter("password");
		String adresa = request.getParameter("adresa");
		String telefon = request.getParameter("telefon");
		PonudjacDAO ponDao = new PonudjacDAO();
		ponDao.updatePonudjac(idPonudjac, ime, prezime, kompanija, mejl, adresa, telefon, password);
		response.sendRedirect("PonudjaciPrikaz.jsp?email="+email);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
