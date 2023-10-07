package fr.lixtec.form10.j1.tp.tp2.TP3;
import java.util.Scanner;

public class BatailleGalactique {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plateau plateauJoueur1 = new Plateau();
        Plateau plateauJoueur2 = new Plateau();

        // Configuration des vaisseaux pour chaque joueur
        configurerVaisseaux(plateauJoueur1, scanner);
        configurerVaisseaux(plateauJoueur2, scanner);

        boolean joueur1Tour = true;
        boolean jeuTermine = false;

        while (!jeuTermine) {
            Plateau plateauCourant = joueur1Tour ? plateauJoueur1 : plateauJoueur2;
            Plateau plateauAdversaire = joueur1Tour ? plateauJoueur2 : plateauJoueur1;

            // Affichage de l'�tat de la flotte et de chaque unit�
            plateauCourant.afficherFlotte();
            plateauAdversaire.afficherGrilleTirs();

            // Demander les coordonn�es de tir
            System.out.println("Joueur " + (joueur1Tour ? "1" : "2") + ", entrez les coordonn�es de tir (ex: H7) : ");
            String coordonnees = scanner.nextLine();

            // Effectuer le tir et obtenir le r�sultat
            ResultatTir resultat = plateauAdversaire.effectuerTir(coordonnees);

            // Afficher le r�sultat du tir
            System.out.println(resultat);

            // V�rifier si le joueur a gagn�
            if (plateauAdversaire.flotteDetruite()) {
                jeuTermine = true;
                System.out.println("Joueur " + (joueur1Tour ? "1" : "2") + " a gagn� !");
            }

            joueur1Tour = !joueur1Tour;
        }

        scanner.close();
    }

    // M�thode pour configurer les vaisseaux d'un joueur
    private static void configurerVaisseaux(Plateau plateau, Scanner scanner) {
        System.out.println("Configuration des vaisseaux pour le joueur :");

        // Configuration du vaisseau Universe
        System.out.println("Configuration du vaisseau Universe (3x2 cases) :");
        configurerVaisseau(plateau, scanner, TypeVaisseau.UNIVERSE);

        // Configuration du vaisseau Sovereign
        System.out.println("Configuration du vaisseau Sovereign (2x2 cases) :");
        configurerVaisseau(plateau, scanner, TypeVaisseau.SOVEREIGN);

        // Configuration du vaisseau Ambassadeur
        System.out.println("Configuration du vaisseau Ambassadeur (3x1 cases) :");
        configurerVaisseau(plateau, scanner, TypeVaisseau.AMBASSADOR);

        // Configuration du vaisseau Constitution
        System.out.println("Configuration du vaisseau Constitution (3x1 cases) :");
        configurerVaisseau(plateau, scanner, TypeVaisseau.CONSTITUTION);

        // Configuration de la navette
        System.out.println("Configuration de la navette (2x1 cases) :");
        configurerVaisseau(plateau, scanner, TypeVaisseau.NAVETTE);
    }

    // M�thode pour configurer un vaisseau sur le plateau
    private static void configurerVaisseau(Plateau plateau, Scanner scanner, TypeVaisseau type) {
        System.out.println("Entrez les coordonn�es de d�but (ex: H7) : ");
        String debutCoordonnees = scanner.nextLine();
        System.out.println("Entrez l'orientation (H pour horizontal, V pour vertical) : ");
        char orientation = scanner.nextLine().charAt(0);

        // Appeler la m�thode pour placer le vaisseau sur le plateau
        plateau.placerVaisseau(type, debutCoordonnees, orientation);
    }
}




enum TypeVaisseau {
    UNIVERSE(3, 2),
    SOVEREIGN(2, 2),
    AMBASSADOR(3, 1),
    CONSTITUTION(3, 1),
    NAVETTE(2, 1);

    private final int largeur;
    private final int hauteur;

    TypeVaisseau(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }
}

class Plateau {
    private char[][] grille;
    private int[][] grilleTirs;
    private int flotteUniverse;
    private int flotteSovereign;
    private int flotteAmbassador;
    private int flotteConstitution;
    private int flotteNavette;

    public Plateau() {
        grille = new char[8][10]; // 8 lignes, 10 colonnes
        grilleTirs = new int[8][10];
        flotteUniverse = 3 * 2;
        flotteSovereign = 2 * 2;
        flotteAmbassador = 3 * 1;
        flotteConstitution = 3 * 1;
        flotteNavette = 2 * 1;
        initialiserGrilles();
    }

