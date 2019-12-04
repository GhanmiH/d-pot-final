package fr.hghanmi.Interface;

public interface IDefenseur extends IJoueurs {
	String genererCombial();
	String getCombinaisonSecrete();
	String saisirIndice(String prop);
	void setIndice(String saisirIndice);
}
