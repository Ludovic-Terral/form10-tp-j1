public class DetecteurTemperature {

    private float temperature;

    public void setTemperature(float t) {
        this.temperature = t;
    }

    public String getNiveau() {
        if (temperature < 30) {
            return "normal";
        } else if (temperature >= 30 && temperature < 38) {
            return "élevé";
        } else {
            return "critique";
        }
    }

    public boolean isNiveauAtteint(String niveau) {
        String currentNiveau = getNiveau();
        
        switch(niveau) {
            case "normal":
                return true; // La température sera toujours au moins "normal"
            case "élevé":
                return !currentNiveau.equals("normal");
            case "critique":
                return currentNiveau.equals("critique");
            default:
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
