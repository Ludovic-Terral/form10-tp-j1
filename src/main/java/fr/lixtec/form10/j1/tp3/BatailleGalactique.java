package fr.lixtec.form10.j1.tp3;

import java.util.Scanner;

class Vaisseau {
    private String nom;
    private int largeur;
    private int hauteur;
    private int etat; // 100% au départ, 0% s'il est détruit

    public Vaisseau(String nom, int largeur, int hauteur) {
        this.nom = nom;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.etat = 100;
    }

    public boolean estTouche(int x, int y) {
        // Pour simplifier, considérons que le vaisseau est touché s'il est dans la zone du tir
        return x <= largeur && y <= hauteur;
    }

    public void subirDegats(int degats) {
        etat -= degats;
    }

    public boolean estDetruit() {
        return etat <= 0;
    }

    public String getNom() {
        return nom;
    }

    public int getEtat() {
        return etat;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }
}

class Grille {
    private char[][] cases;

    public Grille() {
        cases = new char[10][8];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                cases[i][j] = ' ';
            }
        }
    }

    public void afficher() {
        System.out.println("Grille de tir :");
        System.out.println("  A B C D E F G H");
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(cases[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean placerVaisseau(Vaisseau vaisseau, int x, int y, char orientation) {
        // Vérifier si les coordonnées sont valides
        if (x < 0 || x >= 10 || y < 0 || y >= 8) {
            System.out.println("Coordonnées de placement invalides.");
            return false;
        }

        // Vérifier si le vaisseau ne dépasse pas les limites de la grille
        if (orientation == 'H') {
            if (x + vaisseau.getLargeur() > 10 || y + vaisseau.getHauteur() > 8) {
                System.out.println("Placement invalide, le vaisseau dépasse les limites de la grille.");
                return false;
            }
        } else if (orientation == 'V') {
            if (x + vaisseau.getHauteur() > 10 || y + vaisseau.getLargeur() > 8) {
                System.out.println("Placement invalide, le vaisseau dépasse les limites de la grille.");
                return false;
            }
        } else {
            System.out.println("Orientation invalide. Utilisez 'H' pour horizontal ou 'V' pour vertical.");
            return false;
        }

        // Vérifier si la case est déjà occupée
        for (int i = x; i < x + vaisseau.getHauteur(); i++) {
            for (int j = y; j < y + vaisseau.getLargeur(); j++) {
                if (cases[i][j] != ' ') {
                    System.out.println("Placement invalide, une case est déjà occupée.");
                    return false;
                }
            }
        }

        // Placer le vaisseau sur la grille
        for (int i = x; i < x + vaisseau.getHauteur(); i++) {
            for (int j = y; j < y + vaisseau.getLargeur(); j++) {
                cases[i][j] = 'O'; // Marquer "O" pour occupé
            }
        }

        return true; // Placement réussi
    }

    public void tirer(int x, char y) {
        // TODO Auto-generated method stub
    }
}

class Joueur {
    String nom;
    private Grille grille;
    Vaisseau[] flotte;

    public Joueur(String nom) {
        this.nom = nom;
        this.grille = new Grille();
        this.flotte = new Vaisseau[5];
    }

    // Configuration des vaisseaux avec des caractéristiques prédéfinies
    public void configurerFlotte() {
        System.out.println(nom + ", configurez votre flotte :");

        Vaisseau[] vaisseauxPredéfinis = {
            new Vaisseau("Universe", 3, 2),
            new Vaisseau("Sovereign", 2, 2),
            new Vaisseau("Ambassadeur", 3, 1),
            new Vaisseau("Constitution", 3, 1),
            new Vaisseau("Navette", 2, 1)
        };

        for (int i = 0; i < 5; i++) {
            Vaisseau vaisseau = vaisseauxPredéfinis[i];
            System.out.println("Positionnement du vaisseau " + vaisseau.getNom() + " (" + vaisseau.getLargeur() + "x" + vaisseau.getHauteur() + "):");
            System.out.print("Position X (1-10) : ");
            int posX = new Scanner(System.in).nextInt();
            System.out.print("Position Y (A-H) : ");
            char posY = new Scanner(System.in).next().charAt(0);
            System.out.print("Orientation (H ou V) : ");
            char orientation = new Scanner(System.in).next().charAt(0);

            boolean place = grille.placerVaisseau(vaisseau, posX - 1, posY - 'A', orientation);

            if (place) {
                flotte[i] = vaisseau;
                System.out.println(vaisseau.getNom() + " placé avec succès !");
            } else {
                System.out.println("Placement invalide pour le vaisseau " + vaisseau.getNom() + ". Réessayez.");
                i--; // Réessayer pour le même vaisseau
            }
        }
    }

    // ... (autres membres de la classe)

    public Grille getGrille() {
        return grille;
    }
}

public class BatailleGalactique {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans la Bataille Galactique !");
        System.out.print("Nom du Joueur 1 : ");
        Joueur joueur1 = new Joueur(scanner.nextLine());

        System.out.print("Nom du Joueur 2 : ");
        Joueur joueur2 = new Joueur(scanner.nextLine());

        joueur1.configurerFlotte();
        joueur2.configurerFlotte();

        // Le reste du code reste inchangé
        // ...

        scanner.close();
    }
}
