package TP2;

public class DetecteurTemperature {
	private float temperature; 
	
	public void setTemperature(float t)
	{
		temperature =t; 
	}
	
	public String getNiveau() {
		if(temperature<30) {
			return "Normale";
		}else if (temperature <38){
			return "Elevé";
		}else {
			return "Critique";
		}
	}
	
	public boolean isNiveauAtteint(String niveau) {
		String nActuel=getNiveau();
		if(niveau.equals("Normale")) {
			return nActuel.equals("Normale") || nActuel.equals("Elevé") || nActuel.equals("Critique");
		}else if(niveau.equals("Elevé")) {
			return nActuel.equals("Elevé") || nActuel.equals("Critique");
		}else if(nActuel.equals("Critique")) {
			return nActuel.equals("Critique");
		}else {
			return false; 
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
          System.out.println("###################################");
        }
      }
}
