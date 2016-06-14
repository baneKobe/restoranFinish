package servleti;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class UpdateKomponenta
 */
public class PonudjacUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PonudjacUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String nazivKompanije = request.getParameter("nazivKompanije");
		String email = request.getParameter("email");
		String adresa = request.getParameter("adresa");
		String brojTelefona = request.getParameter("brojTelefona");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("PonudjacIzmena.jsp");
		request.getSession(true).setAttribute("id",id);
		request.getSession(true).setAttribute("ime",ime);
		request.getSession(true).setAttribute("prezime",prezime);
		request.getSession(true).setAttribute("nazivKompanije",nazivKompanije);
		request.getSession(true).setAttribute("email",email);
		request.getSession(true).setAttribute("adresa",adresa);
		request.getSession(true).setAttribute("brojTelefona",brojTelefona);
		request.getSession(true).setAttribute("username",username);
		request.getSession(true).setAttribute("password",password);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
