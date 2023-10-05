package fr.lixtec.form10.j1.tp.tp3;

public class SpaceBattle {

	private enum GameState {
		PLACE(0), FIGHT(0), END(0);
		
		private int player;
		public int player() { return player; }
		
		GameState(int player) {
			this.player = player;
		}
		
		public void nextPlayer() {
			player = player == 1 ? 2 : 1;
		}
	}
	
	private GameState state = GameState.PLACE;
	private Board board1 = new Board();
	private Board board2 = new Board();
	
	private Board getCurrentBoard() {
		return state.player() == 1 ? board1 : board2;
	}
	
	public void run() {
		while (state != GameState.END) {
			
			state.nextPlayer();
			
			switch (state) {
			case PLACE:
				boolean placed = place();
				state = placed ? GameState.FIGHT : state;
				break;
			case FIGHT:
				boolean end = fight();
				state = end ? GameState.END : state;
				break;
			case END:
				// Never reached
				break;
			}
		}
		
		end();
	}
	
	private boolean place() {
		Board board = getCurrentBoard();
		
		System.out.println("PLACE Player " + state.player());
		
		return state.player() == 2;
	}
	
	private boolean fight() {
		Board board = getCurrentBoard();
		
		System.out.println("FIGHT Player " + state.player());
		
		return false;
	}
	
	private void end() {
		System.out.println("END");
	}
	
	public static void main(String[] args) {
		
		SpaceBattle game = new SpaceBattle();
		game.run();
		
	}

}
