package fr.eni.enchere.bll;

import java.util.List;
import fr.eni.enchere.bo.Retraits;

public interface RetraitsManager {

	public void ajoutRetraits(Retraits retraits);

	public Retraits getRetraits(Integer no_article);

	public void modifRetrais(Retraits retraits);

	public void suppRetraits(Integer no_article);

	public List<Retraits> getAllRetraits();

}
