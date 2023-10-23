package TP3;

class Joueur {

	//pour chaque joeuur 2 grille
	private Grille tir = new Grille();
	private Grille navire = new Grille();
	private String nom;
	
	//Accesseurs
	public Grille getTir() {
		return this.tir;
	}
	
	public Grille getNavire() {
		return this.navire;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
}
