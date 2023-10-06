package fr.lixtec.form10.j1.tp.tp3;

public class Ambassadeur extends Vaisseau {
    public Ambassadeur() {
        super("Ambassadeur", 3, 1, 6);
    }
    
    @Override
    public char getSymbole() {
        return 'A';
    }

	@Override
	public void afficherInfos() {
	}
}
