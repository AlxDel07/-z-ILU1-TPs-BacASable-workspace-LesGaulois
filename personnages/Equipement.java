
public enum Equipement {
	CASQUE("casque"),BOUCLIER("bouclier");
	
	private String nom;
	private Equipements(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		return nom;
	}
}
