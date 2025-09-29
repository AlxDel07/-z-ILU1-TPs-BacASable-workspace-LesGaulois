package personnages;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;
	
	public Chaudron(int quantitePotion, int forcePotion) {
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
	}
	
	public boolean resterPotion() {
		return quantitePotion > 0;
	}
	
	public void remplirChaudron(int quantite, int forcePotion) {
		quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}
	
	public int prendreLouche() {
		if(quantitePotion > 0) {
			quantitePotion = quantitePotion - 1;
			return forcePotion;
		}else {
			return 0;
		}
		
	}
}
