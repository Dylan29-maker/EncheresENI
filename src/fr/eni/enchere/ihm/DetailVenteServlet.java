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
import fr.eni.enchere.bll.RetraitsManager;
import fr.eni.enchere.bll.RetraitsManagerImpl;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bll.UtilisateurManagerImpl;
import fr.eni.enchere.bo.Articles_Vendus;

/**
 * Servlet implementation class DetailVenteServlet
 */
@WebServlet("/DetailVenteServlet")
public class DetailVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailVenteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupération de l'id de l'article
		Integer id = Integer.parseInt(request.getParameter("id"));
		// Récupération de l'instance
		ArticlesVendusManager managerArt = ArticlesVendusManagerImpl.getInstance();
		RetraitsManager managerRetrait = RetraitsManagerImpl.getInstance();

		// Création du modèle
		ModelEniEncheres model = new ModelEniEncheres();
		Articles_Vendus art = managerArt.getArticle(id);

		request.setAttribute("nom", art.getNom_article());
		request.setAttribute("description", art.getDescription());
		request.setAttribute("categorie", art.getCategorie().getLibelle());
		request.setAttribute("prixVente", art.getPrix_vente().toString());
		request.setAttribute("prixInit", art.getPrix_initial().toString());
		request.setAttribute("dateFin", art.getDate_fin_encheres().toString());
		request.setAttribute("rue", art.getUtilisateur().getRue());
		request.setAttribute("cp", art.getUtilisateur().getCode_postal());
		request.setAttribute("ville", art.getUtilisateur().getVille());
		request.setAttribute("vendeur", art.getUtilisateur().getNom());

		if (request.getParameter("encherir") != null) {
			Integer prix = Integer.parseInt(request.getParameter("encherir"));

			Articles_Vendus article = new Articles_Vendus(art.getNo_article(), art.getNom_article(),
					art.getDescription(), art.getDate_debut_encheres(), art.getDate_fin_encheres(),
					art.getPrix_initial(), prix, art.getUtilisateur(), art.getCategorie());

			if (prix > art.getPrix_vente() && prix > art.getPrix_initial()) {
				managerArt.modifArticle(article);
				model.setResult("Enchère réussie");
				request.getRequestDispatcher("/AccueilServlet").forward(request, response);
			}
		}
		request.getRequestDispatcher("WEB-INF/DetailVente.jsp").forward(request, response);

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
