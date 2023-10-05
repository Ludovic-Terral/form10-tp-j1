package TP2;

public class DetecteurTemperature {
	private float temp = 0;
	private String lvl;
	
	private void setTemperature(float t) {
		temp = t;
		if (temp<30) lvl = "normal";
		if (temp>30 & temp<38) lvl = "élevé";
		if (temp>38) lvl = "critique";
	}
	public String getNiveau() {
		return lvl;
	}
	public boolean isNiveauAtteint(String niveau) {
		return lvl == niveau ;
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
