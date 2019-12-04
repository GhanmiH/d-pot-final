package fr.hghanmi.modedejeu;

import org.apache.log4j.Logger;

import fr.hghanmi.Affichage;
import fr.hghanmi.config.EscapeGameConfig;
import fr.hghanmi.joueurs.Jeu;
import fr.hghanmi.joueurs.JoueurHumain;
import fr.hghanmi.joueurs.JoueurOrdinateur;

public class ModeDefenseur extends Jeu {
	Logger logger = Logger.getLogger(ModeDefenseur.class);

	public ModeDefenseur() {

		System.out.println(Affichage.MODE_DEFENSEUR);
		System.out.println(Affichage.BIENVENUE);
		System.out.println(Affichage.REGLE3);
		System.out.println(EscapeGameConfig.getLongueur() + Affichage.REGLE4 + EscapeGameConfig.getNombreEssai()
		    + Affichage.ESSAIS_MAXIMUM);
		System.out.println(Affichage.A_VOUS_DE_JOUER_BONNE_CHANCE);

		logger.info(Affichage.MODE_DEFENSEUR);
		logger.info(Affichage.BIENVENUE);
		logger.info(Affichage.REGLE3);
		logger.info(EscapeGameConfig.getLongueur() + Affichage.REGLE4 + EscapeGameConfig.getNombreEssai()
		    + Affichage.ESSAIS_MAXIMUM);
		logger.info(Affichage.A_VOUS_DE_JOUER_BONNE_CHANCE);

		defenseur = new JoueurHumain(true);
		attaquant = new JoueurOrdinateur(false);

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
