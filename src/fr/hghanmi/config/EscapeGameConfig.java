package fr.hghanmi.config;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import fr.hghanmi.Affichage;
public class EscapeGameConfig {

	InputStream inputStream;

	private static int longueur;
	private static int nombreEssai;
	private static boolean modeDeveloppeur = false;

	public EscapeGameConfig() {
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";

			inputStream = EscapeGameConfig.class.getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			longueur = Integer.parseInt(prop.getProperty("longueur_nombre"));
			nombreEssai = Integer.parseInt(prop.getProperty("nombre_essai"));
			modeDeveloppeur = Boolean.valueOf(prop.getProperty("mode_dev"));

		} catch (Exception e) {
			System.out.println(Affichage.EXCEPTION + e);
		}
	}

	public static int getLongueur() {
		return longueur;
	}

	public static int getNombreEssai() {
		return nombreEssai;
	}

	public static boolean isModeDeveloppeur() {
		return modeDeveloppeur;
	}

}