package fr.eni.enchere.ihm;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.bo.Categories;



public class ModelEniEncheres {
	
	
	
	// PARTIE UTILISATEUR
	
	private List<Utilisateurs> listeUtilisateur = new ArrayList<Utilisateurs>();
	private String result;
	private Utilisateurs utilisateur;
	
	public ModelEniEncheres() {};

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
	
	// PARTIE CATEGORIE
	
	
	//private Integer no_categorie;
	//private String libelle;
	
	

	
	
	
	
	

}

	
	
	
	

	




