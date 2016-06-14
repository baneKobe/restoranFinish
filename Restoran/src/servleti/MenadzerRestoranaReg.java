package servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenadzerRestoranaDao;
import dao.RestoranDao;
import model.MenadzerRestorana;
import model.Restoran;

/**
 * Servlet implementation class MenadzerRestoranaReg
 */
public class MenadzerRestoranaReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenadzerRestoranaReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		int idJelo = Integer.parseInt(request.getParameter("jelo"));
		String ime = request.getParameter("imeMenRes");
		String prezime = request.getParameter("prezimeMenRes");
		String jmbg = request.getParameter("jmbg");
		String mejl = request.getParameter("mejl");
		String password = request.getParameter("password");
		String nazivRest = request.getParameter("idRestoran");
		RestoranDao resDao = new RestoranDao();
		Restoran restoran = resDao.GetRestoranByNaziv(nazivRest);
		MenadzerRestorana menRes = new MenadzerRestorana(ime, prezime, mejl,jmbg, password,restoran);
		MenadzerRestoranaDao menResDao = new MenadzerRestoranaDao();
		menResDao.InsertMenadzerRestorana(menRes);
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
