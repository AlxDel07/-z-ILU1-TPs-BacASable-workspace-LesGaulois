package personnages;

public class Village {
	private Gaulois chef;
	private String nom;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	
	private Village(Gaulois chef, String nom, int nbMaxHabitants) {
		this.chef = chef;
		this.nom = nom;
		this.villageois = new Gaulois[nbMaxHabitants];
	}
	
	public String getNom() {
		return nom;
	}
	
	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
		gaulois.setVillage(this);
	}
	
	public Gaulois trouverVillageois(int entier) {
		if(entier > nbVillageois) {
			System.out.print("Il n'y a pas autant d'habitants dans ce village \n");
			return null;
		}else {
			return villageois[entier-1];
		}
	}
	
	public void afficherVillageois() {
		System.out.print("Dans le village " + nom + " du chef " + chef.getNom() + " vivent les légendaires gaulois : \n");
		for(Gaulois gaulois : villageois) {
			if(gaulois != null) {
				System.out.print("- " + gaulois.getNom() + "\n");
			}
		}
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix",8);
		Village village = new Village(abraracourcix,"Village des Irréductibles",30);
		Gaulois asterix = new Gaulois("Astérix",8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.print(gaulois + "\n");
		gaulois = village.trouverVillageois(2);
		System.out.print(gaulois + "\n");
		village.afficherVillageois();
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterVillageois(obelix);
		village.afficherVillageois();
		Gaulois doublePolemix = new Gaulois("DoublePolémix",4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublePolemix.sePresenter();
	}
}
