package fr.lixtec.form10.j1.tp.tp3;

import java.util.List;
import fr.lixtec.form10.j1.tp.tp3.Board.Cell;

public abstract class SpaceShip {
	
	protected String id;
	protected String name;
	protected boolean isPlaced = false;
	protected int w;
	protected int h;
	protected List<Cell> cells;
	
	public static class Universe extends SpaceShip {
		public Universe() {
			id = "U";
			name = "Universe";
			w = 3;
			h = 2;
		}
	}
	
	public static class Sovereign extends SpaceShip {
		public Sovereign() {
			id = "S";
			name = "Sovereign";
			w = 2;
			h = 2;
		}
	}
	
	public static class Ambassador extends SpaceShip {
		public Ambassador() {
			id = "A";
			name = "Ambassador";
			w = 3;
			h = 1;
		}
	}
	
	public static class Constitution extends SpaceShip {
		public Constitution() {
			id = "C";
			name = "Constitution";
			w = 3;
			h = 1;
		}
	}
	
	public static class Shuttle extends SpaceShip {
		public Shuttle() {
			id = "N";
			name = "Shuttle";
			w = 2;
			h = 1;
		}
	}
	
	public float getShipState() {
		float n_cell = cells.size();
		float t_cell = n_cell;
		for (Cell c : cells) {
			if (c.reveal)
				t_cell--;
		}
		
		return t_cell / n_cell;
	}
}
