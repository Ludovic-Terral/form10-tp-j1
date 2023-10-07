import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player[] players = new Player[2];
                 players[0] = new Player();
                 players[1] = new Player();
        Scanner s = new Scanner(System.in);
        
        int currentPlayer = 0;
        for (int i=0; i<2; i++) {
            while (true) {
                System.out.format(
                    "Joueur %d. Veuillez placer votre vaisseau de classe Universe en donnant la colonne, puis la rangé, puis soit v soit h pour le placer verticalement ou horizontalement.\n",
                    i);
                int col = s.nextInt();
                int row = s.nextInt();
                char direction = s.next(".").charAt(0);
                boolean vertical;
                switch(direction) {
                    case 'v':
                    case 'V':
                        vertical = true;
                        break;
                    
                    case 'h':
                    case 'H':
                        vertical = false;
                        break;
                        
                    default:
                        continue;
                }
                if (players[i].ships.placeShip('u', col, row, vertical)) {
                    break;
                }
            }
        }
        while (players[invert(currentPlayer)].hp.totalHpPercent() > 0) {
            
        }
    }
    
    private static int invert(int x) { return x==0 ? 1 : 0; }
}

class ShipGrid { // contains ship info
    private char[][] content = new char[10][8];
    public char[][] get() { return content; }
    private boolean[] placed = new boolean[(int)'z'+1]; // poor man's char to boolean dictionary 

    public boolean placeShip(char shipClass, int leftmostColumn, int topmostRow, boolean vertical /* horizontal if false */) {
        int shipLength, shipWidth;
        if (leftmostColumn < 0 || topmostRow < 0|| placed[(int)shipClass]) {
            return false; // each ship class can only be set once
        }
        switch (shipClass) {
            case 'u': shipLength = 3; shipWidth = 2; break;
            case 's': shipLength = 2; shipWidth = 2; break;
            case 'a': shipLength = 3; shipWidth = 1; break;
            case 'c': shipLength = 3; shipWidth = 1; break;
            case 'n': shipLength = 2; shipWidth = 1; break;
            default: return false; // unknown ship class
        }
        if (vertical) { // swapping dimensions 
            int tmp = shipLength;
            shipLength = shipWidth;
            shipWidth = tmp;
        }
        
        // cloning array to generate new grid after placement
        char[][] newContent = new char[10][8];
        for (int i=0; i<10; i++)
            newContent[i] = content[i].clone();
        
        // placing ship
        for (int col = leftmostColumn; col < leftmostColumn + shipLength; col++) {
            for (int row = topmostRow; row < topmostRow + shipWidth; row++) {
                if (col >= 10 || row >= 8 || newContent[col][row] != '\0') {
                    return false; // can't superpose ships
                }
                else {
                    newContent[col][row] = shipClass;
                }
            }
        }
        
        // ship was valid, update grid
        placed[(int)shipClass] = true;
        content = newContent;
        return true; // success!
    }
    
    public void print() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int row = 0; row < 8; row++) {
            System.out.format("%c", row+'a');
            for (int col = 0; col < 10; col++) {
                System.out.format(" %c", content[col][row]);
            }
            System.out.println();
        }
    }
}

class HitGrid { // grid of where there were attacks
    private char[][] content = new char[10][8];
    public char[][] get() { return content; }
    
    public boolean hit(char status, int column, int row) {
        if (content[column][row] != '\0') {
            return false;
        }
        switch (status) {
            case 'h': // hit
            case 'm': // miss
            case 's': // sink
                content[column][row] = status;
                return true;
            
            default:
                return false;
        }
    }
}

class ShipData {
    public final int uMaxHp = 6,
                     sMaxHp = 4,
                     aMaxHp = 3,
                     cMaxHp = 3,
                     nMaxHp = 2;
          
    public int uHp = 6,
               sHp = 4,
               aHp = 3,
               cHp = 3,
               nHp = 2;
        
    public int uHpPercent() { return 100 * uHp / uMaxHp; }
    public int sHpPercent() { return 100 * sHp / sMaxHp; }
    public int aHpPercent() { return 100 * aHp / aMaxHp; }
    public int cHpPercent() { return 100 * cHp / cMaxHp; }
    public int nHpPercent() { return 100 * nHp / nMaxHp; }
    public int totalHpPercent() { 
        return 100 * (uHp+sHp+aHp+cHp+nHp)
                   / (uMaxHp+sMaxHp+aMaxHp+cMaxHp+nMaxHp);
    }
}

class Player {
    public ShipData hp = new ShipData();
    public HitGrid hits = new HitGrid();
    public ShipGrid ships = new ShipGrid();
}
