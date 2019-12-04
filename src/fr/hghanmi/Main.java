package fr.hghanmi;

import java.util.Scanner;

import org.apache.log4j.Logger;

import fr.hghanmi.config.EscapeGameConfig;
import fr.hghanmi.joueurs.Jeu;
import fr.hghanmi.modedejeu.ModeAttaquant;
import fr.hghanmi.modedejeu.ModeDefenseur;
import fr.hghanmi.modedejeu.ModeDuel;

public class Main {

	static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws Exception {

		logger.info(Affichage.BIENVENUE2);
		System.out.println(Affichage.BIENVENUE2);

		new EscapeGameConfig();
		while (true) {
			String saisie;
			boolean juste = false;
			Scanner sc = new Scanner(System.in);
			int choix = 0;
			while (!juste) {
				System.out.println(Affichage.CHOIX);
				System.out.println(Affichage.MODE_DEFENSEUR2);
				System.out.println(Affichage.MODE_CHALLENGER2);
				System.out.println(Affichage.MODE_DUEL2);
				System.out.println(Affichage.QUITTER);

				logger.info(Affichage.CHOIX);
				logger.info(Affichage.MODE_DEFENSEUR2);
				logger.info(Affichage.MODE_CHALLENGER2);
				logger.info(Affichage.MODE_DUEL2);
				logger.info(Affichage.QUITTER);
				try {
					saisie = sc.nextLine();
					choix = Integer.parseInt("" + saisie);
					if (choix < 1 || choix > 4) {

						System.out.println(Affichage.ERREUR);
						System.out.println(Affichage.REESSAYEZ);

						logger.error(Affichage.ERREUR);
						logger.error(Affichage.REESSAYEZ);
					} else {
						juste = true;
					}
				} catch (Exception e) {
//					e.printStackTrace();
					System.out.println(Affichage.REESSAYEZ);
					logger.warn(Affichage.REESSAYEZ);
				}
			}
			Jeu jeu = null;
			try {
				switch (choix) {
					case 1:
						jeu = new ModeDefenseur();
					break;
					case 2:
						jeu = new ModeAttaquant();
					break;
					case 3:
						jeu = new ModeDuel();
					break;
					default:
						throw new Exception();
				}
				jeu.lancer(choix);
			}

			catch (Exception e) {
				if (choix == 4) {
					System.out.println(Affichage.A_BIENTOT);
					logger.info(Affichage.A_BIENTOT);
					System.exit(0);
				}
				e.printStackTrace();
			}
		}
	}
}