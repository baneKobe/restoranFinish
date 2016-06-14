package servleti.marko;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.marko.MenadzerRestoranaDao;
import model.marko.MenadzerRestorana;

/**
 * Servlet implementation class PrikazJedneKomponente
 */
public class PrikazMenadzeraRestorana extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrikazMenadzeraRestorana() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		MenadzerRestoranaDao mendzDAO = new MenadzerRestoranaDao();
		MenadzerRestorana menadzerRestorana = mendzDAO.getManagerByID(id);
		String imeMenRes = menadzerRestorana.getImeMenRes();
		String prezimeMenRes = menadzerRestorana.getPrezimeMenRes();
		String jmbg = menadzerRestorana.getJmbg();
		String email = menadzerRestorana.getEmail();
		String password = menadzerRestorana.getPassword();
		if(menadzerRestorana != null){
			request.getSession(true).setAttribute("id",id);
			request.getSession(true).setAttribute("ime",imeMenRes);
			request.getSession(true).setAttribute("prezime",prezimeMenRes);
			request.getSession(true).setAttribute("jmbg",jmbg);
			request.getSession(true).setAttribute("email",email);
			request.getSession(true).setAttribute("password",password);
			response.sendRedirect("ManagerPage.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
