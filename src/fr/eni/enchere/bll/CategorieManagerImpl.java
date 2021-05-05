package fr.eni.enchere.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Categories;
import fr.eni.enchere.dal2.DALException;
import fr.eni.enchere.dal2.DAOFactory;
import fr.eni.enchere.dal2.InterfaceDAO;

public class CategorieManagerImpl implements CategorieManager {

	private InterfaceDAO<Categories> dao = DAOFactory.getCategoriesDAO();

	@Override
	public List<Categories> getAllCategories() {
		List<Categories> liste = new ArrayList<Categories>();
		try {
			dao.selectAll();
		} catch (DALException e) {
			new ManagerException("Erreur lors de l'affichage de la liste des cat�gories");
		}
		return liste;
	}

	@Override
	public Categories getCategorie(Integer no_categories) {
		Categories cat = null;
		try {
			cat = dao.selectById(no_categories);
		} catch (DALException e) {
			new ManagerException("Erreur lors de l'affichage de la cat�gorie");
		}
		return cat;
	}

}