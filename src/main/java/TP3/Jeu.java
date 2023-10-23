package TP3;

import java.util.InputMismatchException;
import java.util.Scanner;

class Jeu {

	public static Joueur j1 = new Joueur();
	public static Joueur j2 = new Joueur();
	
	public static void homeSpaceship() {
		
		//on ouvre le scanner  pour les joueurs
		try {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Matricule du Joueur1 : ");
		j1.setNom(keyboard.next());
		System.out.println("Matricule du Joueur2 : ");
		j2.setNom(keyboard.next());
		
		System.out.println(" Player1 => "+j1.getNom()+"\n Player2 => "+j2.getNom() + '\n');
		System.out.println("Grille de navire du joueur 1 : \n");
		
		
	}
		catch(InputMismatchException e){
		System.out.println("erreur ! ");
	}
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		homeSpaceship();
		j1.getTir().displayGrille();
		
		//appelle de la fonction de récupération de la saisie des navires.
		}
}
