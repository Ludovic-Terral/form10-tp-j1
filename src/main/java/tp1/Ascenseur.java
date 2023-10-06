package tp1;

public class Ascenseur {
	
	
	private int etageActuel = 0;
	
	public Ascenseur () {
		
		this.etageActuel=0;
	}

	public int getEtage()
	{
		if(etageActuel==0)return(0);
		return(etageActuel);
	}
	
	public void appelerDepuis(int etage) {
		
		if(etage<0)System.out.println("L'Ascenceur est a l'etage");
		if(etage>etageActuel)System.out.println("L'Ascenceur est en mouvement vers le HAUT");
		if(etage<etageActuel)System.out.println("L'Ascenceur est en mouvement vers le BAS");
		etageActuel = etage;
	}
	
	public static void main(String[] args) {
		Ascenseur firstascenceur = new Ascenseur();
		
		firstascenceur.appelerDepuis(3); // L'ascenseur monte de l'étage 0 à l'étage 3
        System.out.println("L'ascenseur est maintenant à l'étage " + firstascenceur.getEtage());
        
        
        firstascenceur.appelerDepuis(1); // L'ascenseur monte de l'étage 0 à l'étage 3
        System.out.println("L'ascenseur est maintenant à l'étage " + firstascenceur.getEtage());
        
	}

}

