package servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenadzerRestoranaDao;
import dao.PonudjacDAO;
import dao.RestoranDao;
import model.MenadzerRestorana;
import model.Ponudjac;
import model.Restoran;

/**
 * Servlet implementation class PonudjacReg
 */
public class PonudjacReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PonudjacReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String ime = request.getParameter("imePonudjac");
		String prezime = request.getParameter("prezimePonudjac");
		String kompanija = request.getParameter("kompanija");
		String mejl = request.getParameter("mejl");
		String password = request.getParameter("telefon");
		String adresa = request.getParameter("password");
		String telefon = request.getParameter("adresa");
		Ponudjac ponudjac = new Ponudjac(password,ime, prezime,kompanija, mejl, adresa, telefon);
		PonudjacDAO ponDao = new PonudjacDAO();
		ponDao.insertPonudjac(ponudjac);
		response.sendRedirect("MenadzerSistema.jsp?email="+email);
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
