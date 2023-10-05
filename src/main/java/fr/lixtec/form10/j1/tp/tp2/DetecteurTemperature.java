package fr.lixtec.form10.j1.tp.tp2;
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
    
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        correspondanceTemperaturesNiveaux();
    }
    
    public String getNiveau() {
        return niveau;
    }
     
    public boolean isNiveauAtteint(String niveau){
        return dicNiveaux.get(this.niveau) >= dicNiveaux.get(niveau);
    }
    
    public void correspondanceTemperaturesNiveaux() {
        if(temperature <= 30) {
            this.niveau = "normal";
        }
        else if(temperature >= 30 
             && temperature <= 38) {
            this.niveau = "élevé";
        }
        else {
            this.niveau = "critique";
        }
    }
}