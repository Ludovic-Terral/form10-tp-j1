package tp3;


public class Vaisseau {
    public enum Type {
        UNIVERSE("Universe", 3, 2),
        SOVEREIGN("Sovereign", 2, 2),
        AMBASSADOR("Ambassador", 3, 1),
        CONSTITUTION("Constitution", 3, 1),
        NAVETTE("Navette", 2, 1);

        private final String nom;
        private final int largeur;
        private final int hauteur;

        Type(String nom, int largeur, int hauteur) {
            this.nom = nom;
            this.largeur = largeur;
            this.hauteur = hauteur;
        }

        public String getNom() {
            return nom;
        }

        public int getLargeur() {
            return largeur;
        }

        public int getHauteur() {
            return hauteur;
        }
    }

    private final Type type;
    private String position; // Coordonnées du vaisseau (par exemple, A1)

    public Vaisseau(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public int getLargeur() {
        return type.getLargeur();
    }

    public int getHauteur() {
        return type.getHauteur();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
