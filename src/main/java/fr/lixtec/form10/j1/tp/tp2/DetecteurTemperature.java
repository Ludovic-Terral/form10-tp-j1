package fr.lixtec.form10.j1.tp.tp2;

public class DetecteurTemperature {
    private float temperature; // Température actuelle

    public void setTemperature(float t) {
        // Pour positionner la température actuelle.
        temperature = t;
    }

    public String getNiveau() {
        // Qui retourne le niveau de la température actuelle sous la forme
        // d’une chaîne de caractères : « normal », « élevé », « critique »
        if (temperature < 30) {
            return "normal";
        } else if (temperature < 38) {
            return "élevé";
        } else {
            return "critique";
        }
    }

    public boolean isNiveauAtteint(String niveau) {
        // Qui retourne true ou false si le niveau courant est au moins
        // le niveau donné en paramètre.
        String niveauActuel = getNiveau();
        return niveauActuel.equals(niveau);
    }



public static void main(String[] args) {
    DetecteurTemperature detecteurTemperature = new DetecteurTemperature();

    for (float temperature = 20; temperature < 40; temperature += 2) {
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
