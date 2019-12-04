package fr.hghanmi.joueurs;

import java.util.Scanner;

import org.apache.log4j.Logger;

import fr.hghanmi.Affichage;
import fr.hghanmi.config.EscapeGameConfig;

public class JoueurHumain extends Joueurs {
	static Logger logger = Logger.getLogger(JoueurHumain.class);

	public JoueurHumain(boolean defenseur) {
		super(defenseur);
	}

	@Override
	public String genererCombial() {
		String combigeneree = "";
		boolean saisieCorrect = true;
		do {
			saisieCorrect = true;
			try {
				logger.info(Affichage.COMB_AL + EscapeGameConfig.getLongueur() + Affichage.CHIFFRES);
				System.out.println(Affichage.COMB_AL + EscapeGameConfig.getLongueur() + Affichage.CHIFFRES);
				Scanner clavier = new Scanner(System.in);
				combigeneree = clavier.nextLine();
				Integer.parseInt(combigeneree);
			} catch (NumberFormatException e) {
				saisieCorrect = false;
				System.out.println(Affichage.VEUILLEZ_SAISIR_QUE_DES_CHIFFRES);
				logger.error(Affichage.VEUILLEZ_SAISIR_QUE_DES_CHIFFRES);
			}
			if (combigeneree.length() != EscapeGameConfig.getLongueur()) {
				saisieCorrect = false;
				System.out.println(Affichage.VEUILLEZ_RESSAISIR_UNE_COMBINAISON_SECRÈTE_VALIDE + EscapeGameConfig.getLongueur()
				    + Affichage.CHIFFRES2);
				logger.error(Affichage.VEUILLEZ_RESSAISIR_UNE_COMBINAISON_SECRÈTE_VALIDE + EscapeGameConfig.getLongueur()
				    + Affichage.CHIFFRES2);
			}
		} while (!saisieCorrect);
		combinaisonSecrete = combigeneree;
		return combigeneree;
	}

	@Override
	public String genererProposition(String indice) {

		String combigenereestr = "";
		boolean saisieCorrect = true;
		do {
			saisieCorrect = true;
			try {
				logger.info(Affichage.GENEREZ_UNE_PROPOSITION + EscapeGameConfig.getLongueur() + Affichage.CHIFFRES);
				System.out.println(Affichage.GENEREZ_UNE_PROPOSITION + EscapeGameConfig.getLongueur() + Affichage.CHIFFRES);
				Scanner clavier = new Scanner(System.in);
				combigenereestr = clavier.nextLine();
				Integer.parseInt(combigenereestr);
			} catch (NumberFormatException e) {
				saisieCorrect = false;
				System.out.println(Affichage.VEUILLEZ_SAISIR_QUE_DES_CHIFFRES);
				logger.error(Affichage.VEUILLEZ_SAISIR_QUE_DES_CHIFFRES);
			}
			if (combigenereestr.length() != EscapeGameConfig.getLongueur()) {
				saisieCorrect = false;
				System.out.println(Affichage.VEUILLEZ_RESSAISIR_UNE_COMBINAISON_VALIDE_DE + EscapeGameConfig.getLongueur()
				    + Affichage.CHIFFRES2);
				logger.error(Affichage.VEUILLEZ_RESSAISIR_UNE_COMBINAISON_VALIDE_DE + EscapeGameConfig.getLongueur()
				    + Affichage.CHIFFRES2);
			}
		} while (!saisieCorrect);
		return combigenereestr;
	}

	@Override
	public String saisirIndice(String prop) {
		boolean saisieok;
		String indice;
		do {
			logger.info(Affichage.SAISISSEZ_DES_INDICES_SELON_LA_COMBINAISON_PROPOSEE);
			System.out.println(Affichage.SAISISSEZ_DES_INDICES_SELON_LA_COMBINAISON_PROPOSEE);
			Scanner clavier = new Scanner(System.in);
			saisieok = true;
			indice = clavier.nextLine();
			for (int i = 0; i < indice.length(); i++) {
				if ((indice.charAt(i) != '=' && indice.charAt(i) != '+' && indice.charAt(i) != '-')
				    || indice.length() != prop.length()) {
					saisieok = false;
				}
			}
			if (!saisieok) {
				System.out.println(Affichage.VEUILLEZ_RESSAISIR_VOTRE_INDICE);
				logger.debug(Affichage.VEUILLEZ_RESSAISIR_VOTRE_INDICE);
			}
		} while (!saisieok);
		return indice;
	}

	@Override
	public void affichageGagnant() {
		logger.info(Affichage.BRAVO_VOUS_AVEZ_GAGNE);
		System.out.println(Affichage.BRAVO_VOUS_AVEZ_GAGNE);
	}

	@Override
	public void affichagePerdant() {
		logger.info(Affichage.DOMMAGE_VOUS_AVEZ_PERDU);
		System.out.println(Affichage.DOMMAGE_VOUS_AVEZ_PERDU);
	}
}