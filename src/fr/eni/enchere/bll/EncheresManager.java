package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Encheres;

public interface EncheresManager {

	public void ajoutEnchere(Encheres enchere);

	public Encheres getEnchere(Integer no_article);

	public void modifEnchere(Encheres enchere);

	public void suppEnchere(Integer no_article);

	public List<Encheres> getAllEncheres();

}
