package personnages;

public class Gaulois {
	private String nom ;
	private int force ;
	private int effetPotion = 1;
	private Village village;

		
	public Gaulois(String nom, int force) {
		this.nom = nom ;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»" );
		
	}
	
	public void setVillage(Village village) {
		this.village = village;
	}
	
	private String prendreParole() {
		return "Le gaulois" + nom + " : ";
	}
	
	public String toString() {
		return nom;
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force * effetPotion / 3);
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}
	
	public void sePresenter() {
		if(village.getChef() == this) {
			parler("Bonjour, je m'appelle " + toString() + ". Je suis le chef le village " + village.getNom());
		}else {
			if(village != null) {
				parler("Bonjour, je m'appelle " + toString() + " J'habite le village " + village.getNom());
			}else {
				parler("Bonjour, je m'appelle " + toString() + "Je voyage de villages en villages.");
			}
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",8);
		System.out.println(asterix);
	}
}