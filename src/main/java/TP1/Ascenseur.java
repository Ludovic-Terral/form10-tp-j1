package TP1;

import java.util.Scanner;

public class Ascenseur {
	private int etage = 0;
	
	public int getEtage() {
		return etage;
	}
	public  void appelerDepuis(int etage) {
		this.etage = etage;
	}
	
	public static void main(String[] args) {
		Ascenseur Asc = new Ascenseur();
		while (true) {
			System.out.print("Chosir etage : ");
			Scanner sc = new Scanner(System.in);
			int demande = sc.nextInt();
			Asc.appelerDepuis(demande);
			System.out.println("Etage de l'ascenseur : " + Asc.getEtage() );
		}
    }
}