package fr.lixtec.form10.j1.tp.tp3;

public class Universe extends Vaisseau {
    public Universe() {
        super("Universe", 3, 2, 6);

    }
    
    
    @Override
    public void afficherInfos() {
    }
    
    @Override
    public char getSymbole() {
        return 'U';
    }
    
}
