package fr.eni.enchere.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Retraits;
import fr.eni.enchere.dal2.DALException;
import fr.eni.enchere.dal2.DAOFactory;
import fr.eni.enchere.dal2.InterfaceDAO;

public class RetraitsManagerImpl implements RetraitsManager {
	private InterfaceDAO<Retraits> dao = DAOFactory.getRetraitsDAO();


	@Override
	public void ajoutRetraits(Retraits retraits) {
		try {
			dao.insert(retraits);
		} catch (DALException e) {
			new ManagerException("Erreur lors de l'ajout d'un retrait");
		}
		
	}

	@Override
	public Retraits getRetraits(Integer no_article) {
		Retraits retrait = null;
		
		try {
			retrait = dao.selectById(no_article);
		} catch (DALException e) {
			new ManagerException("Erreur lors de la selection d'un retrait");
		}
		return retrait;
	}

	@Override
	public void modifRetrais(Retraits retraits) {
		try {
			dao.update(retraits);
		} catch (DALException e) {
			new ManagerException("Erreur lors de la modif d'un retrait");
		}
		
	}

	@Override
	public void suppRetraits(Integer no_article) {
		try {
			dao.delete(no_article);
		} catch (DALException e) {
			new ManagerException("Erreur lors de la supression d'un retrait");
		}
		
	}

	@Override
	public List<Retraits> getAllRetraits() {
		List<Retraits> liste = new ArrayList<Retraits>();
		
		try {
			liste = dao.selectAll();
		} catch (DALException e) {
			new ManagerException("Erreur lors de l'affichage des retrait");
		}
		return liste;
	}

}
