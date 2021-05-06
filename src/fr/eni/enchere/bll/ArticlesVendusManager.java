package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Articles_Vendus;

public interface ArticlesVendusManager {
	
	public void ajoutArticle(Articles_Vendus article);
	
	public Articles_Vendus getArticle (Integer no_article);
	
	public void modifArticle(Articles_Vendus article);
	
	public void suppArticler(Integer no_article);
	
	public List<Articles_Vendus> getAllArticles();
	
	public List<Articles_Vendus> getArticlesCat(Integer no_categorie);


}
