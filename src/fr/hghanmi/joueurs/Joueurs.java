package fr.hghanmi.joueurs;

import org.apache.log4j.Logger;

import fr.hghanmi.Interface.IAttaquant;
import fr.hghanmi.Interface.IDefenseur;

public abstract class Joueurs implements IAttaquant, IDefenseur {
	private Logger logger = Logger.getLogger(Joueurs.class);
	protected String combinaisonSecrete;
	private int nombreEssai;
	private boolean gagnant = false;
	private boolean defenseur;
	private String indice;

	public Joueurs(boolean defense) {
		defenseur = defense;

		if (defenseur) {
			genererCombial();
		} else {
			nombreEssai = 1;
		}
	}

	public String getCombinaisonSecrete() {
		return combinaisonSecrete;
	}

	public int getNombreEssai() {
		return nombreEssai;
	}

	public void incrementNombreEssai() {
		nombreEssai++;
	}

	@Override
	public void setGagnant() {
		gagnant = true;
	}

	@Override
	public boolean gagnant() {
		return gagnant;
	}

	@Override
	public void setIndice(String saisirIndice) {
		indice = saisirIndice;

	}

	@Override
	public String getIndice() {
		return indice;
	}
}
