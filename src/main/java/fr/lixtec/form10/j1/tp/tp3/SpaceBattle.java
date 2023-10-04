package fr.lixtec.form10.j1.tp.tp3;

public class SpaceBattle {

	public static void main(String[] args) {
		
		Utils.enableAnsi();
		Utils.cls();
		
		Board b = new Board();
		b.draw(1,1);
		
		Utils.disableAnsi();
		
	}

}
