package fr.eni.enchere.bll;

import java.util.ArrayList;
import java.util.List;


import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal2.DALException;
import fr.eni.enchere.dal2.DAOFactory;
import fr.eni.enchere.dal2.InterfaceDAO;

public class UtilisateurManagerImpl implements UtilisateurManager {

	private InterfaceDAO<Utilisateurs> dao = DAOFactory.getUtilisateursDAO();

	@Override
	public void ajoutUtilisateur(Utilisateurs util) {
		try {
			dao.insert(util);
		} catch (DALException e) {
			new ManagerException("Erreur lors de l'ajout d'un utilisateur");
		}
	}

	@Override
	public Utilisateurs getUtilisateur(Integer no_utilisateurs) {
		Utilisateurs util = null;

		try {
			util = dao.selectById(no_utilisateurs);
		} catch (DALException e) {
			new ManagerException("Le numéro de cette utilisateur est inconnue");
		}
		return util;
	}

	@Override
	public void modifUtilisateur(Utilisateurs util) {
		try {
			dao.update(util);
		} catch (DALException e) {
			new ManagerException("Erreur lors de la modification d'un utilisateur");
		}

	}

	@Override
	public void suppUtilisateur(Integer no_utilisateurs) {
		try {
			dao.delete(no_utilisateurs);
		} catch (DALException e) {
			new ManagerException("Erreur lors de la supression d'un utilisateur");
		}

	}

	@Override
	public List<Utilisateurs> getAllUtilisateurs() {
		List<Utilisateurs> liste = new ArrayList<Utilisateurs>();
		try {
			dao.selectAll();
		} catch (DALException e) {
			new ManagerException("Erreur lors de l'affichage des utilisateur");
		}
		return liste;
	}

	public void VerifUtilisateur (String pseudo, String email) throws ManagerException {
		
		List<Utilisateurs> lstUtilisateurs;
		lstUtilisateurs = getAllUtilisateurs();
		for(Utilisateurs u : lstUtilisateurs) {
			if(pseudo.equals(u.getPseudo()) || email.equals(u.getEmail())) {
				throw new ManagerException("Erreur : Ce pseudo ou cet email est déjà prit");		
			}
		}
		
		
	}
	
}

	
























