package fr.lixtec.form10.j1.tp.tp3;

import static fr.lixtec.form10.j1.tp.tp3.Utils.print;
import static fr.lixtec.form10.j1.tp.tp3.SpaceShip.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import static org.fusesource.jansi.Ansi.*;

public class Board {
	
	/* Inner class */
	public class Cell {
		/* Constants */
		// Symbols used for drawing
		private static final char TOP_LEFT_CORNER = '┌';
		private static final char TOP_RIGHT_CORNER = '┐';
		private static final char MIDDLE_LEFT_CORNER = '├';
		private static final char MIDDLE_RIGHT_CORNER = '┤';
		private static final char BOTTOM_LEFT_CORNER = '└';
		private static final char BOTTOM_RIGHT_CORNER = '┘';
		private static final char TOP_JOINT = '┬';
		private static final char BOTTOM_JOINT = '┴';
		private static final char MIDDLE_JOINT = '┼';
		private static final char HORIZONTAL_SPACER = '─';
		private static final char VERTICAL_SPACER = '│';
		
		/* Fields */
		int x;
		int y;
		char c = ' ';
		boolean reveal = false;
		
		/* Constructors */
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		/* Methods */
		public void draw(boolean hidden) {
			for (int i = -2; i <= 2; i++)
			{
				for (int j = -1; j <= 1; j++)
				{
					center();
					print(ansi().cursorMove(i, j));
					if (i == 0 && j == 0)
						drawContent(hidden);
					else if ((Math.abs(i) == 1 || i == 0) && j != 0)
						print(HORIZONTAL_SPACER);
					else if (Math.abs(i) == 2 && j == 0)
						print(VERTICAL_SPACER);
					else if (Math.abs(i) + Math.abs(j) == 3)
						drawCorner(i+j);
				}
			}
		}
		
		private void drawCorner(int corner) {
			switch (corner) {
			case -3:
				if (x == 1 && y == 1)
					print(TOP_LEFT_CORNER);
				else if (x == 1)
					print(TOP_JOINT);
				else if (y == 1)
					print(MIDDLE_LEFT_CORNER);
				else
					print(MIDDLE_JOINT);
				break;
			case 3:
				if (x == Board.this.h && y == Board.this.w)
					print(BOTTOM_RIGHT_CORNER);
				else if (x == Board.this.h)
					print(BOTTOM_JOINT);
				break;
			case -1:
				if (x == Board.this.h && y == 1)
					print(BOTTOM_LEFT_CORNER);
				break;
			case 1:
				if (x == 1 && y == Board.this.w)
					print(TOP_RIGHT_CORNER);
				else if (y == Board.this.w)
					print(MIDDLE_RIGHT_CORNER);
				break;
			}
		}
		
		private void drawContent(boolean hidden) {
			if (hidden) {
				if (reveal)
					print(c == ' '
						? ansi().fg(Color.RED).a('F').reset()
						: ansi().fg(Color.GREEN).a('S').reset()
					);
				else
					print(' ');
			} else {
				if (reveal)
					print(ansi().fg(Color.RED));
				else 
					print(ansi().fg(Color.GREEN));
				print(c);
				print(ansi().reset());
			}
		}
		
		public void center() {
			print(ansi().cursor(Board.this.x + (2 * this.x), (Board.this.y - 1) + 4 * this.y));
		}
	}
	
	/* Constants */
	// Dimension limits and defaults
	public static final int DEFAULT_WIDTH = 10;
	public static final int DEFAULT_HEIGHT = 8; // A-H
	public static final int MIN_WIDTH = 3; // Universe ship: 3*2
	public static final int MAX_WIDTH = 20; // Default ratio for area
	public static final int MIN_HEIGHT = 2;
	public static final int MAX_HEIGHT = 26; // A-Z
	public static final int DEFAULT_AREA = DEFAULT_WIDTH * DEFAULT_HEIGHT;
	public static final int MIN_AREA = 18; // Space occupied by all ships
	public static final int MAX_AREA = MAX_WIDTH * MAX_HEIGHT;
	
	/* Fields */
	// private fields
	private int w;
	private int h;
	private int x;
	private int y;
	private List<Cell> cells;
	private List<SpaceShip> fleet;
	
