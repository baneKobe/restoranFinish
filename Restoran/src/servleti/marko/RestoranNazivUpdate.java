package servleti.marko;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class UpdateKomponenta
 */
public class RestoranNazivUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestoranNazivUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nazivRest = request.getParameter("nazivRest");
		String vrstaRest = request.getParameter("vrstaRest");
		String jelovnik = request.getParameter("jelovnik");
		String kartaPica = request.getParameter("kartaPica");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("RestoranIzmena.jsp");
		request.getSession(true).setAttribute("id",id);
		request.getSession(true).setAttribute("nazivRest",nazivRest);
		request.getSession(true).setAttribute("vrstaRest",vrstaRest);
		request.getSession(true).setAttribute("jelovnik",jelovnik);
		request.getSession(true).setAttribute("kartaPica",kartaPica);
		  requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
