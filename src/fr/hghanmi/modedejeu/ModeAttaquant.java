package fr.hghanmi.modedejeu;

import org.apache.log4j.Logger;

import fr.hghanmi.Affichage;
import fr.hghanmi.config.EscapeGameConfig;
import fr.hghanmi.joueurs.Jeu;
import fr.hghanmi.joueurs.JoueurHumain;
import fr.hghanmi.joueurs.JoueurOrdinateur;

public class ModeAttaquant extends Jeu {
	Logger logger = Logger.getLogger(ModeAttaquant.class);

	public ModeAttaquant() {
		defenseur = new JoueurOrdinateur(true);
		attaquant = new JoueurHumain(false);
		System.out.println(Affichage.MODE_CHALLENGER);
		System.out.println(Affichage.REGLES);
		System.out.println(Affichage.REGLE2);
		System.out.println(EscapeGameConfig.getLongueur() + Affichage.CHIFFRES_QUE_VOUS_DEVEZ_LA_DEVINER_EN
		    + EscapeGameConfig.getNombreEssai() + Affichage.ESSAIS_MAXIMUM);
		System.out.println(Affichage.A_VOUS_DE_JOUER_BONNE_CHANCE);

		logger.info(Affichage.A_VOUS_DE_JOUER_BONNE_CHANCE);
		logger.info(Affichage.MODE_CHALLENGER);
		logger.info(Affichage.REGLES);
		logger.info(Affichage.REGLE2);
		logger.info(EscapeGameConfig.getLongueur() + Affichage.CHIFFRES_QUE_VOUS_DEVEZ_LA_DEVINER_EN
		    + EscapeGameConfig.getNombreEssai() + Affichage.ESSAIS_MAXIMUM);
		logger.info(Affichage.A_VOUS_DE_JOUER_BONNE_CHANCE);
	}

	@Override
	public void inverserJoueur() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void incrementNombreEssai() {
		attaquant.incrementNombreEssai();
	}

}
