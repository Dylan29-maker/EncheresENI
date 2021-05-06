package fr.eni.enchere.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Articles_Vendus;
import fr.eni.enchere.dal2.DALException;
import fr.eni.enchere.dal2.DAOFactory;
import fr.eni.enchere.dal2.InterfaceDAO;

public class ArticlesVendusManagerImpl implements ArticlesVendusManager {

	private InterfaceDAO<Articles_Vendus> dao = DAOFactory.getArticlesVendusDAO();

	@Override
	public void ajoutArticle(Articles_Vendus article) {
		try {
			dao.insert(article);
		} catch (DALException e) {
			new ManagerException("Erreur lors de l'ajout d'un article");
		}
	}

	@Override
	public Articles_Vendus getArticle(Integer no_article) {
		Articles_Vendus article = null;

		try {
			article = dao.selectById(no_article);
		} catch (DALException e) {
			new ManagerException("Le numéro de l'article est inconnue");
		}
		return article;
	}

	@Override
	public void modifArticle(Articles_Vendus article) {
		try {
			dao.update(article);
		} catch (DALException e) {
			new ManagerException("Erreur lors de la modification d'un article");
		}

	}

	@Override
	public void suppArticler(Integer no_article) {
		try {
			dao.delete(no_article);
		} catch (DALException e) {
			new ManagerException("Erreur lors de la supression d'un article");
		}

	}

	@Override
	public List<Articles_Vendus> getAllArticles() {
		List<Articles_Vendus> liste = new ArrayList<Articles_Vendus>();

		try {
			liste = dao.selectAll();
		} catch (DALException e) {
			new ManagerException("Erreur lors de l'affichage de la liste des utilisateur");
		}
		return liste;
	}

	@Override
	public List<Articles_Vendus> getArticlesCat(Integer no_categorie) {
		List<Articles_Vendus> liste = new ArrayList<Articles_Vendus>();

		try {
			liste = dao.selectByCat(no_categorie);
		} catch (DALException e) {
			new ManagerException("Erreur lors de l'affichage de la liste des utilisateur");
		}
		return liste;
	}

}
