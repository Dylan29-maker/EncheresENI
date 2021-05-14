package fr.eni.enchere.ihm;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.ArticlesVendusManager;
import fr.eni.enchere.bll.ArticlesVendusManagerImpl;
import fr.eni.enchere.bll.CategorieManager;
import fr.eni.enchere.bll.CategorieManagerImpl;
import fr.eni.enchere.bll.RetraitsManager;
import fr.eni.enchere.bll.RetraitsManagerImpl;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bll.UtilisateurManagerImpl;
import fr.eni.enchere.bo.Articles_Vendus;
import fr.eni.enchere.bo.Categories;
import fr.eni.enchere.bo.Retraits;
import fr.eni.enchere.bo.Utilisateurs;

/**
 * Servlet implementation class VenteServlet
 */
@WebServlet("/VenteServlet")
public class VenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VenteServlet() {
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
		UtilisateurManager managerUtil = UtilisateurManagerImpl.getInstance();
		RetraitsManager managerRetrait = RetraitsManagerImpl.getInstance();
		// Création du modèle
		ModelEniEncheres model = new ModelEniEncheres();

		model.setListeCategories(managerCat.getAllCategories());
		model.setListeUtilisateur(managerUtil.getAllUtilisateurs());

		if (request.getParameter("categories") != null) {
			if (request.getParameter("utilisateurs") != null) {
				Integer utilisateur = Integer.parseInt(request.getParameter("utilisateurs"));
				Integer categorie = Integer.parseInt(request.getParameter("categories"));
				String article = request.getParameter("article");
				String description = request.getParameter("description");
				Integer prix = Integer.parseInt(request.getParameter("prix"));
				LocalDate dde = LocalDate.parse(request.getParameter("debutEnchere"));
				LocalDate dfe = LocalDate.parse(request.getParameter("finEnchere"));
				Categories cat = managerCat.getCategorie(categorie);
				Utilisateurs util = managerUtil.getUtilisateur(utilisateur);
				Articles_Vendus articleV = new Articles_Vendus(article, description, dde, dfe, prix, util, cat);

				// Retraits retrait = new Retraits(articleV, rue, cp, ville);
				request.setAttribute("rue", util.getRue());
				request.setAttribute("cp", util.getCode_postal());
				request.setAttribute("ville", util.getVille());
				
				// managerRetrait.ajoutRetraits(retrait);
				managerArt.ajoutArticle(articleV);
				model.setResult("Vente ajoutée!");
			}
		}



		request.setAttribute("model", model);
		request.getRequestDispatcher("WEB-INF/Vente.jsp").forward(request, response);

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
