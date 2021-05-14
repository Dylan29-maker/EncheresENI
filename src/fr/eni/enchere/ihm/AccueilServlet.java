package fr.eni.enchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.ArticlesVendusManager;
import fr.eni.enchere.bll.ArticlesVendusManagerImpl;
import fr.eni.enchere.bll.CategorieManager;
import fr.eni.enchere.bll.CategorieManagerImpl;
import fr.eni.enchere.bll.ManagerException;
import fr.eni.enchere.bo.Categories;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccueilServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupération de l'instance
		CategorieManager managerCat = CategorieManagerImpl.getInstance();
		ArticlesVendusManager managerArt = ArticlesVendusManagerImpl.getInstance();
		// Création du modèle
		ModelEniEncheres model = new ModelEniEncheres();

		// Redirection page

		// Affichage des enchères depuis la recherche

		// Affichage des enchères depuis la liste des catégories
		model.setListeCategories(managerCat.getAllCategories());
		model.setListeArticles(managerArt.getAllArticles());

		if (request.getParameter("categories") != null) {
			Integer categorie = Integer.parseInt(request.getParameter("categories"));

			for (Categories cat : managerCat.getAllCategories()) {
				if (categorie == cat.getNo_categorie()) {
					model.setListeArticles(managerArt.getArticlesCat(categorie));
				}
			}
		}

		// Affichage des enchères depuis la liste des catégories
		String choix = request.getParameter("choix");
		String achat = request.getParameter("choixAchat");
		String vente = request.getParameter("choixVente");

		if ("Achat".equals(choix)) {
			System.out.println("cest achat");

		} else if ("Ventes".equals(choix)) {
			System.out.println("cest vente");
		}

		// affichage du détail d'une vente
		
		
		// dispatcher
		request.setAttribute("model", model);
		request.getRequestDispatcher("WEB-INF/Accueil.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