	/* Constructors & destructor */
	public Board() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public Board(int w, int h) throws IllegalArgumentException {
		int area = w * h;
		
		boolean is_dimension_valid = true;
		is_dimension_valid = is_dimension_valid && (area >= MIN_AREA && area <= MAX_AREA);
		is_dimension_valid = is_dimension_valid && (w >= MIN_WIDTH && w <= MAX_WIDTH);
		is_dimension_valid = is_dimension_valid && (h >= MIN_HEIGHT && h <= MAX_HEIGHT);
		if (!is_dimension_valid)
			throw new IllegalArgumentException("Board dimension is not valid");
		
		this.w = w;
		this.h = h;
		
		createCells();
		createFleet();
	}
	
	/* Getters */
	public int getWidth() {
		return w;
	}
	
	public int getHeight() {
		return h;
	}
	
	/* Methods */
	private void createCells() {
		cells = new ArrayList<>();
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= w; j++) {
				cells.add(this.new Cell(i, j));
			}
		}
	}
	
	private Cell getCell(String position) {
		int x = position.charAt(0) - 'A' + 1;
		int y = Integer.parseInt(position.substring(1));
		
		return cells.stream().filter(c -> c.x == x && c.y == y).findFirst().orElse(null);
	}
	
	private List<Cell> getCells(int fromX, int fromY, int toX, int toY) {
		return cells.stream()
			.filter(c -> c.x >= fromX && c.x <= toX && c.y >= fromY && c.y <= toY)
			.collect(Collectors.toList());
	}
	
	public void draw(int x, int y, boolean hidden) {
		this.x = x;
		this.y = y;
		
		gotoOrigin();
		// TODO: not well rendered if w > 10
		for (int i = 0; i < w; i++)
			print("   " + (i + 1));
		gotoOrigin();
		for (int i = 0; i < h; i++) {
			print("\n\n");
			print(ansi().cursorRight(y-1));
			print(Character.toString('A' + i));
		}
		
		cells.forEach(c -> c.draw(hidden));
	}
	
	public void draw(int x, int y) {
		draw(x, y, false);
	}
	
	private void gotoOrigin() {
		print(ansi().cursor(x, y));
	}
	
	public void createFleet() {
		fleet = new ArrayList<>();
		fleet.add(new Universe());
		fleet.add(new Sovereign());
		fleet.add(new Ambassador());
		fleet.add(new Constitution());
		fleet.add(new Shuttle());
	}
	
	public SpaceShip getShip(String id) {
		return fleet.stream().filter(s -> s.id.equals(id)).findFirst().orElse(null);
	}
	
	public String place(String placement) {
		String[] args = placement.split(",");
		
		String ship_id = args[0].trim().toUpperCase();
		String position = args[1].trim().toUpperCase();
		String orientation = args[2].trim().toUpperCase();
		
		Cell topLeft = getCell(position);
		SpaceShip ship = getShip(ship_id);
		
		if (ship.isPlaced)
			return "Ship already placed!";
		
		int fromX = topLeft.x;
		int fromY = topLeft.y;
		int toX = orientation.equals("V") ? fromX + ship.w - 1 :fromX  + ship.h - 1;
		int toY = orientation.equals("V") ? fromY + ship.h - 1 :fromY  + ship.w - 1;
		
		if (toX > h || toY > w)
			return "Position is out of bound!";
		
		List<Cell> shipSpace = getCells(fromX, fromY, toX, toY);
		
		for (Cell c : shipSpace) {
			if (c.c != ' ')
				return "Position already occupied!";
		}
		
		for (Cell c : shipSpace) {
			c.c = ship.id.charAt(0);
		}
		
		ship.isPlaced = true;
		ship.cells = shipSpace;
		
		return "";
	}
	
	public boolean fleetPlaced() {
		for (SpaceShip s : fleet) {
			if (!s.isPlaced)
				return false;
		}
		return true;
	}
	
	public List<SpaceShip> shipToPlace() {
		return fleet.stream()
			.filter(s -> !s.isPlaced)
			.collect(Collectors.toList())
		;
	}
	
	public String attack(String coordinate) {
		Cell cell = getCell(coordinate.toUpperCase());
		cell.reveal = true;
		return cell.c == ' ' ? "Failed" : "Success";
	}
	
	public float getFleetState() {
		float n_cell = 0;
		for (SpaceShip s : fleet) {
			n_cell += s.cells.size();
		}
		
		float t_cell = n_cell;
		
		for (SpaceShip s : fleet) {
			for (Cell c : s.cells) {
				if (c.reveal)
					t_cell--;
			}
		}
		
		return t_cell / n_cell;
	}
	
	public List<SpaceShip> getFleet() {
		return fleet;
	}
	
}
