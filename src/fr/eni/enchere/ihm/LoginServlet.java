package fr.eni.enchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String nextScreen = "WEB-INF/Login.jsp";

	if (request.getParameter("login") != null) {
		if (!"".equals(request.getParameter("pass"))) {
			request.getSession().setAttribute("login", request.getParameter("login"));
			nextScreen = (String) request.getSession().getAttribute("calledServlet");
		} else {
			request.setAttribute("erreur", "Connexion impossible : Erreur dans le login ou le mot de passe!");
		}
	}
	request.getRequestDispatcher(nextScreen).forward(request, response);

}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
