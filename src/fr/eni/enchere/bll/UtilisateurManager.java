package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Utilisateurs;

public interface UtilisateurManager {
	
	public void ajoutUtilisateur(Utilisateurs util);
	
	public Utilisateurs getUtilisateur(Integer no_utilisateurs);
	
	public void modifUtilisateur(Utilisateurs util);
	
	public void suppUtilisateur(Integer no_utilisateurs);
	
	public List<Utilisateurs> getAllUtilisateurs();

	public void VerifUtilisateur(String pseudo, String email) throws ManagerException;

}
