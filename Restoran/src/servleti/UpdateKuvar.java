package servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KuvarDao;

/**
 * Servlet implementation class UpdateKuvar
 */
public class UpdateKuvar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateKuvar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idKonobar= Integer.parseInt(request.getParameter("idKuvar"));
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		int konfekcijskiBr= Integer.parseInt(request.getParameter("konfekcijskiBr"));
		String datumRodjenja = request.getParameter("datumRodjenja");
		String velicinaObuce = request.getParameter("velicinaObuce");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		KuvarDao kuvDao = new KuvarDao();
		kuvDao.UpdateKuvar(ime, prezime, konfekcijskiBr, datumRodjenja, velicinaObuce, email, password, idKonobar);
		response.sendRedirect("KuvarProfile.jsp?email="+email);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
