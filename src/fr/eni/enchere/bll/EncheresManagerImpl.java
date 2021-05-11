package fr.eni.enchere.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Encheres;
import fr.eni.enchere.dal2.DALException;
import fr.eni.enchere.dal2.DAOFactory;
import fr.eni.enchere.dal2.InterfaceDAO;

public class EncheresManagerImpl implements EncheresManager {

	private InterfaceDAO<Encheres> dao;
	private static EncheresManagerImpl instance;

	private EncheresManagerImpl() {
		this.dao = DAOFactory.getEncheresDAO();
	}

	public static EncheresManagerImpl getInstance() {

		if (instance == null) {
			instance = new EncheresManagerImpl();
		}
		return instance;
	}

	@Override
	public void ajoutEnchere(Encheres enchere) {
		try {
			dao.insert(enchere);
		} catch (DALException e) {
			new ManagerException("Erreur lors de l'ajout d'une enchere");
		}

	}

	@Override
	public Encheres getEnchere(Integer no_article) {
		Encheres enchere = null;

		try {
			enchere = dao.selectById(no_article);
		} catch (DALException e) {
			new ManagerException("Erreur lors de la selection d'une enchere");
		}
		return enchere;
	}

	@Override
	public void modifEnchere(Encheres enchere) {
		try {
			dao.update(enchere);
		} catch (DALException e) {
			new ManagerException("Erreur lors de la modif d'une enchere");
		}

	}

	@Override
	public void suppEnchere(Integer no_article) {
		try {
			dao.delete(no_article);
		} catch (DALException e) {
			new ManagerException("Erreur lors de la supression d'une enchere");
		}

	}

	@Override
	public List<Encheres> getAllEncheres() {
		List<Encheres> liste = new ArrayList<Encheres>();
		try {
			liste = dao.selectAll();
		} catch (DALException e) {
			new ManagerException("Erreur lors de l'affichage des encheres");
		}
		return liste;
	}

}
