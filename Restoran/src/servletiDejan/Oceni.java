package servletiDejan;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoDejan.RestoranDAO;

/**
 * Servlet implementation class Oceni
 */
public class Oceni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Oceni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String utisak = request.getParameter("utisak");
		String ocenaJela = request.getParameter("star_a");
		//System.out.println(ocenaJela);
		String ocenaPica = request.getParameter("star_b");
		String ocenaRestorana = request.getParameter("star_c");
		String ja = request.getParameter("ja");
		String idRestorana = request.getParameter("idRestorana");
		String email= request.getParameter("email");
		
		RestoranDAO rDAO = new RestoranDAO();
		rDAO.dodajOcenu(utisak, ocenaJela, ocenaPica, ocenaRestorana,ja,idRestorana);
		response.sendRedirect("posete.jsp?email="+email+"&ja="+ja+"&odg=1");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
