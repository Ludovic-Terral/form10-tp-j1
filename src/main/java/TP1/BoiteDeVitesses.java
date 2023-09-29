package TP1;

import java.util.Scanner;

public class BoiteDeVitesses {
	private int vitesse = 0;
	
	private void changerVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	private void retrograder() {
		vitesse = vitesse - 1;
	}
	private int getVitesse() {
		return vitesse;
	}
    public static void main(String[] args) {
		BoiteDeVitesses Bdv = new BoiteDeVitesses();
		while (true) {
			System.out.print("Chosir vitesse : ");
			Scanner sc = new Scanner(System.in);
			int demande = sc.nextInt();
			Bdv.changerVitesse(demande);
			System.out.println("Vitesse : " + Bdv.getVitesse() );
			Bdv.retrograder();
			System.out.print("Retrogradation : ");
			System.out.println("Vitesse : " + Bdv.getVitesse() );
		}
    }
}