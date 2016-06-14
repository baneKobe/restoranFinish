package servletiDejan;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Mail
 */
public class Mail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String mail =request.getParameter("email");
				final String username = "mrsisa2016@gmail.com";
				final String password = "mrsisa123";
				
				
				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");

				Session session = Session.getInstance(props, new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

				try {
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("mrsisa2016@gmail.com"));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
					message.setSubject("Potvrda registracije");
					message.setContent("http://localhost:8080/Restoran/verify.jsp?email="+mail,"text/html;");
					Transport.send(message);
					response.sendRedirect("registracija.jsp?uspesno=1");
				}

				catch (MessagingException e) {
					throw new RuntimeException(e);
				}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