    private void initialiserGrilles() {
        // Initialiser les grilles de jeu et de tirs
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                grille[i][j] = ' ';
                grilleTirs[i][j] = 0;
            }
        }
    }

    public void afficherFlotte() {
        System.out.println("Flotte op�rationnelle � " + pourcentageFlotte() + "%");
        System.out.println("- vaisseau de classe Universe op�rationnel � " + (flotteUniverse * 100 / (3 * 2)) + "%");
        System.out.println("- vaisseau de classe Sovereign op�rationnel � " + (flotteSovereign * 100 / (2 * 2)) + "%");
        System.out.println("- vaisseau de classe Ambassadeur op�rationnel � " + (flotteAmbassador * 100 / (3 * 1)) + "%");
        System.out.println("- vaisseau de classe Constitution op�rationnel � " + (flotteConstitution * 100 / (3 * 1)) + "%");
        System.out.println("- navette op�rationnelle � " + (flotteNavette * 100 / (2 * 1)) + "%");
    }

    public void afficherGrilleTirs() {
        System.out.println("Grille des tirs:");
        System.out.print("   ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print((char)('A' + i) + " |");
            for (int j = 0; j < 10; j++) {
                if (grilleTirs[i][j] == 1) {
                    System.out.print("T ");
                } else if (grilleTirs[i][j] == -1) {
                    System.out.print("L ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("|");
        }
        System.out.println("   ---------------");
    }

    public void placerVaisseau(TypeVaisseau type, String debutCoordonnees, char orientation) {
        int ligne = debutCoordonnees.charAt(0) - 'A';
        int colonne = Integer.parseInt(debutCoordonnees.substring(1)) - 1;

        // V�rifier si les coordonn�es sont valides
        if (ligne < 0 || ligne >= 8 || colonne < 0 || colonne >= 10) {
            System.out.println("Coordonn�es invalides. Veuillez r�essayer.");
            return;
        }

        // V�rifier si l'emplacement est disponible pour le vaisseau
        if (orientation == 'H') { // Horizontal
            if (colonne + type.getLargeur() > 10) {
                System.out.println("Placement invalide. Veuillez r�essayer.");
                return;
            }
            for (int i = 0; i < type.getLargeur(); i++) {
                if (grille[ligne][colonne + i] != ' ') {
                    System.out.println("Emplacement d�j� occup�. Veuillez r�essayer.");
                    return;
                }
            }
            // Placer le vaisseau
            for (int i = 0; i < type.getLargeur(); i++) {
                grille[ligne][colonne + i] = type.name().charAt(0);
            }
        } else if (orientation == 'V') { // Vertical
            if (ligne + type.getHauteur() > 8) {
                System.out.println("Placement invalide. Veuillez r�essayer.");
                return;
            }
            for (int i = 0; i < type.getHauteur(); i++) {
                if (grille[ligne + i][colonne] != ' ') {
                    System.out.println("Emplacement d�j� occup�. Veuillez r�essayer.");
                    return;
                }
            }
            // Placer le vaisseau
            for (int i = 0; i < type.getHauteur(); i++) {
                grille[ligne + i][colonne] = type.name().charAt(0);
            }
        }
    }

    public ResultatTir effectuerTir(String coordonnees) {
        int ligne = coordonnees.charAt(0) - 'A';
        int colonne = Integer.parseInt(coordonnees.substring(1)) - 1;

        // V�rifier si les coordonn�es sont valides
        if (ligne < 0 || ligne >= 8 || colonne < 0 || colonne >= 10) {
            return ResultatTir.HORS_GRILLE;
        }

        // V�rifier si le tir a d�j� �t� effectu� � cet endroit
        if (grilleTirs[ligne][colonne] != 0) {
            return ResultatTir.D�J�_TIR�;
        }

        // Marquer le tir sur la grille de tirs
        char cible = grille[ligne][colonne];
        grilleTirs[ligne][colonne] = 1; // Marquer comme "Touch�"

        // Mettre � jour l'�tat de la flotte en fonction du r�sultat du tir
        if (cible == 'U') {
            flotteUniverse--;
            if (flotteUniverse == 0) {
                return ResultatTir.D�SINT�GR�;
            } else {
                return ResultatTir.TOUCH�;
            }
        } else if (cible == 'S') {
            flotteSovereign--;
            if (flotteSovereign == 0) {
                return ResultatTir.D�SINT�GR�;
            } else {
                return ResultatTir.TOUCH�;
            }
        } else if (cible == 'A') {
            flotteAmbassador--;
            if (flotteAmbassador == 0) {
                return ResultatTir.D�SINT�GR�;
            } else {
                return ResultatTir.TOUCH�;
            }
        } else if (cible == 'C') {
            flotteConstitution--;
            if (flotteConstitution == 0) {
                return ResultatTir.D�SINT�GR�;
            } else {
                return ResultatTir.TOUCH�;
            }
        } else if (cible == 'N') {
            flotteNavette--;
            if (flotteNavette == 0) {
                return ResultatTir.D�SINT�GR�;
            } else {
                return ResultatTir.TOUCH�;
            }
        } else {
            return ResultatTir.LOUP�;
        }
    }

    public boolean flotteDetruite() {
        return flotteUniverse == 0 && flotteSovereign == 0 && flotteAmbassador == 0
                && flotteConstitution == 0 && flotteNavette == 0;
    }

    private int pourcentageFlotte() {
        int total = 3 * 2 + 2 * 2 + 3 * 1 + 3 * 1 + 2 * 1;
        int restant = flotteUniverse + flotteSovereign + flotteAmbassador + flotteConstitution + flotteNavette;
        return (restant * 100) / total;
    }
}

enum ResultatTir {
    TOUCH�("Touch�"),
    D�SINT�GR�("D�sint�gr�"),
    LOUP�("Loup�"),
    HORS_GRILLE("Hors Grille"),
    D�J�_TIR�("D�j� Tir�");

    private final String message;

    ResultatTir(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}