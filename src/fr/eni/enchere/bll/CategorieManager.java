package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Categories;

public interface CategorieManager {

	public List<Categories> getAllCategories();
	
	public Categories getCategorie(Integer no_categories);

}
