package TP2;

public class DetecteurTemperature {
    private float temperature;

    // Constructeur
    public DetecteurTemperature() {
        this.temperature = 0; // Initialisation à une valeur de base
    }

    // Méthode pour définir la température actuelle
    public void setTemperature(float t) {
        this.temperature = t;
    }

    // Méthode pour obtenir le niveau de température
    public String getNiveau() {
        if (temperature < 30) {
            return "normal";
        } else if (temperature >= 30 && temperature < 38) {
            return "élevé";
        } else {
            return "critique";
        }
    }

    // Méthode pour vérifier si le niveau courant est au moins le niveau donné
    public boolean isNiveauAtteint(String niveau) {
        String niveauCourant = getNiveau();
        if (niveau.equals("normal")) {
            return niveauCourant.equals("normal");
        } else if (niveau.equals("élevé")) {
            return niveauCourant.equals("élevé") || niveauCourant.equals("critique");
        } else {
            return niveauCourant.equals("critique");
        }
    }

    public static void main(String[] args) {
        DetecteurTemperature detecteurTemperature = new DetecteurTemperature();

        for (float temperature = 25; temperature < 45; temperature += 2) {
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
