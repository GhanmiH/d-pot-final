package fr.hghanmi.joueurs;

public class GenerationBorne {
	int borneMin;
	int borneMax;
	
	public GenerationBorne(int borneMin, int borneMax) {
		this.borneMin = borneMin;
		this.borneMax = borneMax;
	}
	public int getBorneMin() {
		return borneMin;
	}
	public int getBorneMax() {
		return borneMax;
	}
	public void setBorneMin(int borneMin) {
		this.borneMin = borneMin;
	}
	public void setBorneMax(int borneMax) {
		this.borneMax = borneMax;
	}
	
}
