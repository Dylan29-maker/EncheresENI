package fr.eni.enchere.dal2;

import fr.eni.enchere.bll.ArticlesVendusManagerImpl;
import fr.eni.enchere.bll.CategorieManager;
import fr.eni.enchere.bll.CategorieManagerImpl;
import fr.eni.enchere.bo.Articles_Vendus;
import fr.eni.enchere.bo.Categories;
import fr.eni.enchere.dal.jdbc.ArticlesVendusDaoJdbcImpl;
import fr.eni.enchere.dal.jdbc.CategoriesDaoJdbcImpl;
import fr.eni.enchere.dal.jdbc.UtilisateursDaoJdbcImpl;

public class TestDal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			CategoriesDaoJdbcImpl instance = new CategoriesDaoJdbcImpl();
			ArticlesVendusDaoJdbcImpl instance2 = new ArticlesVendusDaoJdbcImpl();
			UtilisateursDaoJdbcImpl instance3 = new UtilisateursDaoJdbcImpl();

			try {
				System.out.println(instance3.selectAll());
			} catch (DALException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	}

}
