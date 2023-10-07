package fr.lixtec.form10.j1.tp.tp2.TP2;
import java.util.Dictionary;
import java.util.Hashtable;

public class DetecteurTemperature {
	private float temperature = 25;
	private String niveau;
	private Hashtable<String, Integer> dicNiveaux;
	
	public DetecteurTemperature() {
		this.dicNiveaux = new Hashtable<String, Integer>();
		this.dicNiveaux.put("normal", 0);
		this.dicNiveaux.put("élevé", 1);
		this.dicNiveaux.put("critique", 2);
		
	}
	
	public void setTemperature(float t) {
		this.temperature = t;
		correspondanceTemperaturesNiveaux();
	}
	
	public String getNiveau() {
		return niveau;
	}
	 
	public boolean isNiveauAtteint(String niveau){
		//return true si le nb qui correspond au niveau actuel dans le dico est supérieur ou égal au niveau demandé
		return dicNiveaux.get(this.niveau) >= dicNiveaux.get(niveau);
	}
	
	public void correspondanceTemperaturesNiveaux() {
		if(temperature <= 30) {
			this.niveau = "normal";
		}else if(temperature >= 30 && temperature <= 38) {
			this.niveau = "élevé";
		}else if(temperature >= 38) {
			this.niveau = "critique";
		}
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
		    System.out.println("######################################");
		  }
	}
}
