package fr.hghanmi.joueurs;

import org.apache.log4j.Logger;

import fr.hghanmi.config.EscapeGameConfig;
import fr.hghanmi.Affichage;
import fr.hghanmi.Interface.IAttaquant;
import fr.hghanmi.Interface.IDefenseur;

public abstract class Jeu {

	Logger logger = Logger.getLogger(Jeu.class);

	protected IAttaquant attaquant;
	protected IDefenseur defenseur;

	public abstract void inverserJoueur();

	public void lancer(int mode) {
		boolean trouve = false;
		do {
			inverserJoueur();

			String prop = attaquant.genererProposition(attaquant.getIndice());
			if (defenseur.getCombinaisonSecrete().equals(prop)) {
				System.out.println(Affichage.COMBI_TROUVEE);
				logger.info(Affichage.COMBI_TROUVEE);
				trouve = true;
				attaquant.affichageGagnant();
			} else {
				attaquant.setIndice(defenseur.saisirIndice(prop));
				System.out.println(Affichage.INDICE + attaquant.getIndice());
				logger.info(Affichage.INDICE + attaquant.getIndice());
			}

			incrementNombreEssai();
		} while (attaquant.getNombreEssai() <= EscapeGameConfig.getNombreEssai() && !trouve);
		if (!trouve) {
			defenseur.affichageGagnant();
		}
	}

	protected abstract void incrementNombreEssai();
}