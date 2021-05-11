package fr.eni.enchere.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.bo.Articles_Vendus;
import fr.eni.enchere.bo.Categories;

public class ModelEniEncheres {

	// PARTIE UTILISATEUR

	private List<Utilisateurs> listeUtilisateur;
	private String result;
	private Utilisateurs utilisateur;
	private List<Categories> listeCategories;
	private List<Articles_Vendus> listeArticles;
	private Articles_Vendus article;

	public ModelEniEncheres() {
		this.listeUtilisateur = new ArrayList<>();
		this.listeCategories = new ArrayList<>();
		this.listeArticles = new ArrayList<>();
	};

	
	public ModelEniEncheres(Articles_Vendus article) {
		super();
		this.article = article;
	}


	public List<Utilisateurs> getListeUtilisateur() {
		return listeUtilisateur;
	}

	public void setListeUtilisateur(List<Utilisateurs> listeUtilisateur) {
		this.listeUtilisateur = listeUtilisateur;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}

	public void setutilisateur(Utilisateurs utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Categories> getListeCategories() {
		return listeCategories;
	}

	public void setListeCategories(List<Categories> listeCategories) {
		this.listeCategories = listeCategories;
	}

	public List<Articles_Vendus> getListeArticles() {
		return listeArticles;
	}

	public void setListeArticles(List<Articles_Vendus> listeArticles) {
		this.listeArticles = listeArticles;
	}

	public Articles_Vendus getArticle() {
		return article;
	}

	public void setArticle(Articles_Vendus article) {
		this.article = article;
	}

	// PARTIE CATEGORIE

	// private Integer no_categorie;
	// private String libelle;

}
