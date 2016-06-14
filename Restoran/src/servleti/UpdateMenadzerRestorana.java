package servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenadzerRestoranaDao;
import dao.RestoranDao;
import model.Restoran;

/**
 * Servlet implementation class UpdateMenadzerRestorana
 */
public class UpdateMenadzerRestorana extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMenadzerRestorana() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email= request.getParameter("email");
		int idMenRes= Integer.parseInt(request.getParameter("idMenRest"));
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String jmbg = request.getParameter("jmbg");
		String mejl = request.getParameter("mejl");
		String password = request.getParameter("password");
		String nazivRest = request.getParameter("Restoran");
		RestoranDao resDao = new RestoranDao();
		Restoran restoran = resDao.GetRestoranByNaziv(nazivRest);
		MenadzerRestoranaDao menResDao = new MenadzerRestoranaDao();
		menResDao.UpdateMenadzerRestorana(ime, prezime, mejl, jmbg, password, restoran, idMenRes);
		response.sendRedirect("MenadzeriRestoranaPrikaz.jsp?email="+email);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
