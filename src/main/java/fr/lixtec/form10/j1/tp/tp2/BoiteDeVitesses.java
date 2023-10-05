package fr.lixtec.form10.j1.tp.tp2;

public class BoiteDeVitesses {
	private int rapport_max;
	private int rapport = 0; // point mort
    public int getVitesse() { return rapport; }
	
	public BoiteDeVitesses(int rapport_max) {
        this.rapport_max = rapport_max;
    }	

    public void changerVitesse() {
        if (rapport < rapport_max) {
            rapport++;
        }
    }

    public void retrograder() {
        if (rapport > -1) {
            rapport--;
        }
    }

	public static void main(String[] args) {
        BoiteDeVitesses boite = new BoiteDeVitesses(6);

        System.out.println(boite.getVitesse());
        boite.changerVitesse();
        System.out.println(boite.getVitesse());

        // à vos marques
        // prêts ?
        // partez !
        
        boite.changerVitesse();
        System.out.println(boite.getVitesse());
        boite.changerVitesse();
        System.out.println(boite.getVitesse());
        boite.changerVitesse();
        System.out.println(boite.getVitesse());
        boite.changerVitesse();
        System.out.println(boite.getVitesse());
        boite.changerVitesse();
        System.out.println(boite.getVitesse());
        boite.changerVitesse();
        System.out.println(boite.getVitesse());
        boite.changerVitesse();
	}
}
