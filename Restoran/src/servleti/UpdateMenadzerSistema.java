package servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenadzerRestoranaDao;
import dao.MenadzerSistemaDao;
import dao.RestoranDao;
import model.Restoran;

/**
 * Servlet implementation class UpdateMenadzerSistema
 */
public class UpdateMenadzerSistema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMenadzerSistema() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email= request.getParameter("email");
		int idMenSis= Integer.parseInt(request.getParameter("idMenSis"));
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String jmbg = request.getParameter("jmbg");
		String mejl = request.getParameter("mejl");
		String password = request.getParameter("password");
		MenadzerSistemaDao menSisDao = new MenadzerSistemaDao();
		menSisDao.UpdateMenadzerSistema(ime, prezime, mejl, jmbg, password, idMenSis);
		response.sendRedirect("MenadzerSistema.jsp?email="+email);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
