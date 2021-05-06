package fr.eni.enchere.bll;

public class EncheresManagerSingl {
	private static EncheresManager instance;

	public static EncheresManager getInstance() {
		if (instance == null) {
			instance = new EncheresManagerImpl();
		}
		return instance;
	}

}
