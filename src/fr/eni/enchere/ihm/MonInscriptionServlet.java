//package fr.eni.enchere.ihm;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class MonProfilServlet
// */
//@WebServlet("/MonProfilServlet")
//public class MonProfilServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public MonProfilServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		
//			// Recupération de l'instance 
//		
//		
//			//Création du modèle 
//		
//		
//			// Récupération des données utlisateurs
//		
//		if (request.getParameter("nom") != null) {
//			
//			try {
//				
//				String Pseudo = request.getParameter("Pseudo");
//				String Nom = request.getParameter("Nom");
//				String Prenom = request.getParameter("Prenom");
//				String Email = request.getParameter("Email");
//				String Rue = request.getParameter("Rue");
//				String NumTel = request.getParameter("NumTel");
//				Integer CodePostal = Integer.parseInt(request.getParameter("Codepostal"));
//				String MotDePasse = request.getParameter("MotDePasse");
//				String ConfirmationMDP = request.getParameter("ConfirmationMDP");
//				
//			} 
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		request.getRequestDispatcher("WEB-INF/MonProfil.jsp").forward(request,response);;
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
