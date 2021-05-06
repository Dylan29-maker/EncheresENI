package fr.eni.enchere.bll;

public class RetraitsManagerSingl {
	private static RetraitsManager instance;

	public static RetraitsManager getInstance() {
		if (instance == null) {
			instance = new RetraitsManagerImpl();
		}
		return instance;
	}

}
