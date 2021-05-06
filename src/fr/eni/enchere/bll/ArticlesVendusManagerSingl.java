package fr.eni.enchere.bll;

public class ArticlesVendusManagerSingl {
	private static ArticlesVendusManager instance;

	public static ArticlesVendusManager getInstance() {
		if (instance == null) {
			instance = new ArticlesVendusManagerImpl();
		}
		return instance;
	}

}
