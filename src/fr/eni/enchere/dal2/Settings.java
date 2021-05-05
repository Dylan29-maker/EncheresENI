package fr.eni.enchere.dal2;

import java.util.Properties;

import fr.eni.enchere.dal2.Settings;

public class Settings {
	
private static Properties properties;
	
	static {
		try {
			properties = new Properties();
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		String parametre = properties.getProperty(key,null);
		return parametre;
	}

}
