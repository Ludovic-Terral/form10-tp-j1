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
			return "Elev�";
		}else {
			return "Critique";
		}
	}
	
	public boolean isNiveauAtteint(String niveau) {
		String nActuel=getNiveau();
		if(niveau.equals("Normale")) {
			return nActuel.equals("Normale") || nActuel.equals("Elev�") || nActuel.equals("Critique");
		}else if(niveau.equals("Elev�")) {
			return nActuel.equals("Elev�") || nActuel.equals("Critique");
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
          System.out.println("Temp�rature actuelle    = " + temperature);
          System.out.println("Niveau actuel           = " + detecteurTemperature.getNiveau());
          System.out.println("Niveau normal atteint   = " + detecteurTemperature.isNiveauAtteint("normal"));
          System.out.println("Niveau �lev� atteint    = " + detecteurTemperature.isNiveauAtteint("�lev�"));
          System.out.println("Niveau critique atteint = " + detecteurTemperature.isNiveauAtteint("critique"));
          System.out.println("###################################");
        }
      }
}
