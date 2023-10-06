package fr.lixtec.form10.j1.tp.tp3;

public class Sovereign extends Vaisseau {
    public Sovereign() {
        super("Sovereign", 2, 2, 6);
    }
    
    @Override
    public char getSymbole() {
        return 'S';
    }

	@Override
	public void afficherInfos() {
	}
}
