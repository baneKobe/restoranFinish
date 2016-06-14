package servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.KartaPicaDAO;
import model.KartaPica;
import model.Pice;

/**
 * Servlet implementation class PiceServlet
 */
public class PiceAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PiceAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nazivPica = request.getParameter("nazivPica");
		String opis = request.getParameter("opis");
		String price = request.getParameter("cena");
		double cena = Double.parseDouble(price);
		String idKart = request.getParameter("idKart");
		String delimiter = "";
		String[] tokens = idKart.split(delimiter);
		for (int i = 0; i < tokens.length; i++)
		    System.out.println(tokens[i]);
		int idKarta=Integer.parseInt(tokens[0]);
		KartaPicaDAO karDao = new KartaPicaDAO();
		KartaPica kartaPica = karDao.GetKartaPicaById(idKarta);
		KartaPicaDAO kartaDAO = new KartaPicaDAO();
		Pice pice = new Pice(nazivPica,opis,cena,kartaPica);
		kartaDAO.insertPice(pice);
		response.sendRedirect("UnosPica.jsp");
		System.out.println("insert");
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
