package fr.lixtec.form10.j1.tp.tp2;

public class DetecteurTemperature {
	
	private float temperature;
	private String LevelTemp;
	
	public void setTemperature(float t) {
		temperature = t;
		
		if(t < 30) {
			System.out.println(t + " < 30°C");
		}
		else if(t >= 30 && t < 38) {
			System.out.println("30°C <= " + t + " < 38°C");
		}
		else {
			System.out.println(t + " > 38°C");
		}
	}

	public String getNiveau() {
		
		if(temperature < 30) {
			LevelTemp = "normal";
		}
		else if(temperature > 30 && temperature < 38) {
			LevelTemp = "élevé";
		}
		else {
			LevelTemp = "critique";
		}
		return LevelTemp;
	}
	
	public boolean isNiveauAtteint(String niveau) {
		
		return niveau.equals(getNiveau());
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
