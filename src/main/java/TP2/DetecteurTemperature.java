package TP2;

public class DetecteurTemperature {
	
	private float _temperature;

	//Pour positionner la température actuelle.
	public void setTemperature(float t){
		_temperature = t;
	}

	//Qui retourne le niveau de la température actuelle sous la forme
	//d’une chaîne de caracteres : « normal », « élevé », « critique »
	public String getNiveau(){
		
		if(_temperature < 30) {
			return "normal";
		}
		else if(_temperature > 38) {
			return "critique";
		}
		else 
			return "eleve";
		
			
	}
	
	//Qui retourne true ou false 
	//si le niveau courant est au moins le niveau donné en parametre.
	public boolean isNiveauAtteint(String niveau) {
		
		if (niveau.equals(getNiveau())){
			return true;
		}
		else
			return false;

	}
	

	public static void main(String[] args) {
		  DetecteurTemperature detecteurTemperature = new DetecteurTemperature();

		  for(float temperature = 25; temperature < 45; temperature += 2) {
		    detecteurTemperature.setTemperature(temperature);
		    System.out.println("Température actuelle    = " + temperature);
		    System.out.println("Niveau actuel           = " + detecteurTemperature.getNiveau());
		    System.out.println("Niveau normal atteint   = " + detecteurTemperature.isNiveauAtteint("normal"));
		    System.out.println("Niveau élevé atteint    = " + detecteurTemperature.isNiveauAtteint("élevé"));
		    System.out.println("Niveau critique atteint = " + detecteurTemperature.isNiveauAtteint("critique"));
		    System.out.println("###################################");
		  }
		}
	
	
	
}
