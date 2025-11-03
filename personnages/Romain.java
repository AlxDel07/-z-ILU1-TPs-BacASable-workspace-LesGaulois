package personnages;
package objets;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipements = 0;
	private Equipement equipements = new Equipement[2];
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "�" + texte + "�");
	}
	
	private String prendreParole() {
		return "Le romain " + getNom() + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		int forceDebut = force;
		force -= forceCoup;
		if(force>0) {
			parler("Aie");
			assert forceDebut < force;
		} else {
			parler ("J'abandonne...");
			assert forceDebut < force;
		}
	}
	
	private boolean isInvariantVerified() {
		return force >= 0;
	}
	
	public void afficherEquipements() {
		System.out.println(Equipements.CASQUE);
		System.out.println(Equipements.BOUCLIER);
	}
	
	public void ajouterEquipement(Equipement equipement) {
		System.out.println("Le soldat" + getNom() + "s'équipe avec" + equipement.toString() + ". ");
		equipements[nbEquipements] = equipement;
		nbEquipements ++;
	}
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipements) {
			case 2:
				System.out.println("Le soldat" + getNom() + "est déjà bien protégé ! ");
			case 1:
				if(equipements[0] == equipement) {
					System.out.println("Le soldat" + getNom() + "possède déja un" + equipement.toString() + " ! ");
				}else {
					ajouterEquipement(equipement);
				}
			case 0:
				ajouterEquipement(equipement);
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		assert minus.isInvariantVerified();
		minus.afficherEquipements();
		minus.sEquiper(Equipement CASQUE);
		minus.sEquiper(Equipement CASQUE);
		minus.sEquiper(Equipement BOUCLIER);
		minus.sEquiper(Equipement CASQUE);
	}
	
}

