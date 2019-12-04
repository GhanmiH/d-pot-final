package fr.hghanmi.modedejeu;

import org.apache.log4j.Logger;

import fr.hghanmi.Affichage;
import fr.hghanmi.Interface.IAttaquant;
import fr.hghanmi.Interface.IDefenseur;
import fr.hghanmi.joueurs.Jeu;
import fr.hghanmi.joueurs.JoueurHumain;
import fr.hghanmi.joueurs.JoueurOrdinateur;

public class ModeDuel extends Jeu {

	Logger logger = Logger.getLogger(ModeDuel.class);

	IAttaquant attaquant2;
	IDefenseur defenseur2;

	public ModeDuel() throws Exception {

		System.out.println(Affichage.MODE_DUEL);
		System.out.println(Affichage.BIENVENUE_MD);
		System.out.println(Affichage.JEU);
		System.out.println(Affichage.REGLE5);
		System.out.println(Affichage.BONNE_CHANCE);

		logger.info(Affichage.MODE_DUEL);
		logger.info(Affichage.BIENVENUE_MD);
		logger.info(Affichage.JEU);
		logger.info(Affichage.REGLE5);
		logger.info(Affichage.BONNE_CHANCE);

		defenseur = new JoueurOrdinateur(true);
		attaquant = new JoueurHumain(false);
		defenseur2 = new JoueurHumain(true);
		attaquant2 = new JoueurOrdinateur(false);
	}

	@Override
	public void inverserJoueur() {
		IAttaquant att = attaquant;
		IDefenseur def = defenseur;
		defenseur = defenseur2;
		attaquant = attaquant2;
		defenseur2 = def;
		attaquant2 = att;
	}

	@Override
	protected void incrementNombreEssai() {
		// TODO Auto-generated method stub

	}
}
