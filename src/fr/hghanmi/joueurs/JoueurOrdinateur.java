package fr.hghanmi.joueurs;

import org.apache.log4j.Logger;

import fr.hghanmi.Affichage;
import fr.hghanmi.config.EscapeGameConfig;

public class JoueurOrdinateur extends Joueurs {
	private String derniereProposition;

	private static Logger logger = Logger.getLogger(JoueurOrdinateur.class);

	private GenerationBorne[] intervals = new GenerationBorne[EscapeGameConfig.getLongueur()];

	public JoueurOrdinateur(boolean defenseur) {
		super(defenseur);

		for (int i = 0; i < EscapeGameConfig.getLongueur(); i++) {
			intervals[i] = new GenerationBorne(0, 9);
		}
	}

	public String genererProposition(String indice) {

		if (indice != null) {

			for (int i = 0; i < EscapeGameConfig.getLongueur(); i++) {
				char c = indice.charAt(i);
				if (c == '+') {
					intervals[i].setBorneMin(Character.getNumericValue(derniereProposition.charAt(i)) + 1);
				} else if (c == '-') {
					intervals[i].setBorneMax(Character.getNumericValue(derniereProposition.charAt(i)) - 1);
				} else {
					intervals[i].setBorneMin(Character.getNumericValue(derniereProposition.charAt(i)));
					intervals[i].setBorneMax(Character.getNumericValue(derniereProposition.charAt(i)));
				}
			}
		}

		derniereProposition = "";
		for (int i = 0; i < EscapeGameConfig.getLongueur(); i++) {
			int milieu = ((intervals[i].getBorneMin() + intervals[i].getBorneMax()) / 2);
			derniereProposition += milieu;
		}

		System.out.println(Affichage.LA_PROPOSITION_DE_L_IA_EST + derniereProposition);
		logger.info(Affichage.LA_PROPOSITION_DE_L_IA_EST + derniereProposition);
		return derniereProposition;
	}

	@Override
	public String saisirIndice(String prop) {
		String resultatindice = "";
		for (int i = 0; i < getCombinaisonSecrete().length(); i++) {
			int com = Integer.parseInt("" + getCombinaisonSecrete().charAt(i));
			int pro = Integer.parseInt("" + prop.charAt(i));

			if (com == pro)
				resultatindice = resultatindice + "=";
			else if (com < pro)
				resultatindice = resultatindice + "-";
			else
				resultatindice = resultatindice + "+";

		}
		return resultatindice;
	}

	@Override
	public String genererCombial() {
		String max = "";
		for (int i = 0; i < EscapeGameConfig.getLongueur(); i++) {
			max += "9";
		}

		int propo = (int) (Math.random() * Integer.parseInt(max) + 0);
		combinaisonSecrete = String.format("%0" + EscapeGameConfig.getLongueur() + "d", propo);

		if (EscapeGameConfig.isModeDeveloppeur()) {
			//System.out.println(Affichage.LA_COMBINAISON_SECRETE_DE_L_IA_EST + combinaisonSecrete);
			//logger.info(Affichage.LA_COMBINAISON_SECRETE_DE_L_IA_EST + combinaisonSecrete);
		}
		return combinaisonSecrete;
	}

	@Override
	public void affichageGagnant() {

		logger.info(Affichage.DOMMAGE_VOUS_AVEZ_PERDU);
		System.out.println(Affichage.DOMMAGE_VOUS_AVEZ_PERDU);
	}

	@Override
	public void affichagePerdant() {
		logger.info(Affichage.BRAVO_VOUS_AVEZ_GAGNE);
		System.out.println(Affichage.BRAVO_VOUS_AVEZ_GAGNE);
	}
}
