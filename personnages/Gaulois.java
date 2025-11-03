package personnages;

public class Gaulois {
	private String nom ;
	//private int force ;
	private int effetPotion = 1;
	private int force;
	private int nb_trophees;
	private Equipement[] trophees = new Equipement[100];

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",8);
		System.out.println(asterix);
	}
	
	public Gaulois(String nom, int force) {
		this.nom = nom ;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + """ + texte + """ );
		
	}
	
//	private String prendreParole() {
//		return "Le gaulois" + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}

	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + " ,effetPotion=" + effetPotion + "]";
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + "envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup(force/3);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
		break;
	}
		
}

