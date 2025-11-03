package personnages;
package objets;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipements = 0;
	private Equipement equipements = new Equipement[2];
	private String texte;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + """ + texte + """);
	}
	
	private String prendreParole() {
		return "Le romain " + getNom() + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//		int forceDebut = force;
//		force -= forceCoup;
//		if(force>0) {
//			parler("Aie");
//			assert forceDebut < force;
//		} else {
//			parler ("J'abandonne...");
//			assert forceDebut < force;
//		}
//	}
//	
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
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if(force == 0) {
			parler("Aïe");
		}else{
			equipementEjecte ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}
	
	private int ResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de" + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else if((equipements[i] != null && equipements[i].equals(Equipement.CASQUE))){
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (!(equipements[i] == null)) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			} 	
		}
		return equipementEjecte;
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

