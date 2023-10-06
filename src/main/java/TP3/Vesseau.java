public class Vaisseau {
    private String type;
    private int taille;
    private int vie;

    public Vaisseau(String type, int taille) {
        this.type = type;
        this.taille = taille;
        this.vie = taille;
    }

    public void reduireVie() {
        vie--;
    }

    public boolean estDetruit() {
        return vie <= 0;
    }

    public String getType() {
        return type;
    }
}

