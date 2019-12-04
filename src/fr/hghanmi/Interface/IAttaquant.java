package fr.hghanmi.Interface;

public interface IAttaquant extends IJoueurs {
	String genererProposition(String indice);
	int getNombreEssai();
	void incrementNombreEssai();
	String getIndice();
	void setIndice(String saisirIndice);
	
}
