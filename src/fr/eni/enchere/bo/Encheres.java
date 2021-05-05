package fr.eni.enchere.bo;

import java.time.LocalDate;

public class Encheres {

	private Utilisateurs utilisateur;
	private Articles_Vendus article;
	private LocalDate date_enchere;
	private Integer montant_enchere;

	public Encheres() {
	}

	public Encheres(Utilisateurs utilisateur, Articles_Vendus article, LocalDate date_enchere,
			Integer montant_enchere) {
		super();
		this.utilisateur = utilisateur;
		this.article = article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateurs utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Articles_Vendus getArticle() {
		return article;
	}

	public void setArticle(Articles_Vendus article) {
		this.article = article;
	}

	public LocalDate getDate_enchere() {
		return date_enchere;
	}

	public void setDate_enchere(LocalDate date_enchere) {
		this.date_enchere = date_enchere;
	}

	public Integer getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(Integer montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

	@Override
	public String toString() {
		return "Encheres [utilisateur=" + utilisateur + ", article=" + article + ", date_enchere=" + date_enchere
				+ ", montant_enchere=" + montant_enchere + "]";
	}

}
