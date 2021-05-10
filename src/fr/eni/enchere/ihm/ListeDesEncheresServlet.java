package fr.eni.enchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.EncheresManager;
import fr.eni.enchere.bll.EncheresManagerSingl;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bll.UtilisateurManagerSingl;

/**
 * Servlet implementation class MonProfil
 */
@WebServlet("/ListeDesEncheresServlet")
public class ListeDesEncheresServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeDesEncheresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Déclaration des variables
		
		String MonFiltreRecu="";
	//	String Nom_Categorie="";
		Integer Num_Categorie=0;
		
		//Integer Informatique = 1;
		//Integer Ameublement =2;
		//Integer Vêtements = 3;
		//Integer Sports_Loisirs =4;
		
		// Recupération de l'instance 
		
		EncheresManager manager = EncheresManagerSingl.getInstance();
			
		//Création du modèle 
				
		ModelEniEncheres model = new ModelEniEncheres();
		
		// Recupération des données 
		
		
	
			
	}
		
		
		
		
		
		
	



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
