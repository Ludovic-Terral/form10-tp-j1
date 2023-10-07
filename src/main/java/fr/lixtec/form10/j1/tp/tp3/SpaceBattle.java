package fr.lixtec.form10.j1.tp.tp3;

import java.util.Scanner;
import java.util.regex.Pattern;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

import static fr.lixtec.form10.j1.tp.tp3.Utils.print;

public class SpaceBattle {
	
	public static int INPUT_POSITION = 22;
	public static int MESSAGE_POSITION = INPUT_POSITION + 1;
	public static int PLAYER_BOARD_X = 3;
	public static int PLAYER_BOARD_Y = 5;
	public static int ENEMY_BOARD_X = PLAYER_BOARD_X;
	public static int ENEMY_BOARD_Y = 50;
	public static int FLEET_Y = 50;
	public static int FLEET_X = 3;
	
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
	
	private static Scanner sc = new Scanner(System.in);
	
	private GameState state = GameState.PLACE;
	private Board board1 = new Board();
	private Board board2 = new Board();
	
	private Board getCurrentBoard() {
		return state.player() == 1 ? board1 : board2;
	}
	
	private Board getOtherBoard() {
		return state.player() == 1 ? board2 : board1;
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
		String message = "";
		String player_input = "";
		
		while (!board.fleetPlaced()) {
			
			Utils.cls();
			print("Player " + state.player() + ", place your fleet!");
			
			board.draw(PLAYER_BOARD_X, PLAYER_BOARD_Y);
			
			print(ansi().cursor(FLEET_X, FLEET_Y));
			print("To Place:");
			int i = 1;
			for (SpaceShip s : board.shipToPlace()) {
				print(ansi().cursor(FLEET_X+i, FLEET_Y));
				print("(%s) %s [%d * %d]".formatted(s.id, s.name, s.w, s.h));
				i++;
			}
			
			print(ansi().cursor(MESSAGE_POSITION, 0));
			print(ansi().fg(RED).a(message).reset());
			
			print(ansi().cursor(INPUT_POSITION, 0));
			print(">> ");
			player_input = sc.nextLine();
			
			message = checkPlacementInput(player_input);
			if (message.equals(""))
				message = board.place(player_input);
		}
		
		Utils.cls();
		print("Player " + state.player() + ", place your fleet!");
		board.draw(PLAYER_BOARD_X, PLAYER_BOARD_Y);
		
		print(ansi().cursor(INPUT_POSITION, 0));
		print("Press ENTER to continue ...");
		sc.nextLine();
		
		return state.player() == 2;
	}
	
	public String checkPlacementInput(String input) {
		boolean ret = Pattern.compile(
			"^\\s*[USACNusacn]\\s*,\\s*[A-Ha-h]([1-9]|10)\\s*,\\s*[HVhv]\\s*$"
		).matcher(input).matches();
		return ret ? "" : "Invalid input. Usage : <U/S/A/C/N, A1-H10, H/V>";
	}
	
	private boolean fight() {
		Board board = getCurrentBoard();
		Board enemy = getOtherBoard();
		String message = "";
		String player_input = "";
		
		Utils.cls();
		print("Player " + state.player() + " turn");
		board.draw(PLAYER_BOARD_X, PLAYER_BOARD_Y);
		
		print(ansi().cursor(FLEET_X, FLEET_Y));
		print("Fleet state: %.2f%%".formatted(board.getFleetState() * 100));
		int i = 1;
		for (SpaceShip s : board.getFleet()) {
			print(ansi().cursor(FLEET_X+i, FLEET_Y));
			print("%s %.2f%%".formatted(s.name, s.getShipState() * 100));
			if (s.getShipState() == 0.0f)
				print(" (disintegrated)");
			i++;
		}
		
		print(ansi().cursor(INPUT_POSITION, 0));
		print("Press ENTER to continue ...");
		sc.nextLine();
		
		do {
			
			Utils.cls();
			print("Player " + state.player() + " turn");
			
			board.draw(PLAYER_BOARD_X, PLAYER_BOARD_Y);
			enemy.draw(ENEMY_BOARD_X, ENEMY_BOARD_Y, true);
			
			print(ansi().cursor(MESSAGE_POSITION, 0));
			print(ansi().fg(RED).a(message).reset());
			
			print(ansi().cursor(INPUT_POSITION, 0));
			print(">> ");
			player_input = sc.nextLine();
			
			message = checkAttackInput(player_input);
			if (message.equals("")) {
				message = enemy.attack(player_input);
				break;
			}
			
		} while (!message.equals(""));
		
		Utils.cls();
		print("Player " + state.player() + " turn");
		enemy.draw(PLAYER_BOARD_X, PLAYER_BOARD_Y, true);
		
		print(ansi().cursor(MESSAGE_POSITION, 0));
		Color color = message.equals("Failed") ? RED : GREEN;
		print(ansi().fg(color).a(message).reset());
		
		print(ansi().cursor(INPUT_POSITION, 0));
		print("Press ENTER to continue ...");
		sc.nextLine();
		
		return enemy.getFleetState() == 0.0f;
	}
	
	public String checkAttackInput(String input) {
		boolean ret = Pattern.compile(
			"^\\s*[A-Ha-h]([1-9]|10)\\s*$"
		).matcher(input).matches();
		return ret ? "" : "Invalid coordinates";
	}
	
	private void end() {
		Utils.cls();
		print(board1.getFleetState() == 0.0f ? "Player 2 win!" : "Player 1 win!");
	}
	
	public static void main(String[] args) {
		
		SpaceBattle game = new SpaceBattle();
		game.run();		
		
		sc.close();
	}

}
