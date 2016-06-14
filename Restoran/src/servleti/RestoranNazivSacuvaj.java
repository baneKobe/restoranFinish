package servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RestoranNazivDAO;

/**
 * Servlet implementation class PonudjacSacuvajServlet
 */
public class RestoranNazivSacuvaj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestoranNazivSacuvaj() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("idRest"));
		String nazivRest = request.getParameter("nazivRest");
		String vrstaRest = request.getParameter("vrstaRest");
		RestoranNazivDAO restoranNazivDAO = new RestoranNazivDAO();
		restoranNazivDAO.getUpdateRestoran(id, nazivRest,vrstaRest);
		response.sendRedirect("RestoranNaziv.jsp?id="+id);
		System.out.println(id+" "+nazivRest);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
