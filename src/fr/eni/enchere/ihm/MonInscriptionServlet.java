package fr.eni.enchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.eni.enchere.bll.ManagerException;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bll.UtilisateurManagerSingl;
import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.ihm.ModelEniEncheres;


@WebServlet("/MonInscriptionServlet")
 
public class MonInscriptionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
    * @see HttpServlet#HttpServlet()
   */
   public MonInscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param credit 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
			Integer Credit =0;
			Integer no_utlisateur=1;
			boolean administrateur=false;
			boolean Connecte=false;
		
			// Recupération de l'instance 
		
			UtilisateurManager manager = UtilisateurManagerSingl.getInstance();
	
			//Création du modèle 
		
			ModelEniEncheres model = new ModelEniEncheres();
		
			// Récupération des données utlisateurs
		
		if (request.getParameter("nom") != null) {
			
			try {
				
				String pseudo = request.getParameter("pseudo");
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String email = request.getParameter("email");
				String rue = request.getParameter("rue");				
				String telephone = request.getParameter("telephone");
				String ville = request.getParameter("ville");
				String code_postal= request.getParameter("code_postal");
				String mot_de_passe = request.getParameter("mot_de_Passe");
				String ConfirmationMDP = request.getParameter("ConfirmationMDP");
				
			// Ajout d'un utilisateur + confirmation mdp + Credit + état connecté
				
					manager.VerifUtilisateur(pseudo, email);
					
					if (mot_de_passe.equals(ConfirmationMDP)) {
					
					manager.ajoutUtilisateur(new Utilisateurs(no_utlisateur,pseudo.trim(), nom.trim(), prenom.trim(), email.trim(), telephone.trim(), rue.trim(), code_postal, ville.trim(), mot_de_passe.trim(),Credit,administrateur));
					model.setResult("Utlisateur ajouté !");
					Connecte=true;
					Credit=100;
					
					}
					
				}	catch (NumberFormatException e) {
					model.setResult("Erreur : Champs vide !");
					
				} 	catch (ManagerException e) {
					model.setResult(e.getMessage());
				}
			
		}
		
		model.setListeUtilisateur(manager.getAllUtilisateurs());
		
		request.setAttribute("model",model);
		request.getRequestDispatcher("WEB-INF/MonInscription.jsp").forward(request,response);
	

}		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

