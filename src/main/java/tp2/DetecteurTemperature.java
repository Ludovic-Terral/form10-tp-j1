package tp2;

public class DetecteurTemperature {
	
	private float temperature_actuel = 0;
	
	private String niveau_actuel = "";
	
	public DetecteurTemperature() {
		this.temperature_actuel = 0;
	}
	
	public float setTemperature(float t)
	{
		return(temperature_actuel = t);
	}
	
	public String getNiveau() {
		
		if(temperature_actuel<30)return(niveau_actuel="normal");
		if((30<temperature_actuel)&&(temperature_actuel<38))return(niveau_actuel="élevé");
		if(temperature_actuel>38)return(niveau_actuel="critique");
		return null;
	}
	public boolean isNiveauAtteint(String niveau) {
		if(niveau==niveau_actuel)return true;
		else{return(false);}
		
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
