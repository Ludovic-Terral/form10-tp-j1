package fr.lixtec.form10.j1.tp.tp3;

public class Constitution extends Vaisseau {
    public Constitution() {
        super("Constitution", 3, 1, 6);
    }
    
    @Override
    public char getSymbole() {
        return 'C';
    }

	@Override
	public void afficherInfos() {
	}
}
