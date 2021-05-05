package fr.eni.enchere.dal2;

import fr.eni.enchere.bo.Categories;
import fr.eni.enchere.bo.Encheres;
import fr.eni.enchere.bo.Retraits;
import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal.jdbc.CategoriesDaoJdbcImpl;
import fr.eni.enchere.dal.jdbc.EncheresDaoJdbcImpl;
import fr.eni.enchere.dal.jdbc.UtilisateursDaoJdbcImpl;

public class DAOFactory {
	
	public static InterfaceDAO<Utilisateurs> getUtilisateursDAO(){
		return new UtilisateursDaoJdbcImpl();
	}
	
	public static InterfaceDAO<Categories> getCategoriesDAO(){
		return new CategoriesDaoJdbcImpl();
	}

	public static InterfaceDAO<Encheres> getEncheresDAO(){
		return new EncheresDaoJdbcImpl();
	}

//	public static InterfaceDAO<Retraits> getRetraitsDAO(){
//		return new RetraitsDaoJdbcImpl();
//	}
//	
//	public static InterfaceDAO<Articles_Vendus> getArticlesVendusDAO(){
//		return new RetraitsDaoJdbcImpl();
//	}


}
